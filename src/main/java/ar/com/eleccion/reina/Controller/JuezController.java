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
import ar.com.eleccion.reina.Entity.Juez;
import ar.com.eleccion.reina.Service.IJuezService;

@RestController
@RequestMapping("/juez")
public class JuezController {

	@Autowired
	private IJuezService servJuez;
	
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
