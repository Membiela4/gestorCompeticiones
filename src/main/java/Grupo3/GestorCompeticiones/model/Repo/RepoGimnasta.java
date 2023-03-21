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
	
@XmlTransient
private static final long serialVersonUID = 1L;


@XmlTransient
private static RepoGimnasta _instance;

@XmlElement(name="Gimnasta")
private ArrayList<Gimnasta> gimnastas;

private RepoGimnasta(boolean fake) {
	RepoGimnasta rg = XMLmanager.readXML(new RepoGimnasta(), "gimnastas.xml");
	this.gimnastas = rg.getGimnastas();
	if(this.gimnastas==null) {
		this.gimnastas = new ArrayList<>();
	}
	if(rg!=null) {
		this.gimnastas = rg.getGimnastas();
	}
}

private RepoGimnasta() {
	this.gimnastas = new ArrayList<>();
}

public static RepoGimnasta newInstance() {
	if(_instance ==null) {
		_instance = new RepoGimnasta(true);
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
	
	
	return XMLmanager.writeXML(this, "gimnastas.xml");
	
}


	
	

	

	
}
