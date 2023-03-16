package Grupo3.GestorCompeticiones.controlador;

import java.util.ArrayList;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGimnasta;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorGrupo;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoGimnasta;
import Grupo3.GestorCompeticiones.interfaces.vista.iVistaGimnasta;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Gimnasta;
import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;
import Grupo3.GestorCompeticiones.utils.SerializadorManager;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaGimnasta;

public class ControladorGimnasta implements iControladorGimnasta{
	
	private VistaGimnasta vistaGim = new VistaGimnasta();
	private RepoGimnasta repoGimnasta = new RepoGimnasta();
	private iControladorPrincipal controlaPrin= new ControladorPrincipal();
	private iControladorGrupo controlaGrup;

	
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
	public void insertarGimnasta() {
		String nombre = Utils.leeString("Inserte el nombre:" );
		String dni = Utils.validaDNI("Inserte el DNI: ");
		String telefono = Utils.validaTLF("Introduce el telefono: ");
		String correo = Utils.leeString("Introduce el correo: ");
		
		
		Gimnasta g = new Gimnasta(nombre, dni, telefono, correo);
		
		if(repoGimnasta.insertaGimnasta(g)) {
			Utils.mensaje("Gimasta introducido correctamente");
			repoGimnasta.GimnastaXML();
		}
		
	}
	/**
	 * Subcontrolador que se encarga de controlar el buscar e imprimir el gimnasta a traves del dni.
	 */
	public void buscarGimnasta() {
		
		String dni=Utils.validaDNI("Introduce el DNI del gimnasta a buscar: ");
	
	}
	/**
	 * Subcontrolador que se encarga de controlar la edicion del gimnasta.
	 */
	public void editarGimnasta() {
		Gimnasta g = null;
		g = repoGimnasta.buscaGimnasta(Utils.validaDNI("Introduce el DNI del Ginmasta que desea editar: "));
		
		String nombre = Utils.leeString("Introduce el nombre: ");
		String tlf = Utils.validaTLF("Introduce el telefono: ");
		String correo = Utils.leeString("Inserta el correo: ");
		Categoria categoria = Utils.validaCategoria("Introduce categoria del gimnasta");
		String club = Utils.leeString("Introduce club del gimnasta");
		
		g.setNombre(nombre);
		g.setTelefono(tlf);
		g.setCorreo(correo);
		
	}
	/**
	 * Subcontrolador que se encarga de controlar la eliminacion de gimnasta.
	 */
	public void eliminarGimnasta() {
		if(repoGimnasta.eliminaGinmasta(repoGimnasta.buscaGimnasta(Utils.validaDNI("Introduce el DNI del Gimnasta a eliminar ")))==true) {
			Utils.mensaje("Has eliminado el Gimnasta correctamente");
		}
		
	}
	/**
	 *Comento el metodo para que no de fallos mientras hago pruebas
	 * Subcontrolador que se encarga de moatrar todo los gimnastas federados.
	 */
	
	public void mostrarGimnastas() {
		
		
		String allGim = repoGimnasta.muestraGimnastas();
		Utils.imprimeObjeto(allGim);
		
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
	
	
}
