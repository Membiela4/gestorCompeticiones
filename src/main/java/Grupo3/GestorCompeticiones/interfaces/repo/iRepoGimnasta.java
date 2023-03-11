package Grupo3.GestorCompeticiones.interfaces.repo;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;

public interface iRepoGimnasta {
	
	public Gimnasta crearGimnasta();
	
	String  muestraGimnastas();
	
	boolean insertaGimnasta(Gimnasta g);
	
	Gimnasta buscaGimnasta(String dni);
	
	boolean eliminaGinmasta(Gimnasta g);
	
	
}
