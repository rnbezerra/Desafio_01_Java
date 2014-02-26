package br.edu.infnet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public Turma SelecionarId(Integer id) throws ClassNotFoundException,
			SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("SELECT \"id\", \"nome\" FROM \"turma\" WHERE \"id\" = ?");
		query.setString(1, id.toString());

		ResultSet resultados = query.executeQuery();
		Turma turma = new Turma();

		while (resultados.next()) {
			turma.setId(Integer.parseInt(resultados.getString("id")));
			turma.setNome(resultados.getString("nome"));
			break;
		}
		return turma;
	}
}
