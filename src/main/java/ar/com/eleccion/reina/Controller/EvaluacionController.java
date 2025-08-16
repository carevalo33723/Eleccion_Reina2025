package ar.com.eleccion.reina.Controller;


import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Entity.Evaluacion;
import ar.com.eleccion.reina.Entity.Item;
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Entity.ProximaEvaluacionDTO;
import ar.com.eleccion.reina.Service.IActividadService;
import ar.com.eleccion.reina.Service.ICandidataService;
import ar.com.eleccion.reina.Service.IEvaluacionService;
import ar.com.eleccion.reina.Service.IJuradoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/jurado")
public class EvaluacionController {
	@Autowired
	private IEvaluacionService evaluacionService;

	@Autowired
	private IJuradoService juradoRepo;
	
	@Autowired
	 private IActividadService actividadRepo;
	
	@Autowired
	ICandidataService candidataRepo;
	
	/**
	 * seleccionar actividad
	 */
	@GetMapping("/carga")
	public String mostrarActividades(@AuthenticationPrincipal UserDetails user, Model model) {
	    Jurado jurado = juradoRepo.BuscarJuradoXMAil(user.getUsername());
	    Eleccion eleccion = jurado.getEleccion();

	    if (eleccion == null) {
	        return "evaluacion/error"; // o vista de error
	    }

	    // Obtener y ordenar las actividades de esa elección
	    List<Actividad> actividades = new ArrayList<>(eleccion.getActividades());
	    actividades.sort(Comparator.comparingInt(Actividad::getNumero));

	    // Mandamos todo a la vista
	    model.addAttribute("jurado", jurado);
	    model.addAttribute("eleccion", eleccion);
	    model.addAttribute("actividades", actividades);
	    model.addAttribute("hoy", java.time.LocalDate.now());


	    return "evaluacion/seleccionarActividad";
	}
	//sacamos de la galera para el capo del jurado no trabaje
	@PostMapping("/seleccionarActividad")
	public String seleccionarActividad(@RequestParam("actividadId") Long actividadId,
	                                    @RequestParam("eleccionId") Long eleccionId,
	                                    HttpSession session) {
	    // Guardamos selección en sesión
	    session.setAttribute("actividadId", actividadId);
	    session.setAttribute("eleccionId", eleccionId);

	    // Redirigimos directo a evaluar
	    return "redirect:/jurado/evaluar";
	}

	/**
	 * Muestra el formulario de carga de evaluaciones
	 */
	 
	@GetMapping("/evaluar")
	public String evaluarActividad( HttpSession session,
	                               @AuthenticationPrincipal UserDetails user,
	                               Model model) {
		
		// Recuperamos actividad y elección de la sesión
	    Long actividadId = (Long) session.getAttribute("actividadId");
	    Long eleccionId = (Long) session.getAttribute("eleccionId");

	    if (actividadId == null || eleccionId == null) {
	        return "redirect:/jurado/carga"; // Si no hay datos en sesión, vuelve a cargar
	    }

	    Jurado jurado = juradoRepo.BuscarJuradoXMAil(user.getUsername());
	    Actividad actividad = actividadRepo.buscarActividad(actividadId);
	    
	 

	    // Ordenar items
	    List<Item> items = new ArrayList<>(actividad.getItems());
	    items.sort(Comparator.comparingInt(Item::getOrden));

	    
	    
	    List<Candidata> todas = new ArrayList<>(candidataRepo.listarCandidatas());
	    for (Object o : todas) {
	        System.out.println("Tipo real: " + o.getClass().getName());
	    }
	    
	    List<Candidata> candidatas = new ArrayList<>();

	 // Filtrar candidatas por id de elección
	 for (Candidata c : todas) {
	     if (c.getEleccion() != null && c.getEleccion().getId().equals(eleccionId)){
	         candidatas.add(c);
	     }
	 }
		
	    
	   System.out.println(candidatas);
		 candidatas.sort(Comparator.comparingLong(Candidata::getId)); 

	    // Buscar la primera evaluación pendiente
	    for (Candidata candidata : candidatas) {
	        for (Item item : items) {

	            boolean yaEvaluado = false;

	            for (Evaluacion ev : candidata.getEvaluaciones()) {
	                if (ev.getJurado() != null && ev.getJurado().getId().equals(jurado.getId()) &&
	                    ev.getItem() != null && ev.getItem().getId().equals(item.getId())) {
	                    yaEvaluado = true;
	                    break;
	                }
	            }

	            if (!yaEvaluado) {
	                // Mostramos formulario para esta candidata + item
	                ProximaEvaluacionDTO pendiente = new ProximaEvaluacionDTO(candidata, item, actividad, jurado);
	                model.addAttribute("evaluacion", pendiente);
	                model.addAttribute("hoy", java.time.LocalDate.now());
	                return "evaluacion/evluacionForm";
	            }
	        }
	    }

	    // Si llegamos acá, todas las candidatas + items fueron evaluadas poe y cerramos session por si las moscas
	    session.removeAttribute("actividadId");
	    session.removeAttribute("eleccionId");
	    return "Layaut/index";
	}



	    @PostMapping("/guardar")
	    public String guardarEvaluacion(@AuthenticationPrincipal UserDetails user,
	                                    @RequestParam Long candidataId,
	                                    @RequestParam Long itemId,
	                                    @RequestParam int nota) {
	        Jurado jurado = juradoRepo.BuscarJuradoXMAil(user.getUsername());
	        evaluacionService.guardarEvaluacion(jurado, candidataId.intValue(), itemId.intValue(), nota);

	        return "redirect:/jurado/evaluar";
	    }

	    @GetMapping
	    public String inicioJurado() {
	        return "/"; // vista principal del jurado
	    }

}
