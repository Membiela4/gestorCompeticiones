package Grupo3.GestorCompeticiones.interfacesDAO;

import Grupo3.GestorCompeticiones.model.DO.Participacion;

public interface iParticipacionDAO<T> {
	
	String muestraParticipacion();
	
	 boolean insertaParticipacion(Participacion<T> p);
	
	Participacion<T> buscaPartipacion(int dorsal);
	
	boolean eliminaParticipacion(Participacion<T> p);
}
