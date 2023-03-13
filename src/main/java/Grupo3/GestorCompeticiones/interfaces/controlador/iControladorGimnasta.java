package Grupo3.GestorCompeticiones.interfaces.controlador;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;

public interface iControladorGimnasta {
	

	void controlarMenuGimnasta();
	
	

	void insertarGimnasta();

	void buscarGimnasta();

	void editarGimnasta();

	void eliminarGimnasta();

	void mostrarGimnastas();

	

	void ejecutarMenugrupos();

	void volverMenuPrincipal(); 
}
