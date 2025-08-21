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

import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Service.ICandidataService;
import ar.com.eleccion.reina.Service.IEleccionService;

@Controller
@RequestMapping("/candidata")
public class CandidataController {

	@Autowired
	private ICandidataService servCandidata;
	
	@Autowired
	IEleccionService Eleervice;
	
	@GetMapping("/alta")
	public String crear(Model model) {		
		Candidata nuevaCand = new Candidata();	
		
		List<Eleccion> ele = Eleervice.listarElecciones();
		model.addAttribute("ele", ele);
		model.addAttribute("can", nuevaCand);			
		return "candidata/altaCandidata";
	}
	
	@PostMapping("/crear")
	public String crearCandidata( Candidata candidata,@RequestParam("eleccionId") Long eleccion) {
		
		Eleccion nueva = Eleervice.buscarEleccion(eleccion);
		
		candidata.setEleccion(nueva);
		servCandidata.crearCandidata(candidata);
		
		return "redirect:/candidata/alta";
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
	public String listarCandidatas(Model model){
		
		List<Candidata>candi=   servCandidata.listarCandidatas();
		
		model.addAttribute("candi", candi);
		
		return "candidata/litaCandidata";	
	}
	
}
