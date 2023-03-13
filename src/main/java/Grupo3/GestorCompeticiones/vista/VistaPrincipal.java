package Grupo3.GestorCompeticiones.vista;

import Grupo3.GestorCompeticiones.interfaces.vista.iVistaPrincipal;
import Grupo3.GestorCompeticiones.utils.Utils;

public class VistaPrincipal implements iVistaPrincipal {

	@Override
	public void mostrarMenuPrincipal() {
		Utils.mensaje("GESTOR DE COMPETICIONES");
		Utils.mensaje("");
		Utils.mensaje("[1]MENU DE COMPETICIONES");
		Utils.mensaje("[2]MENU FEDERACION");
		Utils.mensaje("[0]SALIR");
		
	}
	

	public void mostrarMenuFederacion() {
		
	}
	

}
