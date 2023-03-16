package Grupo3.GestorCompeticiones.controlador;

import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorCompeticion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorParticipacion;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPrincipal;
import Grupo3.GestorCompeticiones.interfaces.controlador.iControladorPruebas;
import Grupo3.GestorCompeticiones.interfaces.repo.iRepoPruebas;
import Grupo3.GestorCompeticiones.model.DO.Aparato;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.DO.TipoPrueba;
import Grupo3.GestorCompeticiones.utils.Utils;
import Grupo3.GestorCompeticiones.vista.VistaPruebas;

public class ControladorPruebas implements iControladorPruebas {
	private VistaPruebas vistapruebas;
	private iRepoPruebas repoPruebas;
	private iControladorParticipacion controlarParticipacion;
	private ControladorPrincipal controlarPrincipal;
	private ControladorCompeticion controlarComp;

	public void ejecutarMenuInsertarPrueba() {
		int opcion;
		do {

			vistapruebas.mostrarMenuInsertarPrueba();
			opcion = Utils.leeEntero("Elige una opcion: ");
			controlarMenuInsertarPrueba(opcion);
		} while (opcion != 7);

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
		TipoPrueba tipo = Utils.validaTipoPrueba("Introduce el tipo de prueba");
		Categoria categoria = Utils.validaCategoria("Introduce la categor�a");
		Aparato aparato = Utils.validaAparato("Introduce el aparato");

		Prueba prueba = new Prueba(tipo, categoria, aparato, null);
		repoPruebas.insertaPrueba(prueba);
		Utils.mensaje("Prueba creada correctamente");
	}

	public void buscarPrueba() {
		TipoPrueba prueba = Utils.validaTipoPrueba("Introduce el tipo de prueba");
		Categoria categoria = Utils.validaCategoria("Introduce la categor�a");
		Aparato aparato = Utils.validaAparato("Introduce el aparato");
		Utils.imprimeObjeto(repoPruebas.buscaPrueba(prueba, categoria, aparato));
	}

	public void editarPrueba() {
		TipoPrueba tipo1 = Utils.validaTipoPrueba("Introduce el tipo de prueba a editar");
		Categoria categoria1 = Utils.validaCategoria("Introduce la categor�a a editar");
		Aparato aparato1 = Utils.validaAparato("Introduce el aparato a editar");
		Prueba prueba = repoPruebas.buscaPrueba(tipo1, categoria1, aparato1);
		if (prueba != null) {
			prueba.setTipo(tipo1);
			prueba.setCategoria(categoria1);
			prueba.setAparato(aparato1);
			Utils.mensaje("Prueba actualizada correctamente");
		} else {
			Utils.mensaje("No se encontr� la prueba");
		}
	}

	public void eliminaPrueba() {
		TipoPrueba prueba = Utils.validaTipoPrueba("Introduce el tipo de prueba");
		Categoria categoria = Utils.validaCategoria("Introduce la categor�a");
		Aparato aparato = Utils.validaAparato("Introduce el aparato");
		Prueba p = repoPruebas.buscaPrueba(prueba, categoria, aparato);
		if (repoPruebas.eliminaPrueba(p)) {
			Utils.mensaje("Prueba eliminada correctamente");
		} else {
			Utils.mensaje("No se pudo eliminar la prueba");
		}

	}

	public void muestraPrueba() {
		String muestraPruebas = repoPruebas.muestraPrueba();
		Utils.mensaje(muestraPruebas);
	}

	public void ejecutarMenuInsertarParticipaciones() {
		controlarParticipacion.controlarMenuInsertarParticipaciones(0);
	}

	public void volverMenuPrincipal() {
		controlarPrincipal.controlarMenuPrincipal();
	}

	public void volverMenuCompeticion() {
		controlarComp.controlarMenuCompeticion(0);

	}

}
