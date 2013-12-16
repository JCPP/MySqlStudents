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
<title>Delete Student</title>
</head>
<body>
<h1>Delete a student</h1>
	<form method="POST" action="studentController">
		<table>
			<tr>
				<td><label for="code">Code: </label></td>
				<td>
					<select name="code">
						<option value=""></option>
						<%
							for(Student student : students){
								out.print("<option value=\"" + student.getCode() + "\">" + student.getFirstName() + " " + student.getLastName() + "</option>");
							}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Delete Student" /></td>
			</tr>
		</table>
		<input type="hidden" name="operation" value="delete" />
	</form>

</body>
</html>