package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDAO;
	
	public Model() {
		this.corsoDAO = new CorsoDAO();
		
	}
	
	public List<Corso> getCorsiByPeriodo (int periodo){
		return this.corsoDAO.getCorsiByPeriodo(periodo);
	}
	
	public Map<Corso,Integer> getCorsiIscritti( int periodo){
		return this.corsoDAO.getCorsiIscritti(periodo);
	}
	
	public Map<String,Studente> getStudentiPerCorso(String codins){
		return this.corsoDAO.getStudentiPerCorso(codins);
		
	}
	
	
	
}
