package Grupo3.GestorCompeticiones.model.Repo;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import Grupo3.GestorCompeticiones.controlador.ControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoGimnasta;
import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.utils.XMLmanager;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso(Gimnasta.class)
public class RepoGimnasta implements iRepoGimnasta {
	ArrayList<Gimnasta> gimnastas = new ArrayList();

	ControladorPrincipal controladorPrincipal;
	

	public String muestraGimnastas() {
		String gim = null;
		XMLmanager.readXML(gimnastas, "gimnastas.xml");
		for (Gimnasta g : gimnastas) {
			  gim +=g;
			  
		}
		return gim;
		
	}

	public boolean insertaGimnasta(Gimnasta g) {
		boolean result=false;
		
		if(!gimnastas.contains(g) && g.getDni() !=null) {
			gimnastas.add(g);
			result = true;
		}else {
			Utils.mensaje("Error al insertar gimnasta");
		}
		
		
		

			return result;


	}
	
	public boolean GimnastaXML() {
		boolean result = false;
		
		if(XMLmanager.writeXML(this, "gimnastas.xml")) {
			result=true;
		}
		return result;
	}

	public Gimnasta buscaGimnasta(String dni) {
		
		RepoGimnasta g = XMLmanager.readXML(new RepoGimnasta(), "gimnastas.xml");
		this.gimnastas = g.gimnastas;
	
		return null;
	}

	public boolean eliminaGinmasta(Gimnasta g) {
		
		
		return false;
	}


	
}
