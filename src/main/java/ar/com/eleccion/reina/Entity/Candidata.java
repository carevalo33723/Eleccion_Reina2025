package ar.com.eleccion.reina.Entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Candidata extends Actores{
	
	@DateTimeFormat(pattern =  "yyyy-MM-dd")
	private LocalDate fecha;
	
	private String localidad;
	private String Institucion;
	
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

	public Candidata(LocalDate fecha, String localidad, String institucion,
			List<Evaluacion> evaluaciones, Eleccion eleccion) {
		super();
		this.fecha = fecha;
		
		this.localidad = localidad;
		Institucion = institucion;
		this.evaluaciones = evaluaciones;
		this.eleccion = eleccion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getInstitucion() {
		return Institucion;
	}

	public void setInstitucion(String institucion) {
		Institucion = institucion;
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
