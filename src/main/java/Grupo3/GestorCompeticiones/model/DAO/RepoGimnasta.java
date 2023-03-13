package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;

import Grupo3.GestorCompeticiones.controlador.ControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoGimnasta;
import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.utils.XMLmanager;

public class RepoGimnasta implements iRepoGimnasta {

	ControladorPrincipal controladorPrincipal;
	
	public Gimnasta crearGimnasta() {
		

		Gimnasta g = new Gimnasta();
		
		g.setDni(Utils.validaDNI("Introduce DNI del participante"));
		g.setNombre(Utils.leeString("Introduce nombre del participante"));
		g.setTelefono(Utils.validaTLF("Introduce el telefono del participante"));
		g.setCorreo(Utils.leeString("Introduce correo del participante"));
		g.setClub(Utils.leeString("Introduce club del participante"));
		g.setCategoria(Utils.validaCategoria("Introduce la categoria del participante"));
		
		return g;
		
		
	}

	public void muestraGimnastas() {
		
		Utils.buscarMostrarObjetos();
	
		 
		
		
		
	}

	public boolean insertaGimnasta(Gimnasta g) {
		boolean result=false;
		
		if(XMLmanager.writeXML(g, "fichero.xml")) {
			result=true;
			Utils.mensaje("Gimasta introducido correctamente");
		}else {
			Utils.mensaje("Error al insertar gimnasta");
		}
			

			return result;


	}

	public Gimnasta buscaGimnasta(String dni) {
		
		XMLmanager.readXML(dni, "fichero.xml");
		
		return null;
		
	}

	public boolean eliminaGinmasta(Gimnasta g) {
		
		
		return false;
	}


	
}
