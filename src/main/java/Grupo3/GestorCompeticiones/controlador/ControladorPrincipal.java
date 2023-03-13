package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorCompeticion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGimnasta;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGrupo;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaPrincipal;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaPrincipal;

public class ControladorPrincipal implements iControladorPrincipal{


	iControladorGrupo controlaGrup;

	ControladorCompeticion controladorCompeticion = new ControladorCompeticion();
	ControladorGimnasta controladorGimnasta = new ControladorGimnasta();
	VistaPrincipal vistaPrincipal = new VistaPrincipal();
	
	
	/**
	 * Controla la ejecucion del programa
	 */
	public void empezar() {
		controlarMenuPrincipal();
		
	}

	
	/**
	 * Controlador principal del programa
	 */
	public void controlarMenuPrincipal() {
		boolean valid = false;
		do {
			
			vistaPrincipal.mostrarMenuPrincipal();
			int option = Utils.leeEntero("Introduce la opcion deseada: ");
			switch (option) {
			case 0:
				valid = true;
				Utils.mensaje("Has cerrado el programa.");
				break;
			case 1:
				controladorCompeticion.ejecutarMenuCompeticion();
				break;
			case 2:
				ejecutarMenuFederacion();
				break;
			default:
				Utils.mensaje("Opcion incorrecta.");
				break;
			}
		} while (!valid);
		
	}

	/**
	 * Controlador del menu federacion
	 */
	public void ejecutarMenuFederacion() {
		boolean valid = true;
		do {
			vistaPrincipal.mostrarMenuFederacion();
			int option = Utils.leeEntero("Introduce la opcion deseada: ");
			switch (option) {
			case 0:
				controlarMenuPrincipal();
				
				break;
			case 1:
				controladorGimnasta.controlarMenuGimnasta();
				break;
			case 2:
				controlaGrup.controlarMenuGrupos();
				break;

			default:
				Utils.mensaje("Opcion incorrecta.");
				break;
			}
		}while(!valid);
		
	}


	

	
	

}
