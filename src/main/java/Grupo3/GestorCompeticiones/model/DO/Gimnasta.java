package Grupo3.GestorCompeticiones.model.DO;

import java.util.List;

public class Gimnasta extends Persona {
	
	private String dni=super.getDni();
	private Categoria categoria;
	private String club;
	private 
	/*
	 * Constructores
	 */

	public Gimnasta(String nombre, String dni, String telefono, String correo) {
		super(nombre, dni, telefono, correo);
		
	}
	
	public Gimnasta() {
		super("","","","");
		this.categoria=null;
		this.club=null;
	}
	

	/*
	 * Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gimnasta other = (Gimnasta) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}
	
	/*
	 * Getters and setters 
	 */

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	

	@Override
	public String toString() {
		return "[GIMNASTA]"+"\nNombre: " +super.toString() + "\nCategoria = " + categoria + "\nClub = " + club+"\n";
	}
	
	
	
}

