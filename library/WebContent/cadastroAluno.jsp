<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adicionar Aluno</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<c:import url="Menu.jsp"></c:import>
    <h1> ${mensagem} </h1>
	<form action="sistema" method="post">
	<input type="hidden" name="comando" value="AdicionarAluno">
	
		<div>
			<label>Matricula: </label>
			<input type="text" name="matricula">
		</div>
		<div>
			<label>Nome: </label>
			<input type="text" name="nome">
		</div>
		<div>
			<label>Cpf: </label>
			<input type="text" name="cpf">
		</div>
		<div>
			<label>Data de Nascimento: </label>
			<input type="text" name="dataNascimento">
		</div>
		<div>
			<label>Endere�o: </label>
			<input type="text" name="endereco">
		</div>
		
		<div>
			<button type="submit">Adicionar</button>
		</div>
	</form>
	

</body>
</html>