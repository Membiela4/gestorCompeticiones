package Grupo3.GestorCompeticiones.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorCompeticion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPruebas;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoCompeticion;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaCompeticion;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaCompeticion;

public class ControladorCompeticion implements iControladorCompeticion {
	List<Competicion> competiciones = new ArrayList();
    RepoCompeticion repoComp;
    ControladorPruebas controladorPruebas = new ControladorPruebas();
    ControladorPrincipal controladorPrincipal;
    VistaCompeticion vistaCompeticion = new VistaCompeticion();
    
	public void ejecutarMenuCompeticion() {
		int opcion;
		do {
			vistaCompeticion.mostrarMenuCompeticion();
			opcion=Utils.leeEntero("Elige una opcion: ");
			controlarMenuCompeticion(opcion);	
		}while(opcion!=6);
	}
	
	public void controlarMenuCompeticion(int opcion) {
		switch(opcion) {
		    case 0:
		    		controladorPrincipal.controlarMenuPrincipal();
		    		break;
			case 1:
					crearCompeticion();
					break;
			case 2:
//					editarCompeticion();
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
	public void crearCompeticion() {

		String nombre=Utils.leeString("\nIntroduce el nombre de la competicion");
		String descripcion=Utils.leeString("Introduce una descripcion");
		Date fechaInicio=Utils.validaFecha("Introduce la fecha de la competicion DD/MM/YYYY");
		
		Competicion competicion = new Competicion(nombre, descripcion, fechaInicio);
		competiciones.add(competicion);
		Utils.mensaje("Competicion creada correctamente");
	}
	
	
//	public void editarCompeticion( ) {
//		
//		Competicion competicion = buscarCompeticion();
//	    String nuevoNombre=Utils.leeString("Introduce el nuevo nombre de la competicion");
//		String nuevaDescripcion=Utils.leeString("Introduce una descripcion");
//		Date nuevaFechaInicio=Utils.validaFecha("Introduce la fecha de la competicion");
//	    
//	    if (competicion != null) {
//	        competicion.setNombre( nuevoNombre);
//	        competicion.setDescripcion(nuevaDescripcion);
//	        competicion.setFechaInicio(nuevaFechaInicio);
//	        
//	        Utils.mensaje("La competicion  ha sido actualizada ");
//	    }else {
//	    	 Utils.mensaje("No se ha encontrado ninguna competicion con el nombre introducido");
//	    }
//	}
//	
	public void buscarCompeticion() {
		String comp=Utils.leeString("Introduce el nombre de la competicion ");
		for (Competicion c : competiciones) {
			if(c.getNombre()==comp)
				Utils.imprimeCompeticion(c);
		}
	}
	public void ejecutarMenuInsertarPrueba() {
		controladorPruebas.controlarMenuInsertarPrueba(0);
		}
	
	public void volverMenuPrincipal() {
		controladorPrincipal.controlarMenuPrincipal();
	}
	
	public void eliminaCompeticion() {
		if(repoComp.eliminaCompeticion(repoComp.buscaCompeticion(Utils.leeString("Introduce el nombre de la competicion que quieras eliminar")))==true) {
			Utils.mensaje("La competicion ha sido eliminada");
		}
		else {
			Utils.mensaje("No se ha podido eliminar la competicion");
		}
		
	}
	public void muestraCompeticion() {
		for (Competicion c : competiciones) {
			System.out.println(c);
		}
	}

	
}
