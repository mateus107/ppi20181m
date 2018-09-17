<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,400" rel="stylesheet">
<title>Menu do sistema</title>
<style>
body{
font-family: 'Roboto Condensed', sans-serif;

}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
    
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>
</head>
<body>
<h1 style="margin: auto; text-align: center; font-size: 40px;
">Biblioteca</h1>
<hr/>
	<ul>
  <li><a class="active" href="#home">Home</a></li>
  <li><a href="cadastroAluno.jsp">Cadastro de Alunos</a></li>
  <li><a href="cadastroLivro.jsp">Cadrastro de Livros</a></li>
  <li><a href="sistema?comando=ListarAL">Adicione um Empréstimo</a></li>
  <li><a href="sistema?comando=ListarAlunos">Lista de Alunos</a></li>
  <li><a href="sistema?comando=ListarLivros">Lista de Livros</a></li>
  <li><a href="sistema?comando=listaEmprestimo">Lista de Emprestimos</a></li>
</ul>
</body>
</html>