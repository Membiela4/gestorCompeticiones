package Grupo3.GestorCompeticiones.interfaces.repo;

import Grupo3.GestorCompeticiones.model.DO.Competicion;

public interface iRepoCompeticion {
	
//	void muestraCompeticion();
	
	boolean insertaCompeticion(Competicion c);
	
	Competicion buscaCompeticion(String nombre);
	
	boolean eliminaCompeticion(Competicion c);
}
