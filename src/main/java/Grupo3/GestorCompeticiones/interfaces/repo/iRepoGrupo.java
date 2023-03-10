package Grupo3.GestorCompeticiones.interfaces.repo;

import Grupo3.GestorCompeticiones.model.DO.Grupo;

public interface iRepoGrupo {
	
	String muestraGrupo();
	
	boolean insertaGrupo(Grupo g);
	
	Grupo buscaGrupo(String nombre);
	
	boolean eliminaGrupo(Grupo g);
}
