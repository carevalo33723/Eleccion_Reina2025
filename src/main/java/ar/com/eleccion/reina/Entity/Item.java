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
	private Integer id;
	
	@Basic
	private String nombre;
	private Integer orden;
	
	@ManyToOne
	@JoinColumn(name = "id_actividad")
	private Actividad actividad;
	
	@OneToMany(mappedBy = "item")
	private List<Evaluacion> evaluaciones;



	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}










	public Integer getId() {
		return id;
	}










	public void setId(Integer id) {
		this.id = id;
	}










	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getOrden() {
		return orden;
	}



	public void setOrden(Integer orden) {
		this.orden = orden;
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










	public Item(Integer id, String nombre, Integer orden, Actividad actividad, List<Evaluacion> evaluaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.orden = orden;
		this.actividad = actividad;
		this.evaluaciones = evaluaciones;
	}












	




	
	
}
