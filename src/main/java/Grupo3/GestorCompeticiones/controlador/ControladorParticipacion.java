package Grupo3.GestorCompeticiones.controlador;

import java.util.ArrayList;
import java.util.Iterator;

import Grupo3.GestorCompeticiones.interfaces.controlador.*;
import Grupo3.GestorCompeticiones.interfaces.repo.*;
import Grupo3.GestorCompeticiones.model.DO.*;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.model.Repo.RepoGimnasta;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaPruebas;

public class ControladorParticipacion implements iControladorParticipacion {

	private VistaPruebas vistapruebas; 
	private ControladorPrincipal controlarPrincipal;
	private ControladorCompeticion controlarComp;
	private ControladorPruebas controlPruebas;
	private ControladorGimnasta controlGimnastas;
	private ControladorGrupo controlGrupos;
	private ArrayList<Participacion> participaciones = new ArrayList();
	
	

	public void ejecutarMenuInsertarParticipaciones() {
		int opcion;
		do {
			vistapruebas.mostrarMenuParticipacion();
			opcion = Utils.leeEntero("Elige opcion: ");
			controlarMenuParticipaciones(opcion);
		} while (opcion != 0);
	}

	public void controlarMenuParticipaciones(int opcion) {
		switch (opcion) {
		case 1:
			agregarParticipacionGimnasta();
			break;
		case 2:
			editarParticipacion();
			break;
		case 3:
			eliminarParticipacion();
			break;
		case 4:
			mostrarParticipaciones();
			break;
		case 5:
			buscarParticipacion();
			break;
		case 6:
			volverMenuPruebas();
			break;
		case 7:
			volverMenuPrincipal();
			break;

		default:
			Utils.mensaje("Opcion incorrecta");
		}

	}


	public void volverMenuPruebas() {
		controlPruebas.controlarMenuInsertarPrueba(0);

	}

	public void volverMenuCompeticion() {
		controlarComp.ejecutarMenuCompeticion();

	}

	public void volverMenuPrincipal() {
		controlarPrincipal.controlarMenuPrincipal();

	}

	@Override
	public boolean agregarParticipacionGimnasta() {
		
		RepoCompeticion rc = RepoCompeticion.newInstance();
		boolean result = false;

		Participacion participacion = new Participacion(0, null, 0, null);
		Participacion p= participacion.crearParticipacionGimnasta();
		
		if(participaciones.add(participacion)) {
			result=true;
		}
		
		rc.guardaXML();
		
		
		return result;
	}

	@Override
	public boolean eliminarParticipacion() {
		
		RepoCompeticion rc =RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		
		
		int dorsal=Utils.leeEntero("Introduce el dorsal de la participacion que deseas eliminar");
		Iterator<Competicion> it = competiciones.iterator();
		
		Competicion p = it.next();
		while(it.hasNext()) {
			if(competiciones.contains(dorsal)) {
				competiciones.remove(p);
			}
		}
		
		
		
		
		
		return false;
	}

	@Override
	public void mostrarParticipaciones() {
		
		RepoCompeticion rc =RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		
		Iterator<Competicion> it = competiciones.iterator();
		Competicion aux = it.next();
		while(it.hasNext()) {
			System.out.println(aux.getPruebas());
		}
		
	}

	@Override
	public boolean editarParticipacion() {
		RepoCompeticion rc =RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		boolean result = false;
		
		
		int dorsal=Utils.leeEntero("Introduce el dorsal de la participacion que deseas eliminar");
		Iterator<Competicion> it = competiciones.iterator();
		
		Competicion p = it.next();
		while(it.hasNext()) {
			if(p.getPruebas().contains(dorsal)) {
				competiciones.remove(p);
			}
			
			Competicion c = controlarComp.insertarCompeticion();
			
			if(competiciones.add(c)) {
				result=true;
			}
		}
		rc.guardaXML();
		
		return result;
	}

	@Override
	public void buscarParticipacion() {
		
		RepoCompeticion rc =RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		
		
		int dorsal=Utils.leeEntero("Introduce el dorsal de la participacion que deseas buscar");
		Iterator<Competicion> it = competiciones.iterator();
		
		Competicion p = it.next();
		while(it.hasNext()) {
			if(p.getPruebas().contains(dorsal)) {
				System.out.println(p);
			}
		}
	}

}
