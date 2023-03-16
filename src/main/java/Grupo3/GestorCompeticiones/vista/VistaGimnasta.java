package Grupo3.GestorCompeticiones.vista;

import Grupo3.GestorCompeticiones.controlador.ControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaGimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;

public class VistaGimnasta implements iVistaGimnasta {





	
	public void mostrarMenuGimnasta() {
		Utils.mensaje("\nMENU DE GIMNASTAS");
		Utils.mensaje("");
		Utils.mensaje("[1]INSERTAR GIMNASTA");
		Utils.mensaje("[2]BUSCAR GIMNASTA");
		Utils.mensaje("[3]EDITAR GIMNASTA");
		Utils.mensaje("[4]ELIMINAR GIMNASTA");
		Utils.mensaje("[5]MOSTRAR GIMNASTAS");
		Utils.mensaje("[6]MENU DE GRUPOS");
		Utils.mensaje("[7]VOLVER AL MENU PRINCIPAL");
		
		
		
	}

}
