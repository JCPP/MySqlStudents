package com.github.jcpp.mysql;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jcpp.mysql.db.dao.StudentDAO;

/**
 * Servlet implementation class TestDB
 */
public class TestDB extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDB() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
     */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
//      java.sql.Connection connection = null;
//      PreparedStatement statement = null;
//      Database db = Database.getInstance();
 
        try {
 
//          connection = db.getConnection();
             
            StudentDAO studentDAO = new StudentDAO();
            Student student = new Student();
            //student.setCode(4);
            student.setFirstName("Mario");
            student.setLastName("Rossi");
            student.setBirthDate(new Date());
            studentDAO.insertStudent(student);
//          String insert = "insert into students(code, firstname, lastname, birthdate) values (?,?,?,?)";
//          statement = connection.prepareStatement(insert);
//          statement.setInt(1, 4);
//          statement.setString(2, "Mario");
//          statement.setString(3, "Rossi");
//          long secs = (new Date()).getTime();
//          statement.setDate(4, new java.sql.Date(secs));
//
//          statement.executeUpdate();
 
//      } catch (SQLException e) {
//          e.printStackTrace();
//      } catch (ClassNotFoundException e) {
//          e.printStackTrace();
        } finally {
//          try {
//              statement.close();
//              db.closeConnection(connection);
////                connection.close();
//          } catch (SQLException e) {
//              e.printStackTrace();
//          }
        }
 
         
    }
 
}