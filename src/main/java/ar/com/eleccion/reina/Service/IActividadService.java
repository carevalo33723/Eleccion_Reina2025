package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Actividad;

public interface IActividadService {
	
	 void crearActividad(Actividad actividad);
	
	 void eliminarActividad(Long id_actividad);
	
	 void editarActividad(Long id_actividad, Actividad actividad);
	
	Actividad buscarActividad(Long id_actividad);
	
	 List<Actividad> listarActividades();

}
