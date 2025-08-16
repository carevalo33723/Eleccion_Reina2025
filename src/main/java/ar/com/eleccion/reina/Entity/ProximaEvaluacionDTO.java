package ar.com.eleccion.reina.Entity;



public class ProximaEvaluacionDTO {
	
	private Candidata candidata;
    private Item item;
    private Actividad actividad;
    private Jurado jurado;
    
	public ProximaEvaluacionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProximaEvaluacionDTO(Candidata candidata, Item item, Actividad actividad, Jurado jurado) {
		super();
		this.candidata = candidata;
		this.item = item;
		this.actividad = actividad;
		this.jurado = jurado;
	}

	public Candidata getCandidata() {
		return candidata;
	}

	public void setCandidata(Candidata candidata) {
		this.candidata = candidata;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Jurado getJurado() {
		return jurado;
	}

	public void setJurado(Jurado jurado) {
		this.jurado = jurado;
	}
	
	

	
    

}
