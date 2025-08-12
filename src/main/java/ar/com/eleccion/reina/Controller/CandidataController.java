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
import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Service.ICandidataService;

@RestController
@RequestMapping("/candidata")
public class CandidataController {

	@Autowired
	private ICandidataService servCandidata;
	
	@PostMapping("/crear")
	public String crearCandidata(@RequestBody Candidata candidata) {
		
		servCandidata.crearCandidata(candidata);
		
		return "Candidata creada correctamente";
	}
	
	@DeleteMapping("/eliminar/{id_candidata}")
	public String eliminarCandidata(@PathVariable("id_candidata") Long id_candidata) {
		
		servCandidata.eliminarCandidata(id_candidata);
		
		return "Candidata eliminada correctamente";
	}
	
	@PutMapping("/editar/{id_candidata}")
	public Candidata editarCandidata(@PathVariable ("id_candidata") Long id_candidata,
			                         @RequestBody Candidata candidata) {
		
		servCandidata.editarCandidata(id_candidata, candidata);
		
		return servCandidata.buscarCandidata(id_candidata);
	}

	@GetMapping("/buscar/{id_candidata}")
	public Candidata buscarCandidata(@PathVariable ("id_candidata") Long id_candidata) {
		
		return servCandidata.buscarCandidata(id_candidata);
	}
	
	
	@GetMapping("/listar")
	public List <Candidata> listarCandidatas(){
		return servCandidata.listarCandidatas();	
	}
	
}
