package ar.com.eleccion.reina.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Service.IEleccionService;

@Controller
@RequestMapping("/eleccion")
public class EleccionController {

	@Autowired
	private IEleccionService servEleccion;
	
	
	@GetMapping("/alta")
	public String crear(Model model) {		
		Eleccion nuevaElec = new Eleccion();		
		model.addAttribute("ele", nuevaElec);			
		return "Eleccion/alta-eleccion";
	}
	
	@PostMapping("/crear")
	public String crearEleccion(Eleccion eleccion,RedirectAttributes redirectAttrs) {		
		servEleccion.crearEleccion(eleccion);
		redirectAttrs.addFlashAttribute("mostrarModal", true);
		return "redirect:/eleccion/alta";
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
