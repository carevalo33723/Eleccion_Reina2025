package ar.com.eleccion.reina.Service;

import java.util.List;
import java.util.Map;

public interface IReporteService {

	
	byte[] ReporteGral(String ruta,List<?> datos,Map <String, Object> parametros) throws Exception;
}
