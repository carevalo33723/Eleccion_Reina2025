package ar.com.eleccion.reina.Service.Imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Rol;
import ar.com.eleccion.reina.Repository.IRolRepository;
import ar.com.eleccion.reina.Service.IRolService;


@Service
public class RolService implements IRolService{

	
	@Autowired
	IRolRepository rol;
	
	@Override
	public List<Rol> listaROl() {
		
		return rol.findAll();
	}

	@Override
	public Rol buscarROl(Long id) {
		
		return rol.findById(id).orElse(null);
	}

}
