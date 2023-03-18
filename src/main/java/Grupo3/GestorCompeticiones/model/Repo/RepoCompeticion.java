

package Grupo3.GestorCompeticiones.model.Repo;

import Grupo3.GestorCompeticiones.interfaces.repo.iRepoCompeticion;

import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.utils.XMLmanager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Competiciones")
@XmlAccessorType(XmlAccessType.FIELD)
public class RepoCompeticion implements iRepoCompeticion,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="Competicion")
	private ArrayList<Competicion> competiciones;
	@XmlTransient
	private static RepoCompeticion _instance;  //no incluida en el XML
	
	private RepoCompeticion() {
		RepoCompeticion rp = XMLmanager.readXML(new RepoCompeticion(), "Competicion.xml");
		this.competiciones = rp.getCompeticiones();
		if(this.competiciones==null) {
			this.competiciones = new ArrayList<>();
		}
	}
	public static RepoCompeticion newInstance() {
		if(_instance==null) {
			_instance = new RepoCompeticion();
		}
		return _instance;
	}
	
	public ArrayList<Competicion> getCompeticiones() {
		return competiciones;
	}
	
	
	public void setCompeticiones(ArrayList<Competicion> competiciones) {
		this.competiciones = competiciones;
	}
	public boolean guardaXML() {
		boolean result = false;
		result = XMLmanager.writeXML(this, "Competicion.xml");
		return result;	
	}
	
	
	public boolean insertaCompeticion(Competicion c) {
		
		boolean result = false;
		
		//CRUD add -> competiciones
		this.competiciones.add(c);
		//guarda en el archivo
		
		return result;
	}

	
	public Competicion buscaCompeticion(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean eliminaCompeticion(Competicion c) {
		// TODO Auto-generated method stub
		return false;
	}

}