package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Studente;

public class CorsoDAO {
	
	public List<Corso> getCorsiByPeriodo(int periodo) {
		
		String sql = "SELECT * "
				+ "FROM corso "
				+ "WHERE pd = ?";
		
		List<Corso> resultCorso = new ArrayList<Corso>();
		
		
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"),
						rs.getInt("crediti"),
						rs.getString("nome"),
						rs.getInt("pd"));
				resultCorso.add(c);
			}
			
			st.close();
			rs.close();
			conn.close();
			
		} catch (SQLException e) {
			System.out.println("Errore in Corso DAO");
			e.printStackTrace();
			return null;
		}
		
		return resultCorso;
		
	}
	
	public Map<Corso,Integer> getCorsiIscritti (int periodo) {
		
		String sql = "SELECT c.codins,c.crediti,c.nome, COUNT(*) AS n"
					+" FROM corso c, iscrizione i "
					+" WHERE c.codins =i.codins AND c.pd = ?"
					+" GROUP BY c.codins,c.crediti , c.nome,c.pd";
		
		Map<Corso,Integer> result = new HashMap<>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1,periodo);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				Corso c = new Corso(rs.getString("codins"),
						rs.getInt("crediti"),
						rs.getString("nome"),
						rs.getInt("pd"));
				
				result.put(c, rs.getInt("n"));
				
			}
			
			st.close();
			rs.close();
			conn.close();
			
			
		}catch (SQLException e) {
			System.out.println("Errore in Corso DAO");
			e.printStackTrace();
			return null;
		}
		
		return result;
		
	}
	
	public Map<String,Studente> getStudentiPerCorso(String codins){
		
		String sql = "SELECT s.matricola , s.nome , s.cognome "
				+"FROM studente s ,iscrizione i "
				+"WHERE i.codins = ? AND s.matricola = i.matricola ";

		Map<String,Studente> result = new HashMap<String,Studente>();
		

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,codins);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				
				Studente s = new Studente(rs.getString("matricola"),
						rs.getString("nome"),
						rs.getString("cognome"),
						rs.getString(codins));
						
				
				result.put(codins , s);
				
			}
			
			st.close();
			rs.close();
			conn.close();
			
			
		}catch (SQLException e) {
			System.out.println("Errore in Corso DAO");
			e.printStackTrace();
			return null;
		}
		
		return result;

		
	}

}
