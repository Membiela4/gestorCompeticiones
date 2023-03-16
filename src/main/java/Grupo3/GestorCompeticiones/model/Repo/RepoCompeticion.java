package Grupo3.GestorCompeticiones.model.Repo;

import Grupo3.GestorCompeticiones.interfaces.repo.iRepoCompeticion;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.utils.XMLmanager;

public class RepoCompeticion implements iRepoCompeticion {

	
//	public void muestraCompeticion() {
//		
//		
//	}
	

	public boolean insertaCompeticion(Competicion c) {
		
		boolean result = false;
		
		if(XMLmanager.writeXML(c, "fichero.xml")) {
			result = true;
		}
		
		return result;
	}

	public Competicion buscaCompeticion(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean eliminaCompeticion(Competicion c) {
		// TODO Auto-generated method stub
		return false;
	}

}
