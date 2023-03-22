package Grupo3.GestorCompeticiones.controlador;


import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;



import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPruebas;
import Grupo3.GestorCompeticiones.model.DAO.PruebaDAO;
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
	
	private VistaPruebas vistapruebas = new VistaPruebas();
	

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
					muestraPruebas();
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
		String nombreComp = Utils.leeString("Introduce el nombre de la competicion a la cual quieras crear una prueba: ");
		TipoPrueba tipo=Utils.validaTipoPrueba("Elige tipo de prueba (INDIVIDUAL/GRUPO) ");
		Categoria categoria=Utils.validaCategoria("Introduce la categoria (prebenjamin/benjamin/alevin/infantil/junior/senior");
		Aparato aparato=Utils.validaAparato("Introduce modalidad de prueba ( MAZAS/ARO/CINTA/CUERDA/MLIBRES");
		ArrayList<Participacion> participaciones = new ArrayList();
		
		Prueba p = new Prueba(tipo, categoria, aparato, participaciones);
		if(PruebaDAO.creaPrueba(nombreComp, p)) {
			Utils.mensaje("La prueba se a creado correctamente.");
		}
		
	}
	
	
	
	 public void editarPrueba() {
		 RepoCompeticion rc = RepoCompeticion.newInstance();
		 String nombreComp = Utils.leeString("Introduce el nombre de la competicion a la cual quieras editar una prueba: ");
		 Prueba p = PruebaDAO.buscaPrueba(nombreComp, Utils.validaTipoPrueba("Introduce el tipo de la prueba a editar: "), Utils.validaCategoria("Introduce la categoria de la prueba a editar: "), Utils.validaAparato("Introduce el aparato de la prueba a editar: "));
		 if(PruebaDAO.existePrueba(nombreComp, p)) {
			 TipoPrueba tipo=Utils.validaTipoPrueba("Elige tipo de prueba (INDIVIDUAL/GRUPO) ");
			 Categoria categoria=Utils.validaCategoria("Introduce la categoria (prebenjamin/benjamin/alevin/infantil/junior/senior");
			 Aparato aparato=Utils.validaAparato("Introduce modalidad de prueba ( MAZAS/ARO/CINTA/CUERDA/MLIBRES");

			 
			 p.setTipo(tipo);
			 p.setAparato(aparato);
			 p.setCategoria(categoria);
			 
			 rc.guardaXML();
		 }
		
	 }
	 
	 
	 
	public void eliminaPrueba() {
		
		 String nombreComp = Utils.leeString("Introduce el nombre de la competicion a la cual quieras eliminar una prueba: ");
		 if(PruebaDAO.eliminaPrueba(nombreComp, PruebaDAO.buscaPrueba(nombreComp, Utils.validaTipoPrueba("Introduce el tipo de la prueba a eliminar: "), Utils.validaCategoria("Introduce la categoria de la prueba a eliminar: "), Utils.validaAparato("Introduce el aparato de la prueba a eliminar: ")))) {
			 Utils.mensaje("La prueba se a eliminado correctamente.");
		 }
	 }
	 
	
	
	
	
	 public void muestraPruebas() {
		 String nombreComp = Utils.leeString("Introduce el nombre de la competicion a la cual quieras mostrar todas sus pruebas: ");
		 String pruebas = new String();
		 pruebas = PruebaDAO.mostrarPruebas(nombreComp);
		 Utils.imprimeObjeto(pruebas);
	}
	 
	 
	 
	public void buscarPrueba() {
		String nombreComp = Utils.leeString("Introduce el nombre de la competicion a la cual quieras buscar una prueba: ");
		Utils.imprimeObjeto(PruebaDAO.buscaPrueba(nombreComp, Utils.validaTipoPrueba("Introduce el tipo de la prueba a buscar: "), Utils.validaCategoria("Introduce la categoria de la prueba a buscar: "), Utils.validaAparato("Introduce el aparato de la prueba a buscar: ")));
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
	
	
	


	

}
