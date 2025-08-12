package ar.com.eleccion.reina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.eleccion.reina.Entity.Jurado;

@Repository
public interface IJuradoRepository extends JpaRepository<Jurado, Long>{

}
