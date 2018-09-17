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
	<h1>Os contatos são</h1>
	<div style=" font-weight: bold; text-align: center; 
      ">
	<table border=1 >
		<tr>
			<th>Name</th>
			<th>Endereço</th>
			<th>Email</th>
			<th>Data</th>
		</tr>
		<c:forEach var="contato" items="${contatos}">
		<tr>
			<td>${contato.nome}</td>
			<td>
				<c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
				</c:if>
				<c:if test="${empty contato.email}">
					E-mail não informado
				</c:if>
			</td>
			<td>${contato.endereco}</td>
			<td>
				<fmt:formatDate value="${contato.dataNascimento.time}"
				pattern="dd/MM/yyyy" />
			</td>
		</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>

