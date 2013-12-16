package com.github.jcpp.mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


public class Database {
	private static Database database = null;
	private final String DRIVERNAME = "org.mysql.jdbc.Driver";
	private final String CONNECTIONSTRING = "jdbc:mysql://localhost/university";
	private final String DBUSER = "root";
	private final String DBPASS = "";


	private Database() {
	}

	public static Database getInstance() {
		if (database == null){
			database = new Database();
		}
		return database;
	}

	public Connection getConnection() {
		Connection con = null;
		Context initCtx;
		try {
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			BasicDataSource ds = (BasicDataSource) envCtx.lookup("jdbc/university");
			con = ds.getConnection();
			System.out.println("##db## - 'Pooled Connection' acquisita.");
		} catch (NamingException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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
