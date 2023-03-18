package Grupo3.GestorCompeticiones.interfaces.controlador;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.model.DO.Grupo;

public interface iControladorParticipacion {
	
	void ejecutarMenuInsertarParticipaciones();

	void controlarMenuParticipaciones(int opcion);

	void volverMenuPruebas();

	void volverMenuCompeticion();

	void volverMenuPrincipal();
	
	boolean agregarParticipacion();
	
	boolean eliminarParticipacion(int dorsal);
	
	void mostrarParticipaciones();
	
	boolean editarParticipacion(int dorsal);
	
	void buscarParticipacion(int dorsal);

}
