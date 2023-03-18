package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.*;
import Grupo3.GestorCompeticiones.interfaces.repo.*;
import Grupo3.GestorCompeticiones.model.DO.*;
import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaPruebas;

public class ControladorParticipacion implements iControladorParticipacion {

	private VistaPruebas vistapruebas; 
	private ControladorPrincipal controlarPrincipal;
	private ControladorCompeticion controlarComp;
	private ControladorPruebas controlPruebas;
	private ControladorGimnasta controlGimnastas;
	private ControladorGrupo controlGrupos;
	
	

	public void ejecutarMenuInsertarParticipaciones() {
		int opcion;
		do {
			vistapruebas.mostrarMenuParticipacion();
			opcion = Utils.leeEntero("Elige opcion: ");
			controlarMenuParticipaciones(opcion);
		} while (opcion != 6);
	}

	public void controlarMenuParticipaciones(int opcion) {
		switch (opcion) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:

			break;
		case 5:
			
			break;

		default:
			System.out.println("Incorrecto");
		}

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

	@Override
	public boolean agregarParticipacion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarParticipacion(int dorsal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void mostrarParticipaciones() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean editarParticipacion(int dorsal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void buscarParticipacion(int dorsal) {
		// TODO Auto-generated method stub
		
	}

}
