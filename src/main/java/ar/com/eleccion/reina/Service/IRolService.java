package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Rol;

public interface IRolService {
	
	List<Rol> listaROl();
	
	Rol buscarROl(Long id);

}
