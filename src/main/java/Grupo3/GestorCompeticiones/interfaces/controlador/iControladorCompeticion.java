package Grupo3.GestorCompeticiones.interfaces.controlador;

import Grupo3.GestorCompeticiones.model.DO.Competicion;

public interface iControladorCompeticion {
	void ejecutarMenuCompeticion();

	void controlarMenuCompeticion(int opcion);


	void crearCompeticion();

//	void editarCompeticion();

	void buscarCompeticion();

	void ejecutarMenuInsertarPrueba();
	
	void volverMenuPrincipal();

}
