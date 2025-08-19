package ar.com.eleccion.reina.Service.Imple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Entity.Evaluacion;
import ar.com.eleccion.reina.Entity.ganadorasDTO;
import ar.com.eleccion.reina.Service.IActaService;
import ar.com.eleccion.reina.Service.IAdminService;
import ar.com.eleccion.reina.Service.IEvaluacionService;

@Service
public class ActaService implements IActaService{
	
	
	@Autowired
	IEvaluacionService eva;

	
		@Override
		public List<ganadorasDTO> obtenerTop3Candidatas() {
		    List<Evaluacion> evaluaciones = eva.BuscarTodos();
		    Map<Candidata, Integer> puntajes = new HashMap<>();

		    // Sumar las notas por candidata
		    for (Evaluacion eval : evaluaciones) {
		        Candidata candidata = eval.getCandidata();
		        int nota = eval.getNota();

		        puntajes.put(candidata, puntajes.getOrDefault(candidata, 0) + nota);
		    }

		    // Convertir el map en lista de DTOs
		    List<ganadorasDTO> lista = new ArrayList<>();
		    for (Map.Entry<Candidata, Integer> entry : puntajes.entrySet()) {
		        Candidata candidata = entry.getKey();
		        Integer puntaje = entry.getValue();

		        lista.add(new ganadorasDTO(
		            candidata.getNombre(),
		            candidata.getApellido(),
		            candidata.getDni(),
		            puntaje
		        ));
		    }

		    // Ordenar la lista por puntaje (descendente)
		    Collections.sort(lista, new Comparator<ganadorasDTO>() {
		        public int compare(ganadorasDTO o1, ganadorasDTO o2) {
		            return Integer.compare(o2.getTotalPuntos(), o1.getTotalPuntos());
		        }
		    });

		    // Devolver solo los 3 primeros (o menos si no hay suficientes)
		    List<ganadorasDTO> top3 = new ArrayList<>();
		    for (int i = 0; i < lista.size() && i < 3; i++) {
		        top3.add(lista.get(i));
		    }

		    return top3;
		}


}
