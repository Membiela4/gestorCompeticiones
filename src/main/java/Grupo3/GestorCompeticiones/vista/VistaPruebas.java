package Grupo3.GestorCompeticiones.vista;


import Grupo3.GestorCompeticiones.interfaces.vista.iVistaPruebas;
import Grupo3.GestorCompeticiones.utils.Utils;

public class VistaPruebas implements iVistaPruebas {

	@Override
	public void mostrarMenuInsertarPrueba() {
		Utils.mensaje("MENU DE PRUEBAS");
		Utils.mensaje("");
		Utils.mensaje("[1]INSERTAR PRUEBA");
		Utils.mensaje("[2]EDITAR PRUEBA");
		Utils.mensaje("[3]BUSCAR PRUEBA");
		Utils.mensaje("[4]ELIMINAR PRUEBA");
		Utils.mensaje("[5]MOSTRAR PRUEBAS");
		Utils.mensaje("[6]INSERTAR PARTICIPACIONES");
		Utils.mensaje("[7]VOLVER AL MENU PRINCIPAL");
		Utils.mensaje("[0]VOLVER AL MENU DE COMPETICION");
		
	}




}
