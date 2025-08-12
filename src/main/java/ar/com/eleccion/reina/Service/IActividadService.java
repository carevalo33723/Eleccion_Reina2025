package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Actividad;

public interface IActividadService {
	
	public void crearActividad(Actividad actividad);
	
	public void eliminarActividad(Long id_actividad);
	
	public void editarActividad(Long id_actividad, Actividad actividad);
	
	public Actividad buscarActividad(Long id_actividad);
	
	public List<Actividad> listarActividades();

}
