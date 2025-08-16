package ar.com.eleccion.reina.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Repository.IJuradoRepository;
import ar.com.eleccion.reina.Service.IJuradoService;

@Service
public class JuradoService implements IJuradoService{

	@Autowired
	private IJuradoRepository repoJurado;

	@Override
	public void crearJurado(Jurado jurado) {
		 
		repoJurado.save(jurado);
		
	}

	@Override
	public void eliminarJurado(Long id_jurado) {
	
	repoJurado.deleteById(id_jurado);
		
	}

	@Override
	public void editarJurado(Long id_jurado, Jurado jurado) {
	
		Jurado juradoB = this.buscarJurado(id_jurado);
		
		juradoB.setDni(jurado.getDni());
		juradoB.setNombre(jurado.getNombre());
		juradoB.setApellido(jurado.getApellido());
		juradoB.setEleccion(jurado.getEleccion());
		juradoB.setEvaluaciones(jurado.getEvaluaciones());
		
		this.crearJurado(juradoB);
		
	}

	@Override
	public Jurado buscarJurado(Long id_jurado) {
		return repoJurado.findById(id_jurado).orElse(null);
	}

	@Override
	public List<Jurado> listarJurados() {
		return repoJurado.findAll();
	}

	@Override
	public Jurado BuscarJuradoXMAil(String email) {
		
		return repoJurado.findByEmail(email);
	}
	
	
	
	
}
