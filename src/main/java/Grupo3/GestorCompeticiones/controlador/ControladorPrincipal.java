package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorCompeticion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGimnasta;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaPrincipal;
import Grupo3.GestorCompeticiones.utils.Utils;

public class ControladorPrincipal implements iControladorPrincipal{

	private iVistaPrincipal vistaP;
	private iControladorCompeticion controlaComp;
	private iControladorGimnasta controlaGim;
	
	
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
			vistaP.mostrarMenuPrincipal();
			int option = Utils.leeEntero("Introduce la opcion deseada; ");
			switch (option) {
			case 0:
				valid = true;
				Utils.mensaje("Has cerrado el programa.");
				break;
			case 1:
				controlaComp.ejecutarMenuCompeticion();
				break;
			case 2:
				controlaGim.ejecutarMenuFederacion();
				break;
			default:
				Utils.mensaje("Opcion incorrecta.");
				break;
			}
		} while (!valid);
		
	}

	
	

}
