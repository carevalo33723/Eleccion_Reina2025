package ar.com.eleccion.reina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ar.com.eleccion.reina.Entity.Juez;

@Repository
public interface IJuezRepository extends JpaRepository<Juez, Long>{

}
