package ar.com.eleccion.reina.Service;

import java.util.List;

import ar.com.eleccion.reina.Entity.ganadorasDTO;

public interface IActaService {
	
	List<ganadorasDTO> obtenerTop3Candidatas();

}
