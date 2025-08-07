package ar.com.eleccion.reina.Entity;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Actores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_actor;
	
	@Basic
	private String nombre;
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name = "id_eleccion")
	private Eleccion eleccion;
	
	@OneToMany(mappedBy = "actor")
	private List<Evaluacion> evaluaciones;
	
	public Actores() {
		super();
	}

	public Actores(Long id_actor, String nombre, String apellido, Eleccion eleccion, List<Evaluacion> evaluaciones) {
		super();
		this.id_actor = id_actor;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
		this.evaluaciones = evaluaciones;
	}

	public Long getId_actor() {
		return id_actor;
	}

	public void setId_actor(Long id_actor) {
		this.id_actor = id_actor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Eleccion getEleccion() {
		return eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	@Override
	public String toString() {
		return "Actores [id_actor=" + id_actor + ", nombre=" + nombre + ", apellido=" + apellido + ", eleccion="
				+ eleccion + ", evaluaciones=" + evaluaciones + "]";
	}
	
}
