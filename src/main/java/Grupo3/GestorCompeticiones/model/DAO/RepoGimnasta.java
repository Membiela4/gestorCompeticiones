package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;

import Grupo3.GestorCompeticiones.interfaces.repo.iRepoGimnasta;
import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.*;

public class RepoGimnasta implements iRepoGimnasta {
	VistaGimnasta vistaGimnasta = new VistaGimnasta();
	
	public Gimnasta crearGimnasta() {
		

		Gimnasta g = new Gimnasta();
		
		g.setDni(Utils.validaDNI("Introduce DNI del participante"));
		g.setNombre(Utils.leeString("Introduce nombre del participante"));
		g.setTelefono(Utils.validaTLF("Introduce el telefono del participante"));
		g.setCorreo(Utils.leeString("Introduce correo del participante"));
		g.setClub(Utils.leeString("Introduce club del participante"));
		g.setCategoria(Utils.validaCategoria("Introduce la categoria del participante"));
		
	
		vistaGimnasta.volverMostrarFederacion();
		return g;
	}

	public void  muestraGimnastas() {
		
		
	
		vistaGimnasta.volverMostrarFederacion();
		
	}

	public boolean insertaGimnasta(Gimnasta g) {
		boolean result=false;
			
		
		
		return result;
	}

	public Gimnasta buscaGimnasta(String dni) {
		
		
		return null;
	}

	public boolean eliminaGinmasta(Gimnasta g) {
		
		
		return false;
	}


	
}
