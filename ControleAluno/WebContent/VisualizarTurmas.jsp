<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.infnet.DAO.TurmaDAO"%>
<%@page import="br.edu.infnet.DTO.Turma"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizar Turmas</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<td>Nome</td>
				<td>Opções</td>
			</tr>
		</thead>
		
		<%
		TurmaDAO dao = new TurmaDAO();
		ArrayList<Turma> turmaList = dao.Selecionar();
		
		for (Turma turma : turmaList){
			
		%>
			<tr>
				<td>
					<%out.write(turma.getNome());%>
				</td>
				<td>
					<a href="AssociarTurmaAluno.jsp?id=<%=turma.getId()%>">
						<em>Associar Aluno</em>
					</a>
				</td>
			</tr>
		<%
		}
		%>
		
	</table>
	
	<br>
	<br>
	<a href="InserirTurma.jsp">
		<em>Clique Aqui Para Inserir Uma Nova Turma</em>
	</a>

</body>
</html>