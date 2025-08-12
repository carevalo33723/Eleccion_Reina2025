package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.Jurado;

public interface IJuradoService {

	public void crearJurado(Jurado jurado);
	
	public void eliminarJurado(Long id_jurado);
	
	public void editarJurado(Long id_jurado, Jurado jurado);
	
	public Jurado buscarJurado(Long id_jurado);
	
	public List<Jurado> listarJurados();
	
}