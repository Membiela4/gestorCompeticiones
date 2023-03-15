package Grupo3.GestorCompeticiones.interfaces.repo;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;

public interface iRepoGimnasta {
	
	
	public String muestraGimnastas();
	
	boolean insertaGimnasta(Gimnasta g);
	
	Gimnasta buscaGimnasta(String dni);
	
	boolean eliminaGinmasta(Gimnasta g);
	
	
}
