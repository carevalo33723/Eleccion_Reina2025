package ar.com.eleccion.reina.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Entity.Evaluacion;
import ar.com.eleccion.reina.Entity.Item;
import ar.com.eleccion.reina.Entity.Juez;
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Service.IActividadService;
import ar.com.eleccion.reina.Service.ICandidataService;
import ar.com.eleccion.reina.Service.IEvaluacionService;
import ar.com.eleccion.reina.Service.IItemService;
import ar.com.eleccion.reina.Service.IJuezService;
import ar.com.eleccion.reina.Service.IJuradoService;

@Controller
@RequestMapping("/juez")
public class JuezController {

	@Autowired
	private IJuezService servJuez;
	
	@Autowired
	private IActividadService servActividad;
	
	@Autowired
	private IJuradoService servJurado;
	
	@Autowired
	private ICandidataService servCandidata;
	
	@Autowired
	private IItemService servItem;
	
	@Autowired
	private IEvaluacionService servEvaluacion;
	
	@GetMapping("/principal")
	public String pantallaPrincipal(@AuthenticationPrincipal UserDetails user ,Model model) {
		
		Juez juez = servJuez.BuscarJuezXMAil(user.getUsername());
		
		List<Actividad> actividades = servActividad.listarActividades();
		
		List<Jurado> jurados = servJurado.listarJurados();
		
		List<Candidata> candidatas = servCandidata.listarCandidatas();
		
		model.addAttribute("juez", juez);
		model.addAttribute("actividades", actividades);
		model.addAttribute("jurados", jurados);
		model.addAttribute("candidatas", candidatas);
		
		return "juez/juez";
	}
	
	@GetMapping("/detalle/evaluacion")
	public String verDetalleEvaluacion(@RequestParam Long actividadId,
	                                   @RequestParam Long juradoId,
	                                   Model model) {
		
		//traigo todas las evaluaciones del jurado seleccionado
		//luego guardo las evaluaciones en donde el item evaluado
		//tenga una relacion con la actividad elegida.
		//ya tendria todas las evaluaciones que el jurado hizo de esa actividad
		//enviar a la vista puntajes y ordenar todo o dto con( candidata, item, nota)?
		
        List<Evaluacion> todasEv = servEvaluacion.buscarEvaluacionesXJurado(juradoId);
        
        List<Evaluacion> evActividad = new ArrayList<>();
        
        for (Evaluacion ev : todasEv) {			
        	if (ev.getItem().getActividad().getId_actividad().equals(actividadId)) {				
        		evActividad.add(ev);
			}   	
		}
        
	    List<Candidata> candidatas = servCandidata.listarCandidatas();
	    
	    Actividad actividad = servActividad.buscarActividad(actividadId);
		List<Item> items = servItem.buscarItemsXActividad(actividad);
	   
	    model.addAttribute("candidatas", candidatas);
	    model.addAttribute("items", items);
        model.addAttribute("evaluaciones", evActividad);


	    return "juez/detalle";
	}
	

	
	
	
	
	
	
	
	
	
	
	@PostMapping("/crear")
	public String crearJuez(@RequestBody Juez juez) {
		
		servJuez.crearJuez(juez);
		
		return "Juez creado correctamente";
	}
	
	@DeleteMapping("/eliminar/{id_juez}")
	public String eliminarJuez(@PathVariable("id_juez") Long id_juez) {
		
		servJuez.eliminarJuez(id_juez);
		
		return "Juez eliminado correctamente";
	}
	
	@PutMapping("/editar/{id_juez}")
	public Juez editarJuez(@PathVariable ("id_juez") Long id_juez,
			                         @RequestBody Juez juez) {
		
		servJuez.editarJuez(id_juez, juez);
		
		return servJuez.buscarJuez(id_juez);
	}

	@GetMapping("/buscar/{id_juez}")
	public Juez buscarJuez(@PathVariable ("id_juez") Long id_juez) {
		
		return servJuez.buscarJuez(id_juez);
	}
	
	
	@GetMapping("/listar")
	public List <Juez> listarJuez(){
		return servJuez.listarJuez();	
	}
	
}
