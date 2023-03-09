package Grupo3.GestorCompeticiones.interfaces.repo;

import Grupo3.GestorCompeticiones.model.DO.Participacion;

public interface iRepoParticipacion<T> {
	
	String muestraParticipacion();
	
	 boolean insertaParticipacion(Participacion<T> p);
	
	Participacion<T> buscaPartipacion(int dorsal);
	
	boolean eliminaParticipacion(Participacion<T> p);
}
