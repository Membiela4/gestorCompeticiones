package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;
import java.util.Iterator;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;

public class GimnastaDAO {
	public static boolean creaGimnasta(Gimnasta g) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gims = rg.getGimnastas();
		boolean valid = gims.add(g);
		if(valid) {
			rg.guardaXML();
		}else {
			Utils.mensaje("Error al crear el gimnasta");
		}
		return valid;
	}
	
	public static boolean eliminaGimnasta (Gimnasta g) {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gims = rg.getGimnastas();
		boolean valid = gims.remove(g);
		if(valid) {
			rg.guardaXML();
		}else {
			Utils.mensaje("Error al eliminar el gimnasta");
		}
		return valid;
	}
	
	
	
	public static Gimnasta buscaGimnasta(String dni){
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gims = rg.getGimnastas();
		Iterator<Gimnasta> it = gims.iterator();
		boolean valid = false;
		Gimnasta result = null;
		while(it.hasNext() && valid==true) {
			Gimnasta aux = it.next();
			if(aux.getDni().equals(dni)) {
				 result = aux;
				 valid = true;
				
			}
		}
		return result;
	}
	
	public static String mostrarGimnastas() {
		String result= " ";
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gims = rg.getGimnastas();
		
		for(Gimnasta g : gims) {
			result+= g+"\n";
		}
		return result;
	}
}
