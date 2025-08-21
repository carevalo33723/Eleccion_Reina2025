package ar.com.eleccion.reina.Controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Entity.Juez;
import ar.com.eleccion.reina.Entity.Rol;
import ar.com.eleccion.reina.Service.IEleccionService;
import ar.com.eleccion.reina.Service.Imple.ActividadService;

@Controller
@RequestMapping("/actividad")
public class ActividadController {

	@Autowired
	private ActividadService servActividad;
	
	@Autowired	
	IEleccionService Eleervice;
	
	
	@GetMapping("/alta")
	public String crear(Model model) {		
		 Actividad actividad= new Actividad();	
		
		
		List<Eleccion> ele = Eleervice.listarElecciones();
		
		
		model.addAttribute("ele", ele);
		model.addAttribute("can", actividad);			
		return "actividad/altaActividad";
	}
	
	@PostMapping("/crear")
	public String crearActividad(Actividad actividad,@RequestParam("eleccionId") Long eleccion,RedirectAttributes redirectAttrs) {
		
		
		actividad.setEleccion(Eleervice.buscarEleccion(eleccion));
		servActividad.crearActividad(actividad);
		
		// Guardamos un flag para el modal
        redirectAttrs.addFlashAttribute("mostrarModal", true);
		return "redirect:/actividad/alta";
	}
	
	@DeleteMapping("/eliminar/{id_actividad}")
	public String eliminarActividad(@PathVariable("id_actividad") Long id_actividad) {
		
		servActividad.eliminarActividad(id_actividad);
		
		return "Actividad eliminada correctamente";
	}
	
	@PutMapping("/editar/{id_actividad}")
	public Actividad editarActividad(@PathVariable ("id_actividad") Long id_actividad,
			                         @RequestBody Actividad actividad) {
		
		servActividad.editarActividad(id_actividad, actividad);
		
		return servActividad.buscarActividad(id_actividad);
	}

	@GetMapping("/buscar/{id_actividad}")
	public Actividad buscarActividad(@PathVariable ("id_actividad") Long id_actividad) {
		
		return servActividad.buscarActividad(id_actividad);
	}
	
	
	@GetMapping("/listar")
	public List <Actividad> listarActividades(){
		return servActividad.listarActividades();	
	}
	
}