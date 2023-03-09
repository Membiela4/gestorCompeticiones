package Grupo3.GestorCompeticiones.model.DO;

public class Persona {

	private String nombre;
	private String dni;
	private String telefono;
	private String correo;
	
	/*
	 * Constructores
	 */
	public Persona(String nombre, String dni, String telefono, String correo) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	

	/*
	 * Getters y setters
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	/*
	 * Hashcode y equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	
	/*
	 * toString
	 */


	@Override
	public String toString() {
		return "Persona \nNombre =  " + nombre + "\nDNI = " + dni + "\nTelefono = " + telefono + "\nCorreo = " + correo;
	}



	
	



	
}
