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
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Service.IJuradoService;

@RestController
@RequestMapping("/jurado")
public class JuradoController {

	@Autowired
	private IJuradoService servJurado;
	
	@PostMapping("/crear")
	public String crearJurado(@RequestBody Jurado jurado) {
		
		servJurado.crearJurado(jurado);
		
		return "Jurado creado correctamente";
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
