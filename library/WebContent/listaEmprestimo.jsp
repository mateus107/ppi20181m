<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de empréstimos</title>
</head>
<body>
<c:import url="Menu.jsp"></c:import>

	<h1>Empréstimos cadastrados</h1>
	<div style=" font-weight: bold; text-align: center; 
      ">
	<table border=1 >
		<tr>
			<th>Id do empréstimo</th>
			<th>Id do Aluno</th>
			<th>Id do Livro</th>
			<th>Data do Empréstimo</th>
			
		</tr>
		<c:forEach var="emprestimo" items="${emprestimos}">
		<tr>
			<td>${emprestimo.id}</td>
			<td>${emprestimo.id_aluno}</td>
			<td>${emprestimo.id_livro}</td>
			<td>
				<fmt:formatDate value="${emprestimo.dataEmprestimo.time}"
				pattern="dd/MM/yyyy" />
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>

</body>
</html>