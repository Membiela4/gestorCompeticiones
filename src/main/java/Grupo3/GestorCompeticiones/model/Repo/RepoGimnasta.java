package Grupo3.GestorCompeticiones.model.Repo;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import Grupo3.GestorCompeticiones.controlador.ControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoGimnasta;
import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.utils.XMLmanager;

@XmlRootElement(name="Gimnastas")
@XmlAccessorType(XmlAccessType.FIELD)


public class RepoGimnasta implements iRepoGimnasta, Serializable {
	
private static final long serialVersonUID = 1L;

@XmlElement(name="Gimnasta")
private ArrayList<Gimnasta> gimnastas;
@XmlTransient
private static RepoGimnasta _instance;


private RepoGimnasta() {
	RepoGimnasta rg = XMLmanager.readXML(new RepoGimnasta(), "gimnastas.xml");
	this.gimnastas = rg.getGimnastas();
	if(this.gimnastas==null) {
		this.gimnastas = new ArrayList<>();
	}
}

public static RepoGimnasta newInstance() {
	if(_instance ==null) {
		_instance = new RepoGimnasta();
	}
	return _instance;
}


public ArrayList<Gimnasta> getGimnastas() {
	return gimnastas;
}


public void setGimnastas(ArrayList<Gimnasta> gimnastas) {
	this.gimnastas = gimnastas;
}

public boolean guardaXML() {
	boolean result = false;
	
	result = XMLmanager.writeXML(this, "Gimnastas.xml");
	return result;	
}


	
	

	

	
}