package Grupo3.GestorCompeticiones.interfacesDAO;

import Grupo3.GestorCompeticiones.model.DO.Aparato;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.DO.TipoPrueba;

public interface iPruebasDAO {
	
	String muestraPrueba();
	
	boolean insertaPrueba(Prueba p);
	
	Prueba buscaPrueba(TipoPrueba prueba, Categoria categoria, Aparato aparato);
	
	boolean eliminaPrueba(Prueba p);

}
