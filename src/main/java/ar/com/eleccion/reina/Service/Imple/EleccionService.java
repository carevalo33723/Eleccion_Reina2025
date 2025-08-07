package ar.com.eleccion.reina.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Repository.IEleccionRepository;
import ar.com.eleccion.reina.Service.IEleccionService;

@Service
public class EleccionService implements IEleccionService{

	@Autowired
	private IEleccionRepository repoEleccion;
	
	@Override
	public void crearEleccion(Eleccion eleccion) {
		
		repoEleccion.save(eleccion);
		
	}

	@Override
	public void eliminarEleccion(Long id_eleccion) {
		
		repoEleccion.deleteById(id_eleccion);
		
	}

	@Override
	public void editarEleccion(Long id_eleccion, Eleccion eleccionEditada) {
	
		Eleccion eleccionB = this.buscarEleccion(id_eleccion);
		
		eleccionB.setNombre(eleccionEditada.getNombre());
		eleccionB.setTipo(eleccionEditada.getTipo());
		eleccionB.setFecha(eleccionEditada.getFecha());
		
		this.crearEleccion(eleccionB);
		
	}

	@Override
	public Eleccion buscarEleccion(Long id_eleccion) {

		return repoEleccion.findById(id_eleccion).orElse(null);
	}

	@Override
	public List<Eleccion> listarElecciones() {
		
		return repoEleccion.findAll();
	}

}
