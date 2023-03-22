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
		boolean valid = false;
		if(!gims.contains(g)) {
			valid = gims.add(g);
		}else {
			Utils.mensaje("El gimnasta ya exixte");
		}
		
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
		boolean valid = false;
		if(gims.contains(g)) {
			 valid = gims.remove(g);
		}else {
			Utils.mensaje("El gimnasta que desea eliminar no existe.");
		}
		
		if(valid) {
			rg.guardaXML();
		}else {
			Utils.mensaje("Error al eliminar el gimnasta.");
		}
		return valid;
	}
	
	
	
	public static Gimnasta buscaGimnasta(String dni){
		Gimnasta result = null;
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gims = rg.getGimnastas();
		for(Gimnasta g : gims) {
			if(g.getDni().equals(dni)) {
				result = g;
				
			}
			
		}
		
		/*Iterator<Gimnasta> it = gims.iterator();
		boolean valid = false;
		
		while(it.hasNext() && valid==true) {
			System.out.println("ok");
			Gimnasta aux = it.next();
			if(aux.getDni().equals(dni)) {
				 result = aux;
				 valid = true;
				
			}
		}*/
		
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
