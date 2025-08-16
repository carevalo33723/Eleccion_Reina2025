package ar.com.eleccion.reina.Service;

import java.util.Optional;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Entity.ProximaEvaluacionDTO;

public interface IEvaluacionService {
	
	
	void guardarEvaluacion(Jurado jurado, int candidataId, int itemId, int nota);
}
