package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() {
		
		String url = "jdbc:mysql://localhost/iscritticorsi?user=root&password=olivinopanevino";
		
		try {
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Errore nella connessione ");
			e.printStackTrace();
			return null;
		}
		
	}

}
