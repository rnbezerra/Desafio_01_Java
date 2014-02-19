<%@page import="br.edu.infnet.DTO.Aluno"%>
<%@page import="br.edu.infnet.DAO.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	String matricula = request.getParameter("matricula");

	
	AlunoDAO dao = new AlunoDAO();
	Aluno aluno = dao.SelecionarMatricula(matricula);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%out.write(aluno.getNome()); %></title>
</head>
<body>
	<h1>Visualização de Aluno</h1>
	
	<br>
	
	<br>
	
	<table>
		<tr>
			<td>Matrícula:</td>
			<td><%out.write(aluno.getMatricula()); %></td>
		</tr>	
		<tr>
			<td>Nome:</td>
			<td><%out.write(aluno.getNome()); %></td>
		</tr>	
	</table>
	
	
	<br>
	
	<br>
	
	<a href="index.jsp">
		<em>Voltar</em>
	</a>
</body>
</html>