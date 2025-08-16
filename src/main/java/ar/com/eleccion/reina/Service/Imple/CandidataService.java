package ar.com.eleccion.reina.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Repository.ICandidataRepository;
import ar.com.eleccion.reina.Service.ICandidataService;

@Service
public class CandidataService implements ICandidataService{

	@Autowired
	private ICandidataRepository repoCandidata;

	@Override
	public void crearCandidata(Candidata candidata) {
		
	repoCandidata.save(candidata);
		
	}

	@Override
	public void eliminarCandidata(Long id_candidata) {
		
		repoCandidata.deleteById(id_candidata);
	}

	@Override
	public void editarCandidata(Long id_candidata, Candidata candidata) {
	
		Candidata candidataB = this.buscarCandidata(id_candidata);
		
		candidataB.setDni(candidata.getDni());
		candidataB.setNombre(candidata.getNombre());
		candidataB.setApellido(candidata.getApellido());
		candidataB.setEleccion(candidata.getEleccion());
		candidataB.setEvaluaciones(candidata.getEvaluaciones());
		
		this.crearCandidata(candidataB);
		
	}

	@Override
	public Candidata buscarCandidata(Long id_candidata) {
		
		return repoCandidata.findById(id_candidata).orElse(null);
	}

	@Override
	public List<Candidata> listarCandidatas() {
		
		return repoCandidata.findAll();
	}

	@Override
	public List<Candidata> BuscarCandidataPorElecccion(Long id) {
		
		return repoCandidata.findByEleccionId(id);
	}

	
	
}
