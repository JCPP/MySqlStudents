package com.github.jcpp.mysql.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.github.jcpp.mysql.Student;
import com.github.jcpp.mysql.db.Database;


public class StudentDAO {

	private Database db = Database.getInstance();


	public boolean insertStudent(Student student) {
		Connection con = db.getConnection();
		boolean success = false;
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			String insert = "insert into students(code, firstname, lastname, birthdate) values (?,?,?,?)";
			stmt = con.prepareStatement(insert);
			stmt.setInt(1, student.getCode());
			stmt.setString(2, student.getFirstName());
			stmt.setString(3, student.getLastName());
			long secs = student.getBirthDate().getTime();
			stmt.setDate(4, new java.sql.Date(secs));
			stmt.executeUpdate();
			con.commit();
			success = true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				if (stmt!=null) { stmt.close(); stmt=null; }
				db.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}



}
