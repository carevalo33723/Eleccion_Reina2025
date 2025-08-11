package ar.com.eleccion.reina.Entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Evaluacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_evaluacion;
	
	@Basic
	private int nota;
	private Boolean revision;
	
	@DateTimeFormat(pattern =  "yyyy-MM-dd")
	private LocalDate fecha;
	
	/**
	 * FIX = RELACION ENTRE CANDIDATA Y EVALUACION
	 */
	@ManyToOne
	@JoinColumn(name = "id_candidata")
	private Candidata candidata;
	/**
	 * FIX = RELACION ENTRE juez Y EVALUACION
	 */
	@ManyToOne
	@JoinColumn(name = "id_juez")
	private Juez juez;
	
	/**
	 * FIX = RELACION ENTRE JURADO Y EVALUACION
	 */
	@ManyToOne
	@JoinColumn(name = "id_jurado")
	private Jurado jurado;
	
	@ManyToOne
	@JoinColumn(name = "id_item")
	private Item item;

	public Evaluacion() {
		super();
	}

	public Evaluacion(Long id_evaluacion, int nota, Boolean revision, LocalDate fecha, Candidata candidata, Juez juez,
			Jurado jurado, Item item) {
		super();
		this.id_evaluacion = id_evaluacion;
		this.nota = nota;
		this.revision = revision;
		this.fecha = fecha;
		this.candidata = candidata;
		this.juez = juez;
		this.jurado = jurado;
		this.item = item;
	}

}
