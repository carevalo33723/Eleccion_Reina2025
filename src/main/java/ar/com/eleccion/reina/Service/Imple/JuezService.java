package ar.com.eleccion.reina.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Juez;
import ar.com.eleccion.reina.Repository.IJuezRepository;
import ar.com.eleccion.reina.Service.IJuezService;

@Service
public class JuezService implements IJuezService{

	@Autowired
	private IJuezRepository repoJuez;
	
	@Override
	public void crearJuez(Juez juez) {
		
		repoJuez.save(juez);
		
	}

	@Override
	public void eliminarJuez(Long id_juez) {
		
		repoJuez.deleteById(id_juez);
		
	}

	@Override
	public void editarJuez(Long id_juez, Juez juez) {
		
		Juez juezB = this.buscarJuez(id_juez);
		
		juezB.setDni(juez.getDni());
		juezB.setNombre(juez.getNombre());
		juezB.setApellido(juez.getApellido());
		juezB.setEleccion(juez.getEleccion());
		juezB.setEvaluaciones(juez.getEvaluaciones());
		
		this.crearJuez(juezB);
	}

	@Override
	public Juez buscarJuez(Long id_juez) {
	
		return repoJuez.findById(id_juez).orElse(null);
	}

	@Override
	public List<Juez> listarJuez() {
		
		return repoJuez.findAll();
	}

	
}
