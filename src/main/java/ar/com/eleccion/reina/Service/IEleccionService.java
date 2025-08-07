package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Eleccion;

public interface IEleccionService {

	public void crearEleccion(Eleccion eleccion);
	
	public void eliminarEleccion(Long id_eleccion);
	
	public void editarEleccion(Long id_eleccion, Eleccion eleccionEditada);
	
	public Eleccion buscarEleccion(Long id_eleccion);
	
	public List<Eleccion> listarElecciones();
	
}
