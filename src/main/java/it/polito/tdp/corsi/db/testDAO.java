package it.polito.tdp.corsi.db;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class testDAO {

	public static void main(String[] args) {
		
		CorsoDAO dao = new CorsoDAO();
		
		List<Corso> result = new ArrayList<Corso>();
		
		result = dao.getCorsiByPeriodo(1);
		
		for(Corso s : result) {
			System.out.println(s);
			
		}

	}

}
