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
	private Long id;
	
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
	
	public Eleccion(Long id, String nombre, String tipo, LocalDate fecha, List<Juez> juez, List<Candidata> candidata,
			List<Jurado> jurado, List<Actividad> actividades) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.fecha = fecha;
		this.juez = juez;
		this.candidata = candidata;
		this.jurado = jurado;
		this.actividades = actividades;
	}




	@OneToMany(mappedBy = "eleccion")
	private List<Candidata> candidata;
	
	@OneToMany(mappedBy = "eleccion")
	private List<Jurado> jurado;
	
	@OneToMany(mappedBy = "eleccion")
	private List<Actividad> actividades;
	








	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
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








	public List<Candidata> getCandidata() {
		return candidata;
	}




	public void setCandidata(List<Candidata> candidata) {
		this.candidata = candidata;
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









	









	public Eleccion() {
		super();
		// TODO Auto-generated constructor stub
	}




	
}
