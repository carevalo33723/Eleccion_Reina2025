package ar.com.eleccion.reina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.eleccion.reina.Entity.Actividad;

@Repository
public interface IActividadRepository extends JpaRepository<Actividad, Long>{

}
