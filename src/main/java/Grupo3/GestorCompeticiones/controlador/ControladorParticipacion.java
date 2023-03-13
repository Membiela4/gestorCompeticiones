package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.*;
import Grupo3.GestorCompeticiones.interfaces.repo.*;
import Grupo3.GestorCompeticiones.model.DO.*;
import Grupo3.GestorCompeticiones.utils.Utils;

public class ControladorParticipacion implements iControladorParticipacion{
	
	private iControladorParticipacion participacion = (iControladorParticipacion) new Participacion();
	private iRepoGimnasta gimnastas = (iRepoGimnasta) new Gimnasta();
	private iRepoGrupo grupos = (iRepoGrupo) new Grupo();
	
	public void ejecutarMenuInsertarParticipaciones() {
		int opcion;
		do {
			participacion.mostrarMenuInsertarParticipaciones();
			opcion = Utils.leeEntero(null);
			controlarMenuInsertarParticipaciones (opcion);
		} while (opcion != 6);
	}

	public void controlarMenuInsertarParticipaciones(int opcion) {
		switch(opcion) {
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

	public void insertarGimnasta(Gimnasta g) {
		if (gimnastas.insertaGimnasta(g)) {
			System.out.println("Insertarda ok");
		}else {
			System.out.println("Error");
		}
		
	}

	public void insertarGrupo(Grupo g) {
		if (grupos.insertaGrupo(g)) {
			System.out.println("Grupo Insertado");
		}else {
			System.out.println("Error");
		}
		
	}

	public void volverMenuPruebas() {
		
		
	}

	public void volverMenuCompeticion() {
		
		
	}

	public void volverMenuPrincipal() {
		
		
	}

	
	
}
