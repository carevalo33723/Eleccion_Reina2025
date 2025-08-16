package ar.com.eleccion.reina.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Candidata extends Actores{
	
	@OneToMany(mappedBy = "candidata")
	private List<Evaluacion> evaluaciones;
	
	@ManyToOne
	@JoinColumn(name = "id_eleccion")
	private Eleccion eleccion;

	public Candidata() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Candidata(Long id, String nombre, String apellido, String dni) {
		super(id, nombre, apellido, dni);
		// TODO Auto-generated constructor stub
	}

	public Candidata(List<Evaluacion> evaluaciones, Eleccion eleccion) {
		super();
		this.evaluaciones = evaluaciones;
		this.eleccion = eleccion;
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
