<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adicionar Livro</title>
<meta http-equiv="Content-Type" content="text/html;">
<meta charset="ISO-8859-1">
</head>
<body>
	<c:import url="Menu.jsp"></c:import>
	<h1> ${mensagem} </h1>
	<form action="sistema" method="post">
	<input type="hidden" name="comando" value="AdicionarLivro">
	
		<div>
			<label>Titulo: </label>
			<input type="text" name="titulo">
		</div>
		<div>
			<label>Autor: </label>
			<input type="text" name="autor">
		</div>
		<div>
			<label>Editora: </label>
			<input type="text" name="editora">
		</div>
		<div>
			<label>Ano Publicado: </label>
			<input type="text" name="anoPublicado">
		</div>
		<div>
			<label>Ano Editado: </label>
			<input type="text" name="anoEditado">
		</div>
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
	

</body>
</html>