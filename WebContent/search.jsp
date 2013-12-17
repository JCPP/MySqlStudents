<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Students</title>
</head>
<body>
	<form method="POST" action="studentController">
		<table>
			<tr>
				<td><label for="code">Code: </label></td>
				<td><input type="text" name="code" /></td>
			</tr>
			<tr>
				<td><label for="name">Name: </label></td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Search Students" /></td>
			</tr>
		</table>
		<input type="hidden" name="operation" value="search" />
	</form>
</body>
</html>