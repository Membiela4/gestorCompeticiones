package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;

import Grupo3.GestorCompeticiones.model.DO.Aparato;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.DO.TipoPrueba;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;

public class PruebaDAO {
	public static boolean creaPrueba(String nombre, Prueba p) {
		boolean valid = false;
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		for(Competicion c : competiciones) {
			if(c.getNombre().equalsIgnoreCase(nombre)) {
				if(!c.getPruebas().contains(p)) {
					//System.out.println("ok");
					valid = c.getPruebas().add(p);
				}else {
					Utils.mensaje("la prueba ya existe.");
				}
				
			}else {
				
			}
		}
		if(valid) {
			rc.guardaXML();
		}else{
			Utils.mensaje("Error al crear la prueba");
		}
		return valid;
		
	}
	
	public static boolean eliminaPrueba(String nombre, Prueba p) {
		boolean valid = false;
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		for(Competicion c : competiciones) {
			if(c.getNombre().equalsIgnoreCase(nombre)) {
				if(c.getPruebas().contains(p)) {
					valid = c.getPruebas().remove(p);
				}else {
					Utils.mensaje("la prueba no existe.");
				}
			}else {
				Utils.mensaje("Competicion incorrecta.");	
				break;
				}
		}
		if(valid) {
			rc.guardaXML();
		}else{
			Utils.mensaje("Error al eliminar la prueba");
		}
		return valid;
	}
	
		public static Prueba buscaPrueba(String nombre, TipoPrueba tipo, Categoria categoria, Aparato aparato) {
			Prueba result = null;
			RepoCompeticion rc = RepoCompeticion.newInstance();
			ArrayList<Competicion> competiciones = rc.getCompeticiones();
			for(Competicion c : competiciones) {
				if(c.getNombre().equalsIgnoreCase(nombre)) {
					for(Prueba p : c.getPruebas()) {
						if(p.getTipo().equals(tipo) && p.getCategoria().equals(categoria) && p.getAparato().equals(aparato)) {
							result = p;
						}
					}
				}else {
					Utils.mensaje("Competicion incorrecta.");
					break;
					}
			}
				
			
			return result;
		}
		
		public static String mostrarPruebas(String nombre) {
			String result = " ";
			RepoCompeticion rc = RepoCompeticion.newInstance();
			ArrayList<Competicion> competiciones = rc.getCompeticiones();
			for(Competicion c : competiciones) {
				if(c.getNombre().equalsIgnoreCase(nombre)) {
					for(Prueba p : c.getPruebas()) {
						result+= p+"\n";
					}
				}else {
					Utils.mensaje("Competicion incorrecta.");
					break;
					}
			}
			return result;
		}
		
		public static boolean existePrueba (String nombre, Prueba p) {
			boolean valid = false;
			RepoCompeticion rc = RepoCompeticion.newInstance();
			ArrayList<Competicion> competiciones = rc.getCompeticiones();
			for(Competicion c : competiciones) {
				if(c.getNombre().equalsIgnoreCase(nombre)) {
					if(c.getPruebas().contains(p)) {
						valid = true;
					}else {
						Utils.mensaje("la prueba no existe.");
					}
				}else {
					Utils.mensaje("Competicion incorrecta.");
					break;
				}
			}
			return valid;
		}
	
}
