package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Jurado;

public interface IJuradoService {

	 void crearJurado(Jurado jurado);
	
	 void eliminarJurado(Long id_jurado);
	
	 void editarJurado(Long id_jurado, Jurado jurado);
	
	 Jurado buscarJurado(Long id_jurado);
	
	 List<Jurado> listarJurados();
	 
	 Jurado BuscarJuradoXMAil (String email);
	
}