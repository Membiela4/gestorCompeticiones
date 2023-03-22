package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGrupo;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.model.DAO.*;
import Grupo3.GestorCompeticiones.model.DAO.GrupoDAO;
import Grupo3.GestorCompeticiones.model.DO.Grupo;
import Grupo3.GestorCompeticiones.utils.Utils;

public class ControladorGrupo implements iControladorGrupo{
	static private ControladorPrincipal controlaPrin;
	static private Utils utils;
	
	@Override
	public void controlarMenuGrupos() {
		boolean valid = false;
		do {
			
			int option = Utils.leeEntero("Introduce la opcion deseada.");
			switch (option) {
			case 0:
				valid = true;
				Utils.mensaje("Has vuelto al menu Federacion");
				break;
			case 1:
				crearGrupos();
				break;
			case 2:
	             buscarGrupos();
				break;
			case 3:
				 editarGrupos();
				break;
			case 4:
				 borrarGrupos();
				break;
			case 5 : 
				mostrarGrupos();
				break;
			case 6 : 
				volverMenuPrincipal();
				break;
				 
			default:
				Utils.mensaje("Opcion incorrecta.");
				break;
			}
		} while (!valid);
		
	}

	

	@Override
	public void crearGrupos() {
		
		
	}

	

	@Override
	public void buscarGrupos() {
		
		utils.imprimeObjeto(GrupoDAO.buscaGrupo(utils.leeString("Introduce el nombre del grupo que desea buscar:")));
		
	}

	@Override
	public void editarGrupos() {
	
		
	}

	@Override
	public void borrarGrupos() {
		if(GrupoDAO.eliminaGrupo(GrupoDAO.buscaGrupo(Utils.leeString("Introduce el nombre del Grupo que desea eliminar"))));
		Utils.mensaje("Has eliminado el Grupo correctamente");
	}

	@Override
	public void mostrarGrupos() {
		String grupos = GrupoDAO.mostrarGrupos(); 
		Utils.imprimeObjeto(grupos);
		
	}

	@Override
	public void volverMenuPrincipal() {
		controlaPrin.controlarMenuPrincipal();
		
	}

}
