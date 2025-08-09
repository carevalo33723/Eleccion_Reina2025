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

/**
 * FIX CAMBIO DE STRATEGY= Se genera una tabla por cada subclase de la jerarquía,
 *  repitiendo los atributos de la superclase, en cada tabla que representan a las 
 *  subclases.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public  class Actores {
	
	/**
	 * el id sera autoincremetal de la superclase
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Long id;
	
	@Basic
	private String nombre;
	private String apellido;
	private String dni;
	public Actores() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Actores(Long id, String nombre, String apellido, String dni) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	


	
	
	


	
	
}
