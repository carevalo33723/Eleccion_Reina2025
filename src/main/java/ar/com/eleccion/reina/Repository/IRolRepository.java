package ar.com.eleccion.reina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.eleccion.reina.Entity.Rol;


@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{

}
