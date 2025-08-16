package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Eleccion;

public interface IEleccionService {

	 void crearEleccion(Eleccion eleccion);
	
	 void eliminarEleccion(Long id_eleccion);
	
	 void editarEleccion(Long id_eleccion, Eleccion eleccionEditada);
	
	 Eleccion buscarEleccion(Long id_eleccion);
	
	 List<Eleccion> listarElecciones();
	
}
