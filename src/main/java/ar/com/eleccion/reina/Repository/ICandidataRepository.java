package ar.com.eleccion.reina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.eleccion.reina.Entity.Candidata;

@Repository
public interface ICandidataRepository extends JpaRepository<Candidata, Long>{

}
