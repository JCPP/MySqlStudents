<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert your data</title>
</head>
<body>
<h1>Inserisci i tuoi dati</h1>
	<form method="POST" action="formInserimento">
		<table>
			<tr>
				<td><label for="nome">Nome: </label></td>
				<td><input type="text" name="nome" id="nome" /></td>
			</tr>
			<tr>
				<td><label for="cognome">Cognome: </label></td>
				<td><input type="text" name="cognome" id="cognome" /></td>
			</tr>
			<tr>
				<td><label for="compleanno">Data di nascita: </label></td>
				<td><input type="date" name="compleanno" id="compleanno" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Eat me" /></td>
			</tr>
		</table>
	</form>

</body>
</html>