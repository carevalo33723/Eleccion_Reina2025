package ar.com.eleccion.reina.Entity;

public class ganadorasDTO {
	
	private String nombre;
    private String apellido;
    private String dni;
    private int totalPuntos;
	public ganadorasDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ganadorasDTO(String nombre, String apellido, String dni, int totalPuntos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.totalPuntos = totalPuntos;
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
	public int getTotalPuntos() {
		return totalPuntos;
	}
	public void setTotalPuntos(int totalPuntos) {
		this.totalPuntos = totalPuntos;
	}
	
    
    

}
