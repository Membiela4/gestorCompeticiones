package Grupo3.GestorCompeticiones.vista;


import Grupo3.GestorCompeticiones.interfaces.vista.iVistaPruebas;
import Grupo3.GestorCompeticiones.utils.Utils;

public class VistaPruebas implements iVistaPruebas {

	public void mostrarMenuPrueba() {
		Utils.mensaje("\nMENU DE PRUEBAS");
		Utils.mensaje("");
		Utils.mensaje("[1]INSERTAR PRUEBA");
		Utils.mensaje("[2]EDITAR PRUEBA");
		Utils.mensaje("[3]BUSCAR PRUEBA");
		Utils.mensaje("[4]ELIMINAR PRUEBA");
		Utils.mensaje("[5]MOSTRAR PRUEBAS");
		Utils.mensaje("[6]MENU DE PARTICIPACIONES");
		Utils.mensaje("[7]VOLVER AL MENU PRINCIPAL");
		Utils.mensaje("[0]VOLVER AL MENU DE COMPETICION");
		
	}
	
	public void mostrarMenuParticipacion() {
		Utils.mensaje("\nMENU DE PARTICIPACIONES");
		Utils.mensaje("");
		Utils.mensaje("[1] INSERTAR PARTICIPACION");
		Utils.mensaje("[2] EDITAR PARTICIPACION");
		Utils.mensaje("[3] BORRAR PARTICIPACION");
		Utils.mensaje("[4] MOSTRAR PARTICIPACIONES");
		Utils.mensaje("[5] BUSCAR PARTICIPACION");
		Utils.mensaje("[6] VOLVER AL MENU DE PRUEBAS");
		Utils.mensaje("[7] VOLVER AL MENU PRINCIPAL");
		  
	}




}
