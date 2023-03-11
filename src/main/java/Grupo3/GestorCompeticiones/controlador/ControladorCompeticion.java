package Grupo3.GestorCompeticiones.controlador;

import java.util.Date;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorCompeticion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPruebas;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoCompeticion;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaCompeticion;
import Grupo3.GestorCompeticiones.model.DAO.RepoCompeticion;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.utils.Utils;

public class ControladorCompeticion implements iControladorCompeticion {
	
	private RepoCompeticion RepoCompeticion;
    private iRepoCompeticion repoComp;
	private iControladorPruebas controlarPruebas;
    private iControladorPrincipal controlarPrincipal;
    private iVistaCompeticion vistaComp;
    
	public void ejecutarMenuCompeticion() {
		int opcion;
		do {
			vistaComp.mostrarMenuCompeticion();
			opcion=Utils.leeEntero("Elige una opcion: ");
			controlarMenuCompeticion(opcion);	
		}while(opcion!=3);
	}
	public void controlarMenuCompeticion(int opcion) {
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
	public void crearCompeticion() {

		String nombre=Utils.leeString("Introduce el nombre de la competici�n");
		String descripcion=Utils.leeString("Introduce una descripci�n");
		Date fechaInicio=Utils.validaFecha("Introduce la fecha de la competici�n");
		
		Competicion competicion = new Competicion(nombre, descripcion, fechaInicio);
		repoComp.insertaCompeticion(competicion);
		Utils.mensaje("Competici�n creada correctamente");
	}
	
	
	public void editarCompeticion( ) {
		
		Competicion competicion = repoComp.buscaCompeticion(Utils.leeString("Introduce el nombre de la competicion que quiera editar"));
	    String nuevoNombre=Utils.leeString("Introduce el nombre de la competici�n");
		String nuevaDescripcion=Utils.leeString("Introduce una descripci�n");
		Date nuevaFechaInicio=Utils.validaFecha("Introduce la fecha de la competici�n");
	    
	    if (competicion != null) {
	        competicion.setNombre( nuevoNombre);
	        competicion.setDescripcion(nuevaDescripcion);
	        competicion.setFechaInicio(nuevaFechaInicio);
	        
	        Utils.mensaje("La competici�n  ha sido actualizada ");
	    }else {
	    	 Utils.mensaje("No se ha encontrado ninguna competici�n con el nombre introducido");
	    }
	}
	
	public void buscarCompeticion() {
		Utils.imprimeObjeto(repoComp.buscaCompeticion(Utils.leeString("Introduce el nombre de la competicion que quieras editar")));
	}
	public void ejecutarMenuInsertarPrueba() {
		controlarPruebas.controlarMenuInsertarPrueba();
		}
	
	public void volverMenuPrincipal() {
		controlarPrincipal.controlarMenuPrincipal();
	}
	
	public void eliminaCompeticion() {
		if(repoComp.eliminaCompeticion(repoComp.buscaCompeticion(Utils.leeString("Introduce el nombre de la competicion que quieras eliminar")))==true) {
			Utils.mensaje("La competicion ha sido eliminada");
		}
		else {
			Utils.mensaje("No se ha podido eliminar la competici�n");
		}
		
	}
	public void muestraCompeticion() {
		String muestraComp=RepoCompeticion.muestraCompeticion();
		 repoComp.muestraCompeticion();
	}

	
		
	
	
}
