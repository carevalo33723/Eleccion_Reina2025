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
public class Actividad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_actividad;
	
	@Basic
	private int numero;
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "id_eleccion")
	private Eleccion eleccion;
	
	@OneToMany(mappedBy = "actividad")
	private List<Item> items;

	public Actividad() {
		super();
	}

	public Actividad(Long id_actividad, int numero, String nombre, Eleccion eleccion, List<Item> items) {
		super();
		this.id_actividad = id_actividad;
		this.numero = numero;
		this.nombre = nombre;
		this.eleccion = eleccion;
		this.items = items;
	}

	public Long getId_actividad() {
		return id_actividad;
	}

	public void setId_actividad(Long id_actividad) {
		this.id_actividad = id_actividad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Eleccion getEleccion() {
		return eleccion;
	}

	public void setEleccion(Eleccion eleccion) {
		this.eleccion = eleccion;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Actividad [id_actividad=" + id_actividad + ", numero=" + numero + ", nombre=" + nombre + ", eleccion="
				+ eleccion + ", items=" + items + "]";
	}
	
}
