package Grupo3.GestorCompeticiones.model.DO;

import java.util.ArrayList;
import java.util.List;

public class Prueba {

	private TipoPrueba tipo;
	private Categoria categoria;
	private Aparato aparato;
	private ArrayList<Participacion> participantes;

	
	public Prueba(TipoPrueba tipo, Categoria categoria, Aparato aparato, ArrayList<Participacion> participantes) {
		super();
		this.tipo = tipo;
		this.categoria = categoria;
		this.aparato = aparato;
		this.participantes = participantes;
	}
	
	public Prueba() {
		
	}
	
	
	public TipoPrueba getTipo() {
		return tipo;
	}

	public void setTipo(TipoPrueba tipo) {
		this.tipo = tipo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Aparato getAparato() {
		return aparato;
	}

	public void setAparato(Aparato aparato) {
		this.aparato = aparato;
	}

	public List<Participacion> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participacion> participantes) {
		this.participantes = participantes;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prueba other = (Prueba) obj;
		if (aparato != other.aparato)
			return false;
		if (categoria != other.categoria)
			return false;
		if (participantes == null) {
			if (other.participantes != null)
				return false;
		} else if (!participantes.equals(other.participantes))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	

	
	
	
}
