package ar.com.eleccion.reina.Entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Eleccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_eleccion;
	
	@Basic
	private String nombre;
	private String tipo;
	
	@DateTimeFormat(pattern =  "yyyy-MM-dd")
	private LocalDate fecha;

	
	/**
	 * FIX=relacion uno a muchos con cada clase hija para que
	 * pertenescan a esta eleccion
	 */
	@OneToMany(mappedBy = "eleccion")
	private List<Juez> juez;
	@OneToMany(mappedBy = "eleccion")
	private List<Candidata> actores;
	
	@OneToMany(mappedBy = "eleccion")
	private List<Jurado> jurado;
	
	@OneToMany(mappedBy = "eleccion")
	private List<Actividad> actividades;
	



	public Long getId_eleccion() {
		return id_eleccion;
	}




	public void setId_eleccion(Long id_eleccion) {
		this.id_eleccion = id_eleccion;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public LocalDate getFecha() {
		return fecha;
	}




	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}




	public List<Juez> getJuez() {
		return juez;
	}




	public void setJuez(List<Juez> juez) {
		this.juez = juez;
	}




	public List<Candidata> getActores() {
		return actores;
	}




	public void setActores(List<Candidata> actores) {
		this.actores = actores;
	}




	public List<Jurado> getJurado() {
		return jurado;
	}




	public void setJurado(List<Jurado> jurado) {
		this.jurado = jurado;
	}




	public List<Actividad> getActividades() {
		return actividades;
	}




	public void setActividades(List<Actividad> actividades) {
		this.actividades = actividades;
	}




	public Eleccion(Long id_eleccion, String nombre, String tipo, LocalDate fecha, List<Juez> juez,
			List<Candidata> actores, List<Jurado> jurado, List<Actividad> actividades) {
		super();
		this.id_eleccion = id_eleccion;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.juez = juez;
		this.actores = actores;
		this.jurado = jurado;
		this.actividades = actividades;
	}




	public Eleccion() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Eleccion [id_eleccion=" + id_eleccion + ", nombre=" + nombre + ", tipo=" + tipo + ", fecha=" + fecha
				+ ", actores=" + actores + ", actividades=" + actividades + "]";
	}
	
}
