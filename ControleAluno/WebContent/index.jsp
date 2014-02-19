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
				<td>Opções</td>
			</tr>
		</thead>
		
		<%
		AlunoDAO dao = new AlunoDAO();
		ArrayList<Aluno> alunoList = dao.Selecionar();
				
		for (Aluno aluno : alunoList){
		%>
			<tr>
				<td>
					<%out.write(aluno.getMatricula()); %>
				</td>
				<td>
					<%out.write(aluno.getNome()); %>
				</td>
				<td>
					<a href="VisualizarAluno.jsp?matricula=<%out.write(aluno.getMatricula()); %>">
						<em>Visualizar</em>
					</a>
					<br>
					<a href="AtualizarAluno.jsp?matricula=<%out.write(aluno.getMatricula()); %>">
						<em>Atualizar</em>
					</a>
					<br>
					<a href="Deletar?matricula=<%out.write(aluno.getMatricula()); %>">
						<em>Excluir</em>
					</a>
				</td>
			</tr>
		<%
		}
		%>
		
	</table>

</body>
</html>