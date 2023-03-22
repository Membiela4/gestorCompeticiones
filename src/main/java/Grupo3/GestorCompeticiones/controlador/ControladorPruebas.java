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

	private ControladorParticipacion controlarParticipacion;
	List<Prueba> pruebas = new ArrayList<>();
	private VistaPruebas vistapruebas = new VistaPruebas();
	private ControladorParticipacion controlarPart;

	private ControladorPrincipal controlarPrincipal;
	private ControladorCompeticion controlarComp = new ControladorCompeticion();

	public void ejecutarMenuInsertarPrueba() {
		int opcion;
		do {
			vistapruebas.mostrarMenuPrueba();
			opcion = Utils.leeEntero("Elige una opcion: ");

			controlarMenuInsertarPrueba(opcion);
		} while (opcion != 7 || opcion !=0);
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
	boolean result=false;
		RepoCompeticion rc = RepoCompeticion.newInstance();
		
		ArrayList<Competicion> competiciones = rc.getCompeticiones();
		ArrayList<Prueba> pruebas=new ArrayList<>();
		Prueba p= crearPrueba();
		
	if(	pruebas.add(p)) {
	     rc.guardaXML();
	     result=true;
	}      
     return result;
	}
	  
	public void editarPrueba() {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competiciones= rc.getCompeticiones();
		ArrayList<Prueba> prueba=new ArrayList<>();
		
		TipoPrueba tipo1=Utils.validaTipoPrueba("Introduce el tipo de prueba a editar");
		Categoria categoria1=Utils.validaCategoria("Introduce la categor�a a editar");
		Aparato aparato1=Utils.validaAparato("Introduce el aparato a editar");
	    
		Iterator<Prueba> it=pruebas.iterator();
		Prueba p=it.next();
		
		while(it.hasNext()) {
		    if ((p.getAparato()==aparato1)&&(p.getCategoria()==categoria1)&&(p.getTipo()==tipo1)) {
		       pruebas.remove(p);
		       
		    } 
		    Prueba p2=crearPrueba();
		    if(pruebas.add(p2)) {
		    	rc.guardaXML();
		    	 Utils.mensaje("Prueba actualizada correctamente");
		    }
		    else {
		        Utils.mensaje("No se encontr� la prueba");
		    }
		}
	}
	 public boolean eliminaPrueba() {
		 boolean result=false;
		 RepoCompeticion rc=RepoCompeticion.newInstance();
		 ArrayList<Competicion >competiciones=rc.getCompeticiones();
		 ArrayList<Prueba> pruebas=new ArrayList<>(); 
		 TipoPrueba prueba=Utils.validaTipoPrueba("Introduce el tipo de prueba");
			Categoria categoria=Utils.validaCategoria("Introduce la categor�a");
			Aparato aparato=Utils.validaAparato("Introduce el aparato");
			
			Iterator<Prueba> it=pruebas.iterator();
			Prueba p=it.next();
			while(it.hasNext()) {
				if(pruebas.equals(p.getAparato())&& pruebas.equals(p.getCategoria())&& pruebas.equals(p.getTipo())) {
					pruebas.remove(p);
					result=true;
					break;
				}
			}
			rc.guardaXML();
			return result; 
	 }
	 
	 public void muestraPrueba() {
		 RepoCompeticion rc=RepoCompeticion.newInstance();
		 ArrayList<Competicion >competiciones=rc.getCompeticiones();
		 ArrayList<Prueba> pruebas=new ArrayList<>(); 
		 
		 for (Prueba p : pruebas) {
			Utils.imprimeObjeto(p);
		}
		 
		
	 }
	 
	 public void ejecutarMenuInsertarParticipaciones() {
		 controlarParticipacion.controlarMenuParticipaciones(0);
	 }
	public void volverMenuPrincipal() {
		controlarPrincipal.controlarMenuPrincipal();
	}
	
	public void volverMenuCompeticion() {
		controlarComp.controlarMenuCompeticion(0);
	}
	
	public void buscarPrueba() {
		RepoCompeticion rc = RepoCompeticion.newInstance();
		ArrayList<Competicion> competicion=rc.getCompeticiones();
		 ArrayList<Prueba> pruebas=new ArrayList<>(); 
		
		 TipoPrueba tipo = Utils.validaTipoPrueba("Introduce el tipo de prueba a buscar:");
		    Categoria categoria = Utils.validaCategoria("Introduce la categor�a a buscar:");
		    Aparato aparato = Utils.validaAparato("Introduce el aparato a buscar:");
			
			 
			 Iterator<Prueba> it=pruebas.iterator();
			 Prueba p=it.next();
			 while(it.hasNext()) {
			if(p.getAparato().equals(pruebas)&&(p.getCategoria().equals(pruebas))&&(p.getTipo().equals(pruebas))){
					Utils.imprimeObjeto(p);
			}
		        
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


	

}
