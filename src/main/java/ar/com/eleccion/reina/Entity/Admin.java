package ar.com.eleccion.reina.Entity;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Actores{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long id, String nombre, String apellido, String dni) {
		super(id, nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

}
