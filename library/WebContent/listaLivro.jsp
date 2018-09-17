<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista</title>
</head>
<body>
	<c:import url="Menu.jsp"></c:import>
	<h1> Seu livro ${param.nome }foi adicionado com sucesso! </h1>
	<div style=" font-weight: bold; text-align: center; 
      ">
	<table border=1 >
		<tr>
			<th>Id</th>
			<th>Título</th>
			<th>Autor</th>
			<th>Editora</th>
			<th>Ano de Publicação</th>
			<th>Ano de Edição</th>
		</tr>
		<c:forEach var="livro" items="${livros}">
		<tr>
			<td>${livro.id}</td>
			<td>${livro.titulo}</td>
			<td>${livro.autor}</td>
			<td>${livro.editora}</td>
			<td>${livro.anoPublicado}</td>
			<td>${livro.anoEditado}</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>

