<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.github.jcpp.mysql.Student"%>
<%
	ArrayList<Student> students = (ArrayList<Student>) request.getAttribute("students");
	String message = (String) request.getAttribute("message");
	Iterator<Student> studentsIterator;
	
	Student student = new Student();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search result</title>
</head>
<body>
	<h1><%= message %></h1>
	<% if(!students.isEmpty()){ 
		studentsIterator = students.iterator();
	%>
		<table border="1px">
			<tr>
				<th>Code</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Birth Date</th>
			</tr>
			<% while(studentsIterator.hasNext()){ 
				student = studentsIterator.next();
			%>
			<tr>
				<td><%= student.getCode() %></td>
				<td><%= student.getFirstName() %></td>
				<td><%= student.getLastName() %></td>
				<td><%= student.getBirthDate() %></td>
			</tr>
			<% } %>
		</table>
	<% } %>
</body>
</html>