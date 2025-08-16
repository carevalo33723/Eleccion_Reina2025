package ar.com.eleccion.reina.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.eleccion.reina.Entity.Actividad;
import ar.com.eleccion.reina.Entity.Candidata;
import ar.com.eleccion.reina.Entity.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer>{
	
	List<Item> findByActividadOrderByOrdenAsc(Actividad actividad);
	Item findById(int id_item);
	
}
