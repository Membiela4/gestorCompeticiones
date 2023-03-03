package Grupo3.GestorCompeticiones.model.DO;

import java.util.ArrayList;

public class Grupo {

	private String nombre;
	private String club;
	
	ArrayList<Gimnasta> gimnastas =new ArrayList();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public ArrayList<Gimnasta> getGimnastas() {
		return gimnastas;
	}

	public void setGimnastas(ArrayList<Gimnasta> gimnastas) {
		this.gimnastas = gimnastas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Grupo other = (Grupo) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo \nNombre: " + nombre + "\nClub: " + club;
	}
	
	
	public void mostrarGimnastas() {
		for (Gimnasta gimnasta : gimnastas) {
			System.out.println(gimnasta);
		}
	}
	
	
		
	
}
