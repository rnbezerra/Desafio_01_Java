package br.edu.infnet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.infnet.DTO.Aluno;
import br.edu.infnet.DTO.Turma;
import br.edu.infnet.conection.Conexao;

public class TurmaDAO {

	Connection conn = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		conn = conexao.getConexao();

	}

	public void Inserir(Turma turma) throws ClassNotFoundException,
			SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("INSERT INTO \"turma\"( \"nome\")  VALUES (?)");
		query.setString(1, turma.getNome());
		query.execute();

	}

	public ArrayList<Turma> Selecionar() throws ClassNotFoundException,
			SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("SELECT \"id\", \"nome\" FROM \"turma\" ");

		ResultSet resultados = query.executeQuery();
		ArrayList<Turma> ListaTurmas = new ArrayList<Turma>();

		while (resultados.next()) {
			Turma turma = new Turma();
			turma.setId(resultados.getInt("id"));
			turma.setNome(resultados.getString("nome"));

			ListaTurmas.add(turma);
		}
		return ListaTurmas;
	}

	public Turma SelecionarId(int id) throws ClassNotFoundException,
			SQLException {
		return SelecionarPorId(id, false);
	}

	public Turma SelecionarPorId(int id, boolean buscarAlunos) throws ClassNotFoundException,
			SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("SELECT \"id\", \"nome\" FROM \"turma\" WHERE \"id\" = ?");
		query.setInt(1, id);

		ResultSet resultados = query.executeQuery();
		Turma turma = new Turma();

		if (resultados.next()) {
			turma.setId(resultados.getInt(("id")));
			turma.setNome(resultados.getString("nome"));
		}

		resultados.close();
		query.close();
		
		if (buscarAlunos) {
			query = this.conn.prepareStatement("");
			ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();

			resultados = query.executeQuery();
			
			while (resultados.next()) {
				Aluno aluno = new Aluno();
				aluno.setMatricula(resultados.getString("matricula"));
				aluno.setNome(resultados.getString("nome"));

				listaAlunos.add(aluno);
			}
			

			resultados.close();
			query.close();
			
			turma.setAlunos(listaAlunos);
		}
		
		return turma;
	}
}
