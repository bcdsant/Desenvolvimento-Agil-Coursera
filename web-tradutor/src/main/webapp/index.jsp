<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Traduzir</title>
</head>
<body>
	<form action="./funcao?executa=Traduzir" method="post">
		<input name="traduzir" type="text" placeholder="Digitar Texto"  value="${traduzir}"/>
		<input type="submit" />
		<h2>${traducao}</h2>
	</form>
</body>
</html>