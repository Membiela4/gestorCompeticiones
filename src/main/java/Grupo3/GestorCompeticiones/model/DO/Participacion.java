package Grupo3.GestorCompeticiones.model.DO;

import java.util.Date;

import Grupo3.GestorCompeticiones.controlador.ControladorGimnasta;
import Grupo3.GestorCompeticiones.controlador.ControladorGrupo;
import Grupo3.GestorCompeticiones.model.DAO.GimnastaDAO;
import Grupo3.GestorCompeticiones.utils.Utils;

public class Participacion<T> {

	private int dorsal;
	private String horaInicio;
	private int puntos=0;
	private T partincipante;
	
	public Participacion(int dorsal, String horaInicio, int puntos, T partincipante) {
		super();
		this.dorsal = dorsal;
		this.horaInicio = horaInicio;
		this.puntos = puntos;
		this.partincipante = partincipante;
	}

	public Participacion() {
		super();
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public T getPartincipante() {
		return partincipante;
	}

	public void setPartincipante(T partincipante) {
		this.partincipante = partincipante;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dorsal;
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
		Participacion other = (Participacion) obj;
		if (dorsal != other.dorsal)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PARTICIPACION \ndorsal: " + dorsal + "\nHora Inicio: " + horaInicio + "\nPuntos: " + puntos
				+ "\nPartincipante: " + partincipante;
	}
	
	
	public Participacion<T> crearParticipacionGimnasta() {
		
		Participacion p = new Participacion();
		
		p.setDorsal(Utils.leeEntero("Introduce dorsal de la participacion"));
		p.setHoraInicio(Utils.leeString("Introduce la hora de inicio de la participacion"));
		p.setPuntos(Utils.leeEntero("Introduce puntuacion alcanzada"));
		Gimnasta g = GimnastaDAO.buscaGimnasta(Utils.validaDNI("Introduce el DNI del gimnasta que deseas añadir"));
		p.setPartincipante(g);
		
		return p;
		
	}
	
	public Participacion crearParticipacionGrupo() {
		
		Participacion p = new Participacion();
		
		p.setDorsal(Utils.leeEntero("Introduce dorsal de la participacion"));
		p.setHoraInicio(Utils.leeString("Introduce la hora de inicio de la participacion"));
		p.setPuntos(Utils.leeEntero("Introduce puntuacion alcanzada"));
		
		
		return p;
		
	}
	
	
	
	
}
