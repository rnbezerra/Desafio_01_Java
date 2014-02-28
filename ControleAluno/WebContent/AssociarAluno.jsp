<%@page import="br.edu.infnet.DTO.Turma"%>
<%@page import="br.edu.infnet.DAO.TurmaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>${Turma.getNome()}</title>
</head>
<body>
<h1>${Turma.getNome()}</h1>

	
	<table>
		<tr>
			<td>Aluno</td>
			
			<c:forEach var="alunos" items="${AlunosLista}">
			<tr>
				
				<td>${alunos.getNome()}</td>
				<c:if test="${Turma.ContemAluno(alunos.getMatricula()) == true}">
				<td><a href="DesassociarTurmaAluno?turma=${Turma.getId()}&matricula=${alunos.getMatricula()}"><%out.write("DESASSOCIAR");%></a></td>
				</c:if> 
				<c:if test="${Turma.ContemAluno(alunos.getMatricula()) == false}">
				<td><a href="AssociarTurmaAluno?turma=${Turma.getId()}&matricula=${alunos.getMatricula()}"><%out.write("ASSOCIAR"); %></a></td>
				</c:if> 		
				
			</tr>
			</c:forEach>
						
		</tr>
	</table>
	
	
	<br>
	<br>
	<a href="VisualizarTurmas.jsp">
		<em>Voltar</em>
	</a>

</body>
</html>