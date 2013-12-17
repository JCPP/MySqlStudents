package com.github.jcpp.mysql.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		Student student;
		
		//Initizialize parameters
		String code;
		int intCode;
		String name;
		String surname;
		
		//Manage the operation
		switch(operation){
			case "add":
				//printWriter.println("Add operation");
				
				//Read parameters
				name = request.getParameter("name");
				surname = request.getParameter("surname");
				Date date = null;
				try {
					date = new SimpleDateFormat("yyy-mm-dd").parse(request.getParameter("date"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				//printWriter.println(request.getParameter("date"));
				
				student = new Student(name, surname, date);
				
				if(studentDAO.insertStudent(student)){
					request.setAttribute("message", "Student added");
				}
				else{
					request.setAttribute("message", "Student doesn't added");
				}
				break;
			case "delete":
				//printWriter.println("Delete operation");
				
				//Read parameters
				code = request.getParameter("code");
				intCode = Integer.parseInt(code);
				
				if(studentDAO.deleteStudent(intCode)){
					request.setAttribute("message", "Student deleted");
				}
				else{
					request.setAttribute("message", "Student doesn't deleted");
				}
				break;
			case "search":
				//printWriter.println("Search operation");
				
				//Initializes
				ArrayList<Student> students = new ArrayList<Student>();
				
				//Read parameters
				code = request.getParameter("code");
				name = request.getParameter("name");
				
				//Check if the parameters is null
				if(code == null || code.isEmpty()){
					if(name == null || name.isEmpty()){
						
					}
					else{
						students.addAll(studentDAO.getStudentsByName(name));
					}
				}
				else{
					intCode = Integer.parseInt(code);
					student = studentDAO.getStudentByCode(intCode);
					if(student != null){
						students.add(student);
					}
				}
				
				
				//Set the attributes
				if(students.isEmpty()){
					request.setAttribute("message", "No student found");
				}
				else{
					request.setAttribute("message", "Students found");
				}
				
				request.setAttribute("students", students);
				
				break;
			default:
				request.setAttribute("message", "Operation not supported");
				break;
		}
		
		if(operation.equals("search")){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/search_result.jsp");
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/message.jsp");
			dispatcher.forward(request, response);
		}
	}

}
