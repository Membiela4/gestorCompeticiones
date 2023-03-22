package Grupo3.GestorCompeticiones.controlador;

import java.util.ArrayList;
import java.util.Iterator;


import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGimnasta;

import Grupo3.GestorCompeticiones.model.DAO.GimnastaDAO;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Gimnasta;

import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;

import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaGimnasta;

public class ControladorGimnasta implements iControladorGimnasta{
	
	
	
	/**
	 * Controlador del menu Gimnasta
	 */
	public  void controlarMenuGimnasta() {
		boolean valid = false; 
		do {
			VistaGimnasta vistaGimnasta = new VistaGimnasta();
			vistaGimnasta.mostrarMenuGimnasta();
			int option = Utils.leeEntero("Introduce la opcion deseada: ");
			switch (option) {
			case 0:
				valid = true;
				Utils.mensaje("Has decidido volver al menu federacion.");
				break;
			case 1:
				 insertarGimnasta();
				 break;
			case 2 :
				  buscarGimnasta();
				  break;
			case 3 :
				  editarGimnasta();
				  break;
			case 4 : 
				 eliminarGimnasta();
				 break;
			case 5 :
				 mostrarGimnastas();
				 break;
			case 6 : 
				ejecutarMenugrupos();
				 break;
			case 7 :
				 volverMenuPrincipal();
				 break;
			default:
				Utils.mensaje("Opcion incorrecta.");
				break;
			}
		} while (!valid);
		
	}
	/**
	 * Subcontrolador que se encarga de controlar el insert de gimnasta
	 */
	
	
	public void insertarGimnasta() {
		String nombre = Utils.leeString("Inserte el nombre:" );
		String dni = Utils.validaDNI("Inserte el DNI: ");
		String telefono = Utils.validaTLF("Introduce el telefono: ");
		String correo = Utils.leeString("Introduce el correo: ");
		Categoria categoria = Utils.validaCategoria("Introduce la categoria de la gimnasta: ");
		
		Gimnasta g = new Gimnasta(nombre, dni, telefono, categoria, correo);
		if(GimnastaDAO.creaGimnasta(g)) {
			Utils.mensaje("Has insetado correctamente el gimnasta");
		}
	}
	/**
	 * Subcontrolador que se encarga de controlar el buscar e imprimir el gimnasta a traves del dni.
	 */
	
	
	//tocar metodo
	public void buscarGimnasta() {
		
		
		
		Utils.imprimeObjeto(GimnastaDAO.buscaGimnasta(Utils.validaDNI("Introduce el dni de el gimnasta a buscar: ")));
	}
		

	/**
	 * Subcontrolador que se encarga de controlar la edicion del gimnasta.
	 */
	
	//tocar metodo
	public void editarGimnasta() {
		RepoGimnasta rg = RepoGimnasta.newInstance();
		//ArrayList<Gimnasta> gims = rg.getGimnastas();
		
		Gimnasta g = GimnastaDAO.buscaGimnasta(Utils.validaDNI("Introduce el dni el gimnasta que desea editar :"));;
		
		
		String nombre = Utils.leeString("Inserte el nombre:" );
		String telefono = Utils.validaTLF("Introduce el telefono: ");
		String correo = Utils.leeString("Introduce el correo: ");
		Categoria categoria = Utils.validaCategoria("Introduce la categoria de la gimnasta: ");
		
		g.setNombre(nombre);
		g.setTelefono(telefono);
		g.setCorreo(correo);
		g.setCategoria(categoria);
		rg.guardaXML();
		/*Iterator<Gimnasta> it = gims.iterator();
		Gimnasta g = it.next();
		
		String dni=Utils.validaDNI("Introduce el dni el gimnasta que desea editar :");
		
		while(it.hasNext()) {
			System.out.println("ok");
			if(g.getDni().equals(dni)) {
				System.out.println("ok2");
				if(gims.remove(g)) {
					String nombre = Utils.leeString("Inserte el nombre:" );
					String telefono = Utils.validaTLF("Introduce el telefono: ");
					String correo = Utils.leeString("Introduce el correo: ");
					Categoria categoria = Utils.validaCategoria("Introduce la categoria de la gimnasta: ");
					Gimnasta g2 = new Gimnasta(nombre, dni, telefono, categoria, correo);
					GimnastaDAO.creaGimnasta(g2);
					rg.guardaXML();
				}
				
				
			}
			break;
		}
		
		*/
		
		
		
	}
	/**
	 * Subcontrolador que se encarga de controlar la eliminacion de gimnasta.
	 * @return 
	 */
	
	//tocarlo 
	public void eliminarGimnasta() {
		if(GimnastaDAO.eliminaGimnasta(GimnastaDAO.buscaGimnasta(Utils.validaDNI("Introduce el dni del gimnasta a eliminar: ")))) {
			Utils.mensaje("el gimnasta se ha eliminado correctamente");
		}
	}	/**
	 *Comento el metodo para que no de fallos mientras hago pruebas
	 * Subcontrolador que se encarga de moatrar todo los gimnastas federados.
	 */
	
	
	
	public void mostrarGimnastas() {
		
		String gim = new String();
				
		gim = GimnastaDAO.mostrarGimnastas();
		Utils.imprimeObjeto(gim);
		
		
		
		
	}
	/**
	 * Subcontrolador que te envia al menu de grupos
	 */
	public void ejecutarMenugrupos() {
		ControladorGrupo controladorGrupo = new ControladorGrupo();
		controladorGrupo.controlarMenuGrupos();
		
	}
	/**
	 * Subcontrolador que te envia al menu principal
	 */
	public void volverMenuPrincipal() {
		ControladorPrincipal controladorPrincipal = new ControladorPrincipal();
		controladorPrincipal.controlarMenuPrincipal();
		
	}
	
	
	
	
	

	
	
}
