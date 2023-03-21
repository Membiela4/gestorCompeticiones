package Grupo3.GestorCompeticiones.interfaces.controlador;

public interface iControladorPruebas {
	void ejecutarMenuInsertarPrueba();

	void controlarMenuInsertarPrueba(int opcion);


	boolean insertarPrueba();

	void editarPrueba();

	void buscarPrueba();

	void ejecutarMenuInsertarParticipaciones();
	

	void volverMenuCompeticion();

	void volverMenuPrincipal();
}
