<%@page import="br.edu.infnet.utils.*"%>
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
<title><%=aluno.getNome() %></title>
</head>
<body>
	<h1>Visualiza��o de Aluno</h1>
	
	<br>
	
	<br>
	
	<table>
		<tr>
			<td>Matr�cula:</td>
			<td><%=aluno.getMatricula()%></td>
		</tr>	
		<tr>
			<td>Nome:</td>
			<td><%=aluno.getNome()%></td>
		</tr>	
	</table>
	
	
	<br>
	
	<br>
	
	<a href="index.jsp">
		<em>Voltar</em>
	</a>
</body>
</html>