package ar.com.eleccion.reina.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Entity.Juez;
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Entity.Rol;
import ar.com.eleccion.reina.Service.IEleccionService;
import ar.com.eleccion.reina.Service.IJuradoService;
import ar.com.eleccion.reina.Service.IRolService;

@Controller
@RequestMapping("/jurado")
public class JuradoController {

	@Autowired
	private IJuradoService servJurado;
	@Autowired
	BCryptPasswordEncoder codificador;
	
	@Autowired
	IEleccionService Eleervice;
	
	@Autowired
	IRolService rol;
	
	@Autowired
	IJuradoService juradoService;
	
	@GetMapping("/alta")
	public String crear(Model model) {		
		Jurado jurado= new Jurado();	
		
		List<Rol> roles = rol.listaROl();
		List<Eleccion> ele = Eleervice.listarElecciones();
		
		model.addAttribute("ro", roles);
		model.addAttribute("ele", ele);
		model.addAttribute("can", jurado);			
		return "jurado/altaJurado";
	}
	
	@PostMapping("/crear")
	public String crearJurado(Jurado jurado,@RequestParam("eleccionId") Long eleccion,@RequestParam("rolId") Long roles,RedirectAttributes redirectAttrs) {
		
		jurado.setEleccion(Eleervice.buscarEleccion(eleccion));
		jurado.setRol(rol.buscarROl(roles));
		jurado.setPassword(codificador.encode(jurado.getPassword()));
		
		juradoService.crearJurado(jurado);
		// Guardamos un flag para el modal
        redirectAttrs.addFlashAttribute("mostrarModal1", true);
		return "redirect:/jurado/alta";
	}
	
	@DeleteMapping("/eliminar/{id_jurado}")
	public String eliminarJurado(@PathVariable("id_jurado") Long id_jurado) {
		
		servJurado.eliminarJurado(id_jurado);
		
		return "Jurado eliminado correctamente";
	}
	
	@PutMapping("/editar/{id_jurado}")
	public Jurado editarJurado(@PathVariable ("id_jurado") Long id_jurado,
			                         @RequestBody Jurado jurado) {
		
		servJurado.editarJurado(id_jurado, jurado);
		
		return servJurado.buscarJurado(id_jurado);
	}

	@GetMapping("/buscar/{id_jurado}")
	public Jurado buscarJurado(@PathVariable ("id_jurado") Long id_jurado) {
		
		return servJurado.buscarJurado(id_jurado);
	}
	
	
	@GetMapping("/listar")
	public List <Jurado> listarJurados(){
		return servJurado.listarJurados();	
	}

}
