package Grupo3.GestorCompeticiones.model.DO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Competicion {

	private String nombre;
	private String descripcion;
	private Date fechaInicio;
	private ArrayList<Prueba> pruebas;
	
	
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public List<Prueba> getPruebas() {
		return pruebas;
	}
	public void setPruebas(ArrayList<Prueba> pruebas) {
		this.pruebas = pruebas;
	}
	
	
	
	
	
	public Competicion(String nombre, String descripcion, Date fechaInicio, ArrayList<Prueba> pruebas) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.pruebas = pruebas;
		
	}

	public Competicion() {
		super();
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Competicion other = (Competicion) obj;
		if (nombre == null) {
			if (other.nombre != null) {
				return false;
			}
		} else if (!nombre.equals(other.nombre)) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "[COMPETICION] \nNombre: " + nombre + "\nDescripcion:" + descripcion + "\nFecha inicio: " + fechaInicio;
	}
	
	
	
	
}
