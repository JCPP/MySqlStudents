package com.github.jcpp.mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	private static Database database = null;
	private final String DRIVERNAME = "com.mysql.jdbc.Driver";
	private final String CONNECTIONSTRING = "jdbc:mysql://localhost/university";
	private final String DBUSER = "root";
	private final String DBPASS = "";
	private Database() {
	}
	public static Database getInstance() {
		if (database == null)
			database = new Database();
		return database;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(CONNECTIONSTRING, DBUSER, DBPASS);
			System.out.println("##db## - Connessione acquisita.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Errore sul driver: "+ e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'acquisizione della connessione."+
					e.getMessage());
		}
		return con;
	}
	
	
	public void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
				System.out.println("##db## - Connessione rilasciata.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante la chiusura della connessione."+
					e.getMessage());
		}
	}

}
