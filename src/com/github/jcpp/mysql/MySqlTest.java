package com.github.jcpp.mysql;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jcpp.mysql.db.Database;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class MySqlTest
 */
public class MySqlTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MySqlTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement statement = null;
		Database db = Database.getInstance();
		Connection connection = db.getConnection();
		try
		{
			String insert =	"insert into students(code, firstname, lastname, birthdate) values (?,?,?,?)";
			statement = (PreparedStatement) connection.prepareStatement(insert);
			statement.setString(1, "3");
			statement.setString(2, "Mario");
			statement.setString(3, "Rossi");
			long secs = (new Date()).getTime();
			statement.setDate(4,new	java.sql.Date(secs));
			statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
//			try
//			{
//				//statement.close();
				db.closeConnection(connection);
				//connection.close();
//			}
//			catch (SQLException e) {
//				e.printStackTrace();
//			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
