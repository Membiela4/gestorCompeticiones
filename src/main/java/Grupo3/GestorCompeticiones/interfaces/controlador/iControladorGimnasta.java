package Grupo3.GestorCompeticiones.interfaces.controlador;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;

public interface iControladorGimnasta {
	

	void controlarMenuGimnasta();
	
	boolean insertarGimnasta();

	void buscarGimnasta();

	void editarGimnasta();

	boolean eliminarGimnasta();

	void mostrarGimnastas();

	void ejecutarMenugrupos();

	void volverMenuPrincipal();

	Gimnasta crearGimnasta(); 
}
