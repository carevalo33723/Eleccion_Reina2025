package ar.com.eleccion.reina.Entity;

import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_item;
	
	@Basic
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_actividad")
	private Actividad actividad;
	
	@OneToMany(mappedBy = "item")
	private List<Evaluacion> evaluaciones;

	public Item() {
		super();
	}

	public Item(Long id_item, String nombre, Actividad actividad, List<Evaluacion> evaluaciones) {
		super();
		this.id_item = id_item;
		this.nombre = nombre;
		this.actividad = actividad;
		this.evaluaciones = evaluaciones;
	}

	public Long getId_item() {
		return id_item;
	}

	public void setId_item(Long id_item) {
		this.id_item = id_item;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	@Override
	public String toString() {
		return "Item [id_item=" + id_item + ", nombre=" + nombre + ", actividad=" + actividad + ", evaluaciones="
				+ evaluaciones + "]";
	}
	
}
