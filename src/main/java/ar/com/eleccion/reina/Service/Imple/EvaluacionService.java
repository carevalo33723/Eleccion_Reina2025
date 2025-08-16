package ar.com.eleccion.reina.Service.Imple;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Entity.Eleccion;
import ar.com.eleccion.reina.Entity.Evaluacion;
import ar.com.eleccion.reina.Entity.Item;
import ar.com.eleccion.reina.Entity.Jurado;
import ar.com.eleccion.reina.Entity.ProximaEvaluacionDTO;
import ar.com.eleccion.reina.Repository.IActividadRepository;
import ar.com.eleccion.reina.Repository.ICandidataRepository;
import ar.com.eleccion.reina.Repository.IEvaluacionRepository;
import ar.com.eleccion.reina.Repository.IItemRepository;
import ar.com.eleccion.reina.Service.IEvaluacionService;

@Service
public class EvaluacionService implements IEvaluacionService {

	@Autowired
	private IActividadRepository actividadRepo;
	@Autowired
	private IItemRepository itemRepo;
	@Autowired
	private ICandidataRepository candidataRepo;
	@Autowired
	private IEvaluacionRepository evaluacionRepo;

	/*
	 * Eleccion eleccion = jurado.getEleccion();
	 * 
	 * List<Actividad> actividades =
	 * actividadRepo.findByEleccionOrderByNumeroAsc(eleccion); List<Candidata>
	 * candidatas = candidataRepo.findByEleccionOrderByIdAsc(eleccion);
	 * 
	 * for (Actividad actividad : actividades) { List<Item> items =
	 * itemRepo.findByActividadOrderByOrdenAsc(actividad); boolean pendiente =
	 * false;
	 * 
	 * for (Candidata candidata : candidatas) { for (Item item : items) { boolean
	 * yaEvaluado = evaluacionRepo.existsByJurado_IdAndCandidata_IdAndItem_Id(
	 * jurado.getId(), candidata.getId(), item.getId());
	 * System.out.println("Actividad: " + actividad.getNombre() + ", Candidata: " +
	 * candidata.getNombre() + ", Item: " + item.getNombre() + ", yaEvaluado: " +
	 * yaEvaluado); if (!yaEvaluado) { pendiente = true; break; // encontramos al
	 * menos un item pendiente } } if (pendiente) break; }
	 * 
	 * if (pendiente) { return Optional.of(actividad); } } return Optional.empty();
	 */
	

	@Override
	public void guardarEvaluacion(Jurado jurado, int candidataId, int itemId, int nota) {
		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setFecha(LocalDate.now());
		evaluacion.setNota(nota);
		evaluacion.setRevision(false);
		evaluacion.setJurado(jurado);
		Candidata candi = candidataRepo.findById(candidataId);
		evaluacion.setCandidata(candi);
		Item item = itemRepo.findById(itemId);
		evaluacion.setItem(item);

		evaluacionRepo.save(evaluacion);

	}

}
