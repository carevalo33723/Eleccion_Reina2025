package ar.com.eleccion.reina.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Service.IEleccionService;

@Controller
@RequestMapping("/eleccion")
public class EleccionController {

	@Autowired
	private IEleccionService servEleccion;
	
	@PostMapping("/crear")
	public String crearEleccion(Eleccion eleccion) {
		
		servEleccion.crearEleccion(eleccion);
		
		return "Guardado Correctamente";
	}
	
	@PostMapping("/eliminar")
	public String eliminarEleccion(Long id_eleccion) {
		
		servEleccion.eliminarEleccion(id_eleccion);
		
		return "Eliminado Correctamente";
	}
	
	@PostMapping("/editar")
	public String editarEleccion(Long id_eleccion,Eleccion eleccion) {
		
		servEleccion.editarEleccion(id_eleccion, eleccion);
		
		return "Editado Correctamente";
	}
	
	@GetMapping("/buscar")
	public String buscarEleccion(Long id_eleccion) {
		
		servEleccion.buscarEleccion(id_eleccion);
		
		return "buscado";
	}
	
	@GetMapping("/listar")
	public String listarElecciones() {
		
		servEleccion.listarElecciones();
		
		return "lista";
	}
	
	
}
