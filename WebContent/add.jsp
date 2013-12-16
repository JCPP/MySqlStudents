<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Student</title>
</head>
<body>
<h1>Add a student</h1>
	<form method="POST" action="studentController">
		<table>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><label for="surname">Surname: </label></td>
				<td><input type="text" name="surname" id="surname" /></td>
			</tr>
			<tr>
				<td><label for="date">Date of birth: </label></td>
				<td><input type="date" name="date" id="date" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Student" /></td>
			</tr>
		</table>
		<input type="hidden" name="operation" value="add" />
	</form>

</body>
</html>