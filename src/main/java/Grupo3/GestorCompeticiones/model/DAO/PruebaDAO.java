package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;
import java.util.List;

import Grupo3.GestorCompeticiones.model.DO.Aparato;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.DO.TipoPrueba;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;

public class PruebaDAO {
	
	
	private static List<Prueba> listaPrueba(String nombre) {
		
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		List<Prueba> prub=null;
		for(Competicion c : competiciones) {
			if(c.getNombre().equalsIgnoreCase(nombre)) {
				prub= c.getPruebas();
				if(prub==null) {
					prub = new ArrayList<Prueba>();
					c.setPruebas((ArrayList<Prueba>) prub);
					rc.guardaXML();
					System.out.println();
				}else {
					prub= c.getPruebas();
					System.out.println("ok");
				}
			}
		}
		return prub;
		
		
	}
	
	public static boolean creaPrueba(String nombre, Prueba p) {
		boolean valid = false;
		RepoCompeticion rc = RepoCompeticion.newInstance();
				
			    
				if(!listaPrueba(nombre).contains(p)) {
					valid = listaPrueba(nombre).add(p);
				}else {
					Utils.mensaje("la prueba ya existe.");
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
		
				if(listaPrueba(nombre).contains(p)) {
					valid = listaPrueba(nombre).remove(p);
				}else {
					Utils.mensaje("la prueba no existe.");
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
			
			
			
				
					for(Prueba p : listaPrueba(nombre)) {
						if(p.getTipo().equals(tipo) && p.getCategoria().equals(categoria) && p.getAparato().equals(aparato)) {
							result = p;
						}
					}
				
				
			
			return result;
		}
		
		public static String mostrarPruebas(String nombre) {
			String result = " ";
			
					for(Prueba p : listaPrueba(nombre)) {
						result+= p+"\n";
					}
				
			return result;
		}
		
		public static boolean existePrueba (String nombre, Prueba p) {
			boolean valid = false;
			
					if(listaPrueba(nombre).contains(p)) {
						valid = true;
					}else {
					}
				
			
			return valid;
		}
		
}
