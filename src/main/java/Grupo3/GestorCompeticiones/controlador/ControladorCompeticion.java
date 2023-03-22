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
import Grupo3.GestorCompeticiones.model.DAO.CompeticionDAO;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.utils.XMLmanager;
import Grupo3.GestorCompeticiones.vista.VistaCompeticion;

public class ControladorCompeticion implements iControladorCompeticion {
	
	ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
	
   
	public void ejecutarMenuCompeticion() {
		int opcion;
		do {
			VistaCompeticion vistaCompeticion = new VistaCompeticion();
			vistaCompeticion.mostrarMenuCompeticion();
			opcion=Utils.leeEntero("Elige una opcion: ");
			controlarMenuCompeticion(opcion);	
		}while(opcion!=0);
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
		String nombre=Utils.leeString("\nIntroduce el nombre de la competicion");
		String descripcion=Utils.leeString("Introduce una descripcion");
		Date fechaInicio=Utils.validaFecha("Introduce la fecha de la competicion DD/MM/YYYY");
		ArrayList<Prueba> pruebas = new ArrayList<>();
		
		Competicion competicion = new Competicion(nombre, descripcion, fechaInicio, pruebas);
		if(CompeticionDAO.creaCompeticion(competicion)){
			Utils.mensaje("Competicion creada correctamente");
		}
		
	}
	
	
	
	
	
	public void editarCompeticion() {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		
		
		
		
		Competicion competicion =CompeticionDAO.buscaCompeticion(Utils.leeString("Introduce el nombre de la competicion a editar"));
		if(CompeticionDAO.existe(competicion)) {
			String nuevoNombre=Utils.leeString("Introduce el nuevo nombre de la competicion");
			String nuevaDescripcion=Utils.leeString("Introduce una descripcion");
			Date nuevaFechaInicio=Utils.validaFecha("Introduce la fecha de la competicion");
			
			 competicion.setNombre(nuevoNombre);
		     competicion.setDescripcion(nuevaDescripcion);
		     competicion.setFechaInicio(nuevaFechaInicio);
		     rc.guardaXML();
		}
		
				
				
		
	
	}
	    
	public void buscarCompeticion() {
		Utils.imprimeObjeto(CompeticionDAO.buscaCompeticion(Utils.leeString("Introduce el nombre de la Competicion a buscar: ")));
		
	
	}
	
	
	
	
	public void eliminaCompeticion() {
		if(CompeticionDAO.eliminaCompeticion(CompeticionDAO.buscaCompeticion(Utils.leeString("Introduce el nombre de la competicion que desea eliminar: ")))) {
			Utils.mensaje("La competicion se a eliminado correctamente.");
		}
		
	}
	public void muestraCompeticion() {
		String competiciones = new String();
		competiciones=CompeticionDAO.mostrarCompeticiones();
		Utils.imprimeObjeto(competiciones);
	}
	public void ejecutarMenuInsertarPrueba() {
		ControladorPruebas controladorPruebas = new ControladorPruebas();
		controladorPruebas.ejecutarMenuInsertarPrueba();
		}
	
	public void volverMenuPrincipal() {
		
		controladorPrincipal.controlarMenuPrincipal();
	}
	
	
}
