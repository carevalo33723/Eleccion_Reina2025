package ar.com.eleccion.reina.Controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Service.Imple.ActividadService;

@RestController
@RequestMapping("/actividad")
public class ActividadController {

	@Autowired
	private ActividadService servActividad;
	
	@PostMapping("/crear")
	public String crearActividad(@RequestBody Actividad actividad) {
		
		servActividad.crearActividad(actividad);
		
		return "Actividad creada correctamente";
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