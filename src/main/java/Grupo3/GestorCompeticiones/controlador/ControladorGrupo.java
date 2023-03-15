package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGrupo;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoGrupo;
import Grupo3.GestorCompeticiones.utils.Utils;

public class ControladorGrupo implements iControladorGrupo{
	private iControladorPrincipal controlaPrin= new ControladorPrincipal();
	private iRepoGrupo repoGrupo;
	@Override
	public void controlarMenuGrupos() {
		boolean valid = false;
		do {
			//poner vista
			int option = Utils.leeEntero("Introduce la opcion que deseada.");
			switch (option) {
			case 0:
				valid = true;
				Utils.mensaje("Has vuelto añ menu Federacion");
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
		Utils.imprimeObjeto(repoGrupo.buscaGrupo(Utils.leeString("Introduce el nombre del grupo que desea buscar:")));
		
	}

	@Override
	public void editarGrupos() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarGrupos() {
		if(repoGrupo.eliminaGrupo(repoGrupo.buscaGrupo(Utils.leeString("Introduce el nombre del Grupo que desea eliminar"))));
		Utils.mensaje("Has eliminado el Grupo correctamente");
	}

	@Override
	public void mostrarGrupos() {
		String grupos = repoGrupo.muestraGrupo(); 
		Utils.imprimeObjeto(grupos);
		
	}

	@Override
	public void volverMenuPrincipal() {
		controlaPrin.controlarMenuPrincipal();
		
	}

}
