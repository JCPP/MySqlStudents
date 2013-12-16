package com.github.jcpp.mysql.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.jcpp.mysql.Student;
import com.github.jcpp.mysql.db.dao.StudentDAO;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		PrintWriter printWriter = response.getWriter();
		StudentDAO studentDAO = new StudentDAO();
		
		//Manage the operation
		
		//Add
		if(operation.equals("add")){
			//printWriter.println("Add operation");
			
			//Read parameters
			String name = request.getParameter("name");
			String surname = request.getParameter("surname");
			Date date = null;
			try {
				date = new SimpleDateFormat("yyy-mm-dd").parse(request.getParameter("date"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			//printWriter.println(request.getParameter("date"));
			
			Student student = new Student(name, surname, date);
			
			if(studentDAO.insertStudent(student)){
				request.setAttribute("message", "Student added");
			}
			else{
				request.setAttribute("message", "Student doesn't added");
			}
			
		}
		//Delete
		else if(operation.equals("delete")){
			//printWriter.println("Delete operation");
			
			//Read parameters
			String code = request.getParameter("code");
			int intCode = Integer.parseInt(code);
			
			if(studentDAO.deleteStudent(intCode)){
				request.setAttribute("message", "Student deleted");
			}
			else{
				request.setAttribute("message", "Student doesn't deleted");
			}
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
		dispatcher.forward(request, response);
		
	}

}
