package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.model.DO.Grupo;
import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;

public class GrupoDAO {
	public boolean creaGrupo(String dni, Grupo g ) {
		boolean valid = false;
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gims = rg.getGimnastas();
		for(Gimnasta gta : gims) {
			if(gta.getDni().equalsIgnoreCase(dni)) {
				
				valid = true;
				break;
			}
		}
		
		return valid;
	}
	
	public static boolean eliminaGrupo(Grupo g) {
		return true;
	}
	public static  Grupo buscaGrupo(String nombre ) {
		return null;
	}
	public static String mostrarGrupos() {
		return null;
	}
}
