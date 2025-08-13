package ar.com.eleccion.reina.Entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Juez extends Actores{
	
	private String email;
	private String password;
	@ManyToOne
	@JoinColumn(name = "id_rol")
	private Rol rol;
	
	@OneToMany(mappedBy = "juez")
	private List<Evaluacion> evaluaciones;
	
	@ManyToOne
	@JoinColumn(name = "id_eleccion")
	private Eleccion eleccion;

	

	

	public Juez(String email, String password, Rol rol, List<Evaluacion> evaluaciones, Eleccion eleccion) {
		super();
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.evaluaciones = evaluaciones;
		this.eleccion = eleccion;
	}

	public Juez() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juez(Long id, String nombre, String apellido, String dni) {
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

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public Eleccion getEleccion() {
		return eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}

	
}
