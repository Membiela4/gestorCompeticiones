package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.*;
import Grupo3.GestorCompeticiones.interfaces.repo.*;
import Grupo3.GestorCompeticiones.model.DO.*;
import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaPruebas;

public class ControladorParticipacion implements iControladorParticipacion {

	private VistaPruebas vistapruebas; 
	private ControladorParticipacion controlarParticipacion;
	private ControladorPrincipal controlarPrincipal;
	private ControladorCompeticion controlarComp;
	private ControladorPruebas controlPruebas;
	private ControladorGimnasta controlGimnastas;
	private ControladorGrupo controlGrupos;
	private RepoGimnasta gimnastas;
	

	public void ejecutarMenuInsertarParticipaciones() {
		int opcion;
		do {
			controlarParticipacion.mostrarMenuInsertarParticipaciones();
			opcion = Utils.leeEntero("Elige opcion: ");
			controlarMenuInsertarParticipaciones(opcion);
		} while (opcion != 6);
	}

	public void controlarMenuInsertarParticipaciones(int opcion) {
		switch (opcion) {
		case 1:
			insertarGimnasta();
			break;
		case 2:
			insertarGrupo();
			break;
		case 3:
			volverMenuCompeticion();
			break;
		case 4:
			volverMenuPruebas();
			break;
		case 5:
			volverMenuPrincipal();
			break;

		default:
			System.out.println("Incorrecto");
		}

	}

	public void mostrarMenuInsertarParticipaciones() {

	}

	public void insertarGimnasta() {

	}

	public void insertarGrupo() {

	}

	public void volverMenuPruebas() {
		controlPruebas.controlarMenuInsertarPrueba(0);

	}

	public void volverMenuCompeticion() {
		controlarComp.ejecutarMenuCompeticion();

	}

	public void volverMenuPrincipal() {
		controlarPrincipal.controlarMenuPrincipal();

	}

}
