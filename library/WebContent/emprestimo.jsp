<%@page import="library.daos.LivroDAO"%>
<%@page import="library.models.Livro"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:import url="Menu.jsp"></c:import>




<!-- 	ZOna pro emprestimo, teoricamente, a gtn vai fazer com quem toda a zona do submit seja relacionado ao emprestimo q é uam tabela
essa comparação é do livro e aluno cadastrado, logo algo salvar baseado nos buttons types q sãode aluno matricula e livro titulo e joga
pro emprestimo e faz data prevista. -->
	

<form action="sistema" method="post">
	<input type="hidden" name="comando" value="AdicionarEmprestimo">
	
	<div>
		<select id="lala" name="livro"> 
			<option value=""> Livros Disponiveis </option>
			<c:forEach var="livro" items="${livros}">
				<option value="${livro.id}">${livro.titulo}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<select id="lala2" name="aluno"> 
			<option value=""> Aluno </option>
			<c:forEach var="aluno" items="${alunos}">
				<option value="${aluno.matricula}">${aluno.nome}</option>
			</c:forEach>
		</select>
	</div>
	<div>
		<label>Data do Emprestimo </label>
		<input type="text" name="dataEmprestimo">
	</div>


	<div>
		<button type="submit">Adicionar</button>
	</div>
</form>


</body>
</html>