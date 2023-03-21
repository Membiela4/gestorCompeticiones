package Grupo3.GestorCompeticiones.controlador;

import java.io.File;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorCompeticion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorParticipacion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPruebas;

import Grupo3.GestorCompeticiones.model.DO.Aparato;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Competicion;
import Grupo3.GestorCompeticiones.model.DO.Participacion;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.DO.TipoPrueba;
import Grupo3.GestorCompeticiones.model.Repo.RepoCompeticion;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaPruebas;

public class ControladorPruebas implements iControladorPruebas {


	private VistaPruebas vistapruebas;
	
	private ControladorParticipacion controlarParticipacion;
=======
	List<Prueba> pruebas = new ArrayList();
	private VistaPruebas vistapruebas;
	private iControladorParticipacion controlarParticipacion;

	private ControladorPrincipal controlarPrincipal;
	private ControladorCompeticion controlarComp;

	public void ejecutarMenuInsertarPrueba() {
		int opcion;

		do {	
			vistapruebas.mostrarMenuPrueba();
			opcion=Utils.leeEntero("Elige una opcion: ");	
=======
		do {
			vistapruebas.mostrarMenuPrueba();
			opcion = Utils.leeEntero("Elige una opcion: ");

			controlarMenuInsertarPrueba(opcion);
		} while (opcion != 7);
	}
	 public void controlarMenuInsertarPrueba(int opcion) {
		switch(opcion) {
			case 0:
		 			volverMenuCompeticion();
		 			break;
		 	case 1:
		 			insertarPrueba();
		 			break;
			case 2:
					editarPrueba();
					break;
			case 3:
					buscarPrueba();
					break;
			case 4:
					eliminaPrueba();
					break;
			case 5:
					muestraPrueba();
					break;
			case 6:
					ejecutarMenuInsertarParticipaciones();
					break;
			case 7:
				    volverMenuPrincipal();
				    break;
			default:
				 Utils.mensaje("Vuelve a introducir una opcion");
				 break;
		}		
	}	
	public boolean insertarPrueba() {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> pruebas = rc.getCompeticiones();
		Prueba p= crearPrueba();
		pruebas.add(p);
		
		return pruebas.addAll((pruebas));
		
		
	}
	
	public void editarPrueba() {
		
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> pruebas = rc.getCompeticiones();
		
		TipoPrueba tipo1=Utils.validaTipoPrueba("Introduce el tipo de prueba a editar");
		Categoria categoria1=Utils.validaCategoria("Introduce la categor�a a editar");
		Aparato aparato1=Utils.validaAparato("Introduce el aparato a editar");
	    
		Iterator<Competicion> it = pruebas.iterator();
		 Competicion p1 = it.next();
		
		while(it.hasNext()) {
			
		
		    if (prueba!=null) {
		        prueba.setTipo(tipo1);
		        prueba.setCategoria(categoria1);
		        prueba.setAparato(aparato1);
		        Utils.mensaje("Prueba actualizada correctamente");
		    } 
		    else {
		        Utils.mensaje("No se encontr� la prueba");
		    }
		}
	}
	 public void eliminaPrueba() {
		 TipoPrueba prueba=Utils.validaTipoPrueba("Introduce el tipo de prueba");
			Categoria categoria=Utils.validaCategoria("Introduce la categor�a");
			Aparato aparato=Utils.validaAparato("Introduce el aparato");
		    Prueba p = repoPruebas.buscaPrueba( prueba,categoria,aparato);
		        if ((p)) {
		            Utils.mensaje("Prueba eliminada correctamente");
		        } else {
		            Utils.mensaje("No se pudo eliminar la prueba");
		        }
		 
	 }
	 public void muestraPrueba() {
		 for(Prueba p : pruebas) {
			 System.out.println(p);
		 }
	 }
	 
	 public void ejecutarMenuInsertarParticipaciones() {
		 controlarParticipacion.controlarMenuParticipaciones();
	 }
	public void volverMenuPrincipal() {
		controlarPrincipal.controlarMenuPrincipal();
	}
	
	public void volverMenuCompeticion() {
		controlarComp.controlarMenuCompeticion(0);
	}
	
	@Override
	public void buscarPrueba() {
		 TipoPrueba tipo = Utils.validaTipoPrueba("Introduce el tipo de prueba a buscar:");
		    Categoria categoria = Utils.validaCategoria("Introduce la categor�a a buscar:");
		    Aparato aparato = Utils.validaAparato("Introduce el aparato a buscar:");
			for (Prueba p : pruebas) {
				if((p.getCategoria()==categoria)&&(p.getAparato()==aparato)&&(p.getTipo()==tipo))
					Utils.imprimeObjeto(p);
			}
		        
	}
	
	public Prueba crearPrueba() {
		ArrayList<Participacion> participaciones = null;
		
		
		TipoPrueba tipo=Utils.validaTipoPrueba("Elige tipo de prueba (INDIVIDUAL/GRUPO) ");
		Categoria categoria=Utils.validaCategoria("Introduce la categoria (prebenjamin/benjamin/alevin/infantil/junior/senior");
		Aparato aparato=Utils.validaAparato("Introduce modalidad de prueba ( MAZAS/ARO/CINTA/CUERDA/MLIBRES");
		
		Prueba prueba = new Prueba(tipo,categoria, aparato, participaciones);
		Utils.mensaje("Prueba creada correctamente");
		
		return prueba;
	}


	public void controlarMenuInsertarPrueba(int opcion) {
		switch (opcion) {
		case 0:
			volverMenuCompeticion();
			break;
		case 1:
			insertarPrueba();
			break;
		case 2:
			editarPrueba();
			break;
		case 3:
			buscarPrueba();
			break;
		case 4:
			eliminaPrueba();
			break;
		case 5:
			muestraPrueba();
			break;
		case 6:
			ejecutarMenuInsertarParticipaciones();
			break;
		case 7:
			volverMenuPrincipal();
			break;
		default:
			Utils.mensaje("Vuelve a introducir una opcion");
			break;
		}
	}

	public void insertarPrueba() {
		RepoCompeticion rc=RepoCompeticion.newInstance();
		ArrayList<Participacion>participantes=new ArrayList<>();
		TipoPrueba tipo = Utils.validaTipoPrueba("Introduce el tipo de prueba");
		Categoria categoria = Utils.validaCategoria("Introduce la categor�a");
		Aparato aparato = Utils.validaAparato("Introduce el aparato");

		Prueba prueba = new Prueba(tipo, categoria, aparato, participantes);
		
		if(pruebas.add(prueba)) {
		Utils.mensaje("Prueba creada correctamente");
	}
		rc.guardaXML();
	}

	public void editarPrueba() {
		RepoCompeticion rc=RepoCompeticion.newInstance();
		TipoPrueba tipo1 = Utils.validaTipoPrueba("Introduce el tipo de prueba a editar");
		Categoria categoria1 = Utils.validaCategoria("Introduce la categor�a a editar");
		Aparato aparato1 = Utils.validaAparato("Introduce el aparato a editar");
		
		Iterator<Prueba> it=pruebas.iterator();
		if (it.equals(tipo1)&& it.equals(categoria1)&& it.equals(aparato1)) {
			Prueba prueba = null;
			prueba.setTipo(tipo1);
			prueba.setCategoria(categoria1);
			prueba.setAparato(aparato1);
			Utils.mensaje("Prueba actualizada correctamente");
		} else {
			Utils.mensaje("No se encontr� la prueba");
		}
	}
	
	public boolean eliminaPrueba() {
		boolean result=false;
		RepoCompeticion rc=RepoCompeticion.newInstance();
		TipoPrueba prueba = Utils.validaTipoPrueba("Introduce el tipo de prueba");
		Categoria categoria = Utils.validaCategoria("Introduce la categor�a");
		Aparato aparato = Utils.validaAparato("Introduce el aparato");
		Iterator<Prueba> it =pruebas.iterator();
		Prueba p1=it.next();
		while(it.hasNext()) {
			if((p1.getCategoria() == categoria) && (p1.getAparato() == aparato) && (p1.getTipo() == tipo)) ) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public void muestraPrueba() {
		RepoCompeticion rc=RepoCompeticion.newInstance();
		Iterator<Prueba> it =pruebas.iterator();
		while(it.hasNext()) {
			Utils.imprimeObjeto(pruebas);
		}
		
	}

	public void ejecutarMenuInsertarParticipaciones() {
		controlarParticipacion.ejecutarMenuInsertarParticipaciones();
	}

	public void volverMenuPrincipal() {
		controlarPrincipal.controlarMenuPrincipal();
	}

	public void volverMenuCompeticion() {
		controlarComp.controlarMenuCompeticion(0);
	}

	@Override
	public void buscarPrueba() {
		RepoCompeticion rc=RepoCompeticion.newInstance();
		TipoPrueba prueba = Utils.validaTipoPrueba("Introduce el tipo de prueba");
		Categoria categoria = Utils.validaCategoria("Introduce la categor�a");
		Aparato aparato = Utils.validaAparato("Introduce el aparato");
		Iterator<Prueba> it =pruebas.iterator();
		Prueba p=it.next();
		while(it.hasNext()) {
			if ((p.getCategoria() == categoria) && (p.getAparato() == aparato) && (p.getTipo() == tipo)) {
				Utils.imprimeObjeto(p);
		}
}
	}

}
