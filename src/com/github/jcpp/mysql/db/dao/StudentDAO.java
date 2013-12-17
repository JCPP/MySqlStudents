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

	/**
	 * Insert a new student.
	 * @param student the student instance
	 * @return Is the operation ok?
	 */
	public boolean insertStudent(Student student) {
		Connection con = db.getConnection();
		boolean success = false;
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			String insert = "insert into students(firstname, lastname, birthdate) values (?,?,?)";
			stmt = con.prepareStatement(insert);
			//stmt.setString(1, "");
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			long secs = student.getBirthDate().getTime();
			stmt.setDate(3, new java.sql.Date(secs));
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
				if (stmt!=null) {
					stmt.close();
					stmt=null;
				}
				db.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}


	/**
	 * Get the list of the students.
	 * @return An ArrayList<Student>.
	 */
	public ArrayList<Student> getAllStudents() {
		Connection con = db.getConnection();
		ArrayList<Student> students = new ArrayList<Student>();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			String insert = "SELECT * FROM students";
			stmt = con.prepareStatement(insert);
			ResultSet resultSet = stmt.executeQuery();
			Student student;
			
			
			while(resultSet.next()){
				student = new Student();
				student.setCode(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setBirthDate(resultSet.getDate(4));
				students.add(student);
			}
			
			con.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				if (stmt!=null) {
					stmt.close();
					stmt=null;
				}
				db.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}
	
	
	/**
	 * Get a student by the code.
	 * @param code the code of the student.
	 * @return A Student object.
	 */
	public Student getStudentByCode(int code) {
		Connection con = db.getConnection();
		Student student = null;
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			String insert = "SELECT * FROM students WHERE code = ?";
			stmt = con.prepareStatement(insert);
			stmt.setInt(1, code);
			ResultSet resultSet = stmt.executeQuery();
			
			if(resultSet.next()){
				student = new Student();
				student.setCode(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setBirthDate(resultSet.getDate(4));
			}
			
			con.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				if (stmt!=null) {
					stmt.close();
					stmt=null;
				}
				db.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}
	
	
	/**
	 * Get an ArrayList<Student> by the name.
	 * @param name the name of the student.
	 * @return An ArrayList<Student> object.
	 */
	public ArrayList<Student> getStudentsByName(String name) {
		Connection con = db.getConnection();
		ArrayList<Student> students = new ArrayList<Student>();
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			String insert = "SELECT * FROM students WHERE firstname LIKE ?";
			stmt = con.prepareStatement(insert);
			stmt.setString(1, "%" + name + "%");
			ResultSet resultSet = stmt.executeQuery();
			Student student;
			
			
			while(resultSet.next()){
				student = new Student();
				student.setCode(resultSet.getInt(1));
				student.setFirstName(resultSet.getString(2));
				student.setLastName(resultSet.getString(3));
				student.setBirthDate(resultSet.getDate(4));
				students.add(student);
			}
			
			con.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} finally {
			try {
				if (stmt!=null) {
					stmt.close();
					stmt=null;
				}
				db.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return students;
	}


	/**
	 * Delete a student.
	 * @param code the code of the student
	 * @return Is the operation ok?
	 */
	public boolean deleteStudent(int code) {
		Connection con = db.getConnection();
		boolean success = false;
		PreparedStatement stmt = null;
		try {
			con.setAutoCommit(false);
			String delete = "DELETE FROM students WHERE code = ?";
			stmt = con.prepareStatement(delete);
			stmt.setInt(1, code);
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
				if (stmt!=null) {
					stmt.close();
					stmt=null;
				}
				db.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

}
