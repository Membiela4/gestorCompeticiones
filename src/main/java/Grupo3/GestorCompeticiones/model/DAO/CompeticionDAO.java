package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;

import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;

public class CompeticionDAO {
	public static boolean creaCompeticion(Competicion c) {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		boolean valid = false; 
		if(!competiciones.contains(c)) {
			valid = competiciones.add(c);
		}else {
			Utils.mensaje("La competicion ya exixte");
		}
		if(valid) {
			rc.guardaXML();
		}else {
			Utils.mensaje("Error al crear la competicion");
		}
		return valid;
	}
	
	public static boolean eliminaCompeticion(Competicion c) {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		boolean valid = false;
		if(competiciones.contains(c)) {
			valid= competiciones.remove(c);
		}else {
			Utils.mensaje("La competicion que desea eliminar no exixte");
		}
		if(valid) {
			rc.guardaXML();
		}else {
			Utils.mensaje("Error al elimiar la competicion");
			
		}
		return valid;
	}
	
	
	public static Competicion buscaCompeticion(String nombre) {
		Competicion result = null;
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		for(Competicion c : competiciones) {
			if(c.getNombre().equals(nombre)) {
				result = c;
			}
		}
		return result;
	
	}
	
	
	
	
	
	public static String mostrarCompeticiones() {
		String result=" ";
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		for(Competicion c : competiciones) {
			result+=c+"\n";
		}
		return result;
	}
	
	
	public static boolean existe(Competicion c) {
		boolean valid = false;
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		if(competiciones.contains(c)) {
			valid = true;
		}else {
			Utils.mensaje("la competicion no exixte.");
		}
		return valid;
	}
	
	
	
}
