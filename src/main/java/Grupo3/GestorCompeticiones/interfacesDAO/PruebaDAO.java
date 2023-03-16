package Grupo3.GestorCompeticiones.interfacesDAO;

import java.util.List;
import java.util.stream.Collectors;

import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.repo.RepoCompeticion;

public class PruebaDAO {
	public static boolean agregarPrueba(String nombreCompeticion, Prueba p) {
		boolean result = false;
		RepoCompeticion db = RepoCompeticion.newInstance();
		List<Competicion> comps = db.getCompeticiones();
		for(Competicion c : comps) {
			if(c.getNombre().equals(nombreCompeticion)) {
				//añadir la pruba
				//c.agregarPrueba(p);
				result =true;
				break;
			}
		}
		if(result) {
			db.setCompeticiones(comps);
			db.guardaXML();  //opcional, si no pues cuando te salgas del programa
		}
		return result;
	}
	
}
