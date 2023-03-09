package Grupo3.GestorCompeticiones.interfaces.repo;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;

public interface iRepoGimnasta {
	
	String muestraGimnastas();
	
	boolean insertaGimnasta(Gimnasta g);
	
	Gimnasta buscaGimnasta(String dni);
	
	boolean eliminsGinmasta(Gimnasta g);
	
	
}
