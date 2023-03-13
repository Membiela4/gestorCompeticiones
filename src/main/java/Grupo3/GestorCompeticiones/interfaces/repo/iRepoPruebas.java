package Grupo3.GestorCompeticiones.interfaces.repo;

import Grupo3.GestorCompeticiones.model.DO.Aparato;
import Grupo3.GestorCompeticiones.model.DO.Categoria;
import Grupo3.GestorCompeticiones.model.DO.Prueba;
import Grupo3.GestorCompeticiones.model.DO.TipoPrueba;

public interface iRepoPruebas {
	
	String muestraPrueba();
	
	boolean insertaPrueba(Prueba p);
	
	Prueba buscaPrueba(TipoPrueba prueba, Categoria categoria, Aparato aparato);
	
	boolean eliminaPrueba(Prueba p);

}
