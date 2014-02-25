<%@page import="br.edu.infnet.DTO.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.infnet.DAO.AlunoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>

	<table>
		<thead>
			<tr>
				<td>Matricula</td>
				<td>Nome</td>
				<td>Op��es</td>
			</tr>
		</thead>
		
		<%
		AlunoDAO dao = new AlunoDAO();
		ArrayList<Aluno> alunoList = dao.Selecionar();
				
		for (Aluno aluno : alunoList){
		%>
			<tr>
				<td>
					<%=aluno.getMatricula()%>
				</td>
				<td>
					<%=aluno.getNome()%>
				</td>
				<td>
					<a href="VisualizarAluno.jsp?matricula=<%=aluno.getMatricula()%>">
						<em>Visualizar</em>
					</a>
					<br>
					<a href="AtualizarAluno.jsp?matricula=<%=aluno.getMatricula()%>">
						<em>Atualizar</em>
					</a>
					<br>
					<a href="Deletar?matricula=<%=aluno.getMatricula()%>">
						<em>Excluir</em>
					</a>
				</td>
			</tr>
		<%
		}
		%>
		
	</table>
	
	<br>
	<br>
	<a href="InserirAluno.jsp">
		<em>Clique Aqui Para Inserir Um Novo Aluno</em>
	</a>

</body>
</html>