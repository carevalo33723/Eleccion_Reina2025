package ar.com.eleccion.reina.Service;

import java.util.List; 
import ar.com.eleccion.reina.Entity.Juez;

public interface IJuezService {

    public void crearJuez(Juez juez);
	
	public void eliminarJuez(Long id_juez);
	
	public void editarJuez(Long id_juez, Juez juez);
	
	public Juez buscarJuez(Long id_juez);
	
	public List<Juez> listarJuez();
	
	public Juez BuscarJuezXMAil (String email);
	
}
