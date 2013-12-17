<%@page import="com.github.jcpp.mysql.db.dao.StudentDAO"%>
<%@page import="com.github.jcpp.mysql.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	StudentDAO studentDAO = new StudentDAO();
	ArrayList<Student> students = studentDAO.getAllStudents();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student list</title>
</head>
<body>
	<h1>Student List</h1>
	<% if(!students.isEmpty()){ %>
		<table border="1px">
			<tr>
				<th>Code</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Birth Date</th>
			</tr>
			<% for(Student student : students){ %>
			<tr>
				<td><%= student.getCode() %></td>
				<td><%= student.getFirstName() %></td>
				<td><%= student.getLastName() %></td>
				<td><%= student.getBirthDate() %></td>
			</tr>
			<% } %>
		</table>
	<% } else{ %>
		<b>No Student Found</b>
	<% } %>
</body>
</html>