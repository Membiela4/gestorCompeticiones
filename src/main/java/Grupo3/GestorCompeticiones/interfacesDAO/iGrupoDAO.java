package Grupo3.GestorCompeticiones.interfacesDAO;

import Grupo3.GestorCompeticiones.model.DO.Grupo;

public interface iGrupoDAO {
	
	String muestraGrupo();
	
	boolean insertaGrupo(Grupo g);
	
	Grupo buscaGrupo(String nombre);
	
	boolean eliminaGrupo(Grupo g);
}
