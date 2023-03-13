package Grupo3.GestorCompeticiones.vista;

import Grupo3.GestorCompeticiones.interfaces.vista.iVistaCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;

public class VistaCompeticion implements iVistaCompeticion {

	
	@Override
	public void mostrarMenuCompeticion() {
		Utils.mensaje("\nMENU DE COMPETICIONES");
		Utils.mensaje("[1]CREAR COMPETICION");
		Utils.mensaje("[2]EDITAR COMPETICION");
		Utils.mensaje("[3]BUSCA COMPETICION");
		Utils.mensaje("[4]ELIMINA COMPETICION");
		Utils.mensaje("[5]MOSTRAR COMPETICIONES");
		Utils.mensaje("[6]MENU DE PRUEBAS");
		Utils.mensaje("[0]VOLVER AL MENU PRINCIPAL");
		
		
	}

	
}
