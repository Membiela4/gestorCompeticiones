package Grupo3.GestorCompeticiones.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.crypto.spec.RC2ParameterSpec;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorCompeticion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPruebas;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoCompeticion;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaCompeticion;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.utils.XMLmanager;
import Grupo3.GestorCompeticiones.vista.VistaCompeticion;

public class ControladorCompeticion implements iControladorCompeticion {
	
	ControladorPrincipal controladorPrincipal;
	List<Competicion> competiciones = new ArrayList();
   
	public void ejecutarMenuCompeticion() {
		int opcion;
		do {
			VistaCompeticion vistaCompeticion = new VistaCompeticion();
			vistaCompeticion.mostrarMenuCompeticion();
			opcion=Utils.leeEntero("Elige una opcion: ");
			controlarMenuCompeticion(opcion);	
		}while(opcion!=6);
	}
	
	public  void controlarMenuCompeticion(int opcion) {
		switch(opcion) {
		    case 0:
		    		volverMenuPrincipal();
		    		break;
			case 1:
					crearCompeticion();
					break;
			case 2:
					editarCompeticion();
					break;
			case 3:
					buscarCompeticion();
					break;
			case 4:
					eliminaCompeticion();
					break;
			case 5:
					muestraCompeticion();
					break;
			case 6:
					ejecutarMenuInsertarPrueba();
					break;
			default: 
				 Utils.mensaje("Vuelve a introducir una opcion");
				 break;
		}
		
	}
	
	//CRUD
	
	/*
	 * metodo que crea una competicion y la inserta en el xml, antes carga el xml y lo actualiza con la informacion actualizada
	 */
	
	public void crearCompeticion() {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();

		String nombre=Utils.leeString("\nIntroduce el nombre de la competicion");
		String descripcion=Utils.leeString("Introduce una descripcion");
		Date fechaInicio=Utils.validaFecha("Introduce la fecha de la competicion DD/MM/YYYY");
		ArrayList<Prueba> pruebas = new ArrayList<>();
		
		
		Competicion competicion = new Competicion(nombre, descripcion, fechaInicio,pruebas);
		if(competiciones.add(competicion)){
			Utils.mensaje("Competicion creada correctamente");
		}else {
			Utils.mensaje("Error al introducir competicion");
		}
		rc.guardaXML();
	}
	
	
	public Competicion insertarCompeticion() {
		
		String nombre=Utils.leeString("\nIntroduce el nombre de la competicion");
		String descripcion=Utils.leeString("Introduce una descripcion");
		Date fechaInicio=Utils.validaFecha("Introduce la fecha de la competicion DD/MM/YYYY");
		ArrayList<Prueba> pruebas = new ArrayList<>();
		Competicion competicion = new Competicion(nombre, descripcion, fechaInicio,pruebas);
		
		
		return competicion;
	}
	
	
	public void editarCompeticion() {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones  = rc.getCompeticiones();
		String nombre= Utils.leeString("Introduce el nombre de la competicion a editar");
		
		Iterator<Competicion> it = competiciones.iterator();
		Competicion competicion =null;
		
		while(it.hasNext()) {
			if(it.equals(nombre)) {
				String nuevoNombre=Utils.leeString("Introduce el nuevo nombre de la competicion");
				String nuevaDescripcion=Utils.leeString("Introduce una descripcion");
				Date nuevaFechaInicio=Utils.validaFecha("Introduce la fecha de la competicion");
				
				 competicion.setNombre(nuevoNombre);
			     competicion.setDescripcion(nuevaDescripcion);
			     competicion.setFechaInicio(nuevaFechaInicio);
			        
				break;
			}
			
				if(competiciones.add(competicion)) {
					rc.guardaXML();
				}else {
					Utils.mensaje("No se ha podido editar la competicion");
				}
		}
	
	}
	    
	public void buscarCompeticion() {
		RepoCompeticion rp = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rp.getCompeticiones();
		
		String comp=Utils.leeString("Introduce el nombre de la competicion ");
		
		Iterator<Competicion> it = competiciones.iterator();
		Competicion c = it.next();
		while(it.hasNext()) {
			if(c.getNombre().equals(comp)) {
				Utils.imprimeCompeticion(c);
				
			}
		}
	
	}
	
	
	public void eliminaCompeticion() {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		String nombre = Utils.leeString("Introduce el nombre de la competicion que deseas eliminar");
		
		Iterator<Competicion> it = competiciones.iterator();
		Competicion comp = it.next();
		Competicion c = it.next();
		while(it.hasNext()) {
			if(comp.equals(c.getNombre())) {
				competiciones.remove(c);
				break;
			}
		}
			rc.guardaXML();
	}
	
	public void eliminaCompeticion(Competicion c) {
		
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		
		Iterator<Competicion> it = competiciones.iterator();
		Competicion c2 = it.next();
		while(it.hasNext()) {
			if(c2.equals(c)) {
				competiciones.remove(c);
			}
		}
		rc.guardaXML();
	}
	public void muestraCompeticion() {
		RepoCompeticion rp = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rp.getCompeticiones();
		
		Iterator<Competicion> it = competiciones.iterator();
		Competicion c = it.next();
		
		while(it.hasNext()) {
			Utils.imprimeCompeticion(c);
		}
	}


	public void ejecutarMenuInsertarPrueba() {
		ControladorPruebas controladorPruebas = new ControladorPruebas();
		controladorPruebas.controlarMenuInsertarPrueba(0);
		}
	
	public void volverMenuPrincipal() {
		
		controladorPrincipal.controlarMenuPrincipal();
	}
	
	
}
