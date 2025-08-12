package ar.com.eleccion.reina.Service.Imple;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Repository.IActividadRepository;
import ar.com.eleccion.reina.Service.IActividadService;

@Service
public class ActividadService implements IActividadService{

	@Autowired
	private IActividadRepository repoActividad;
	
	@Override
	public void crearActividad(Actividad actividad) {
		repoActividad.save(actividad);
	}

	@Override
	public void eliminarActividad(Long id_actividad) {		
		repoActividad.deleteById(id_actividad);	
	}

	@Override
	public void editarActividad(Long id_actividad, Actividad actividad) {
		
		Actividad actividadB = this.buscarActividad(id_actividad);
		
		actividadB.setNombre(actividad.getNombre());
		actividadB.setNumero(actividad.getNumero());
		actividadB.setEleccion(actividad.getEleccion());
		actividadB.setItems(actividad.getItems());
		
		this.crearActividad(actividadB);
	}

	@Override
	public Actividad buscarActividad(Long id_actividad) {
		return repoActividad.findById(id_actividad).orElse(null);
	}

	@Override
	public List<Actividad> listarActividades() {		
		return repoActividad.findAll();
	}
	
}
