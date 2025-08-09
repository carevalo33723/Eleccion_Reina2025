package ar.com.eleccion.reina.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Juez extends Actores{
	
	@OneToMany(mappedBy = "juez")
	private List<Evaluacion> evaluaciones;
	
	@ManyToOne
	@JoinColumn(name = "id_eleccion")
	private Eleccion eleccion;

	public Juez() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Juez(Long id, String nombre, String apellido, String dni) {
		super(id, nombre, apellido, dni);
		// TODO Auto-generated constructor stub
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
