package ar.com.eleccion.reina.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Eleccion;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Long>{
	
	
	List<Actividad> findByEleccionOrderByNumeroAsc(Eleccion eleccion);
	

}
