<%@page import="br.edu.infnet.DTO.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.infnet.DAO.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
			</tr>
		</thead>
		
		<%
		AlunoDAO dao = new AlunoDAO();
		ArrayList<Aluno> alunoList = dao.Selecionar();
				
		for (Aluno aluno : alunoList){
		%>
			<tr>
				<td>
					<%out.write(String.format("%d", aluno.getMatricula())); %>
				</td>
				<td>
					<%out.write(String.format("%s", aluno.getNome())); %>
				</td>
			</tr>
		<%
		}
		%>
		
	</table>

</body>
</html>