package Grupo3.GestorCompeticiones.controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGimnasta;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGrupo;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoGimnasta;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaGimnasta;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;
import Grupo3.GestorCompeticiones.utils.SerializadorManager;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaGimnasta;

public class ControladorGimnasta implements iControladorGimnasta{
	
	private VistaGimnasta vistaGim = new VistaGimnasta();
	private ControladorPrincipal controlaPrin= new ControladorPrincipal();
	private ControladorGrupo controlaGrup;

	
	/**
	 * Controlador del menu Gimnasta
	 */
	public void controlarMenuGimnasta() {
		boolean valid = false; 
		do {
			vistaGim.mostrarMenuGimnasta();
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
	
	//tocar metodo
	

	public boolean insertarGimnasta() {
	
		 RepoGimnasta rg = RepoGimnasta.newInstance();
		 ArrayList<Gimnasta> gimnastas = rg.getGimnastas();
		 
		 Gimnasta g = crearGimnasta();
		 rg.guardaXML();
		return gimnastas.add(g);
		
		
	}
	/**
	 * Subcontrolador que se encarga de controlar el buscar e imprimir el gimnasta a traves del dni.
	 */
	
	
	//tocar metodo
	public void buscarGimnasta() {
		
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gimnastas = rg.getGimnastas();
		String gim=Utils.leeString("Introduce el nombre de la Gimnasta: ");
		
		Iterator<Gimnasta> it = gimnastas.iterator();
		Gimnasta g = it.next();
		while(it.hasNext()) {
			if(g.getNombre().equals(gim)) {
				Utils.imprimeObjeto(g);
				
			}
		}
		
	}
		
	
	/**
	 * Subcontrolador que se encarga de controlar la edicion del gimnasta.
	 */
	
	//tocar metodo
	public void editarGimnasta() {
		
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gimnastas = rg.getGimnastas();
		String gimnasta= Utils.leeString("Introduce el nombre de la Gimansta para editar: ");

		
		Iterator<Gimnasta> it = gimnastas.iterator();
		Gimnasta g = null;
		
		
		while(it.hasNext()) {
			if(it.equals(g)) {
				String nombre = Utils.leeString("Inserte el nombre:" );
				String dni = Utils.validaDNI("Inserte el DNI: ");
				String telefono = Utils.validaTLF("Introduce el telefono: ");
				String correo = Utils.leeString("Introduce el correo: ");
			
				g.getNombre();
				g.getDni();
				g.getTelefono();
				g.getCorreo();
				break;
			}
			
				if(gimnastas.add(g)) {
					rg.guardaXML();
				}else {
					Utils.mensaje("No se pudo editar a la gimnasta");
				}	
			
			
			
		}		
	}
	/**
	 * Subcontrolador que se encarga de controlar la eliminacion de gimnasta.
	 * @return 
	 */
	
	//tocarlo 
	public boolean eliminarGimnasta() {
		boolean result = false;
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gimnastas = rg.getGimnastas();
		String nombre = Utils.leeString("Introduzca el nombre de la gimnasta para eliminar");
		
		Iterator<Gimnasta> it = gimnastas.iterator();
		Gimnasta gim = it.next();
		Gimnasta g = it.next();
		while(it.hasNext()) {
			if(gim.equals(g.getNombre())) {
				gimnastas.remove(g);
				result = true;
				break;
			}
		}
			rg.guardaXML();
		return result;
	}
	/**
	 *Comento el metodo para que no de fallos mientras hago pruebas
	 * Subcontrolador que se encarga de moatrar todo los gimnastas federados.
	 */
	
	
	//pendiente
	public void mostrarGimnastas() {
		
		
		RepoGimnasta rg = RepoGimnasta.newInstance();
		ArrayList<Gimnasta> gimnastas = rg.getGimnastas();

		Iterator<Gimnasta> it = gimnastas.iterator();
		Gimnasta g =it.next();
		
		while(it.hasNext()) {
			Utils.imprimeObjeto(g);
		}
		
		
	}
	/**
	 * Subcontrolador que te envia al menu de grupos
	 */
	public void ejecutarMenugrupos() {
		controlaGrup.controlarMenuGrupos();
		
	}
	/**
	 * Subcontrolador que te envia al menu principal
	 */
	public void volverMenuPrincipal() {
		controlaPrin.controlarMenuPrincipal();
		
	}
	
	public Gimnasta crearGimnasta() {
		String nombre = Utils.leeString("Inserte el nombre:" );
		String dni = Utils.validaDNI("Inserte el DNI: ");
		String telefono = Utils.validaTLF("Introduce el telefono: ");
		String correo = Utils.leeString("Introduce el correo: ");
		Categoria categoria = Utils.validaCategoria("Introduce la categoria de la gimnasta");
		
		Gimnasta gim = new Gimnasta(nombre, dni, telefono, categoria, correo);
		
		return gim;
	}
	
	
	
	

	
	
}
