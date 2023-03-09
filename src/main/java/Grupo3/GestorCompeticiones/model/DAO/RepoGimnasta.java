package Grupo3.GestorCompeticiones.model.DAO;

import java.util.ArrayList;

import Grupo3.GestorCompeticiones.model.DO.Gimnasta;

public class RepoGimnasta {

	public void mostrarGimnastas(ArrayList<Gimnasta> gimnastas) {
		for (Gimnasta gimnasta : gimnastas) 
			System.out.println(gimnasta);
		
	}
	
	public Gimnasta crearGimnasta() {
		Gimnasta g = new Gimnasta();
		
		return g;
		
	}
	
}
