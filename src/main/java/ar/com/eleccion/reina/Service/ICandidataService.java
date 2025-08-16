package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Candidata;

public interface ICandidataService {

    public void crearCandidata(Candidata candidata);
	
	public void eliminarCandidata(Long id_candidata);
	
	public void editarCandidata(Long id_candidata, Candidata candidata);
	
	public Candidata buscarCandidata(Long id_candidata);
	
	 List<Candidata> listarCandidatas();
	
	List<Candidata> BuscarCandidataPorElecccion ( Long id);
	
}
