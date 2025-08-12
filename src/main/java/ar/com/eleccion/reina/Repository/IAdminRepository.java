package ar.com.eleccion.reina.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.eleccion.reina.Entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Long>{
	
	Admin findByEmail(String email);

}
