package ar.com.eleccion.reina.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.eleccion.reina.Entity.Evaluacion;

public interface IEvaluacionRepository extends JpaRepository<Evaluacion, Long>{
	
	boolean existsByJurado_IdAndCandidata_IdAndItem_Id(Long juradoId, Long candidataId, Integer itemId);

	List<Evaluacion> findByJurado_Id(Long juradoId);
	
	
}
