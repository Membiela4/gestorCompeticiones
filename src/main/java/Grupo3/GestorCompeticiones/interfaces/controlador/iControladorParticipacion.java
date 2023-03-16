package Grupo3.GestorCompeticiones.interfaces.controlador;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.model.DO.Grupo;

public interface iControladorParticipacion {
	
	void ejecutarMenuInsertarParticipaciones();

	void controlarMenuInsertarParticipaciones(int opcion);

	void mostrarMenuInsertarParticipaciones();

	void insertarGimnasta();

	void insertarGrupo();

	void volverMenuPruebas();

	void volverMenuCompeticion();

	void volverMenuPrincipal();

}
