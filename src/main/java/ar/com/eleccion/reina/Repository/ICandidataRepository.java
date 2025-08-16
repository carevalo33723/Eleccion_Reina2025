package ar.com.eleccion.reina.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Entity.Eleccion;

@Repository
public interface ICandidataRepository extends JpaRepository<Candidata, Long>{
	
	List<Candidata> findByEleccionOrderByIdAsc(Eleccion eleccion);
	Candidata findById (int id);
	List<Candidata> findByEleccionId(Long id);

}
