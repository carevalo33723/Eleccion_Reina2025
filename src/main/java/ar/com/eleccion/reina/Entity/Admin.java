package ar.com.eleccion.reina.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Admin extends Actores{
	
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;

	



	public Admin(String email, String password, Rol rol) {
		super();
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Long id, String nombre, String apellido, String dni) {
		super(id, nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	

	


	

	
	
	
	

}
