<%@page import="br.edu.infnet.DTO.Turma"%>
<%@page import="br.edu.infnet.DAO.TurmaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
<%--
	String id = request.getParameter("id");
	String Nometurma = null;
  
  	TurmaDAO dao = new TurmaDAO();
  	Turma turma = dao.SelecionarPorId(Integer.parseInt(id));
  	
  	
 	
--%>

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
			<tr>
			<c:forEach var="alunos" items="${AlunosLista}">
			${alunos.getNome()}
			</c:forEach>
			
				
			<td><%out.write("ASSOCIAR / DESASSOCIAR"); %></td>
			</tr>
		</tr>
		
	</table>

</body>
</html>