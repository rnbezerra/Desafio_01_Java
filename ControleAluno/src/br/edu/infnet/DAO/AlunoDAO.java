package br.edu.infnet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.infnet.DTO.Aluno;
import br.edu.infnet.conection.Conexao;

public class AlunoDAO {

	Connection conn = null;

	private void connect() throws ClassNotFoundException, SQLException {
		Conexao conexao = new Conexao();
		conn = conexao.getConexao();

	}

	public void Inserir(Aluno aluno) throws ClassNotFoundException,
			SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("INSERT INTO \"aluno\"(\"nome\", \"matricula\")  VALUES ( ?, ?)");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getMatricula());
		query.execute();

	}

	public ArrayList<Aluno> Selecionar() throws ClassNotFoundException, SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("SELECT \"matricula\", \"nome\" FROM aluno");

		ResultSet resultados = query.executeQuery();
		ArrayList<Aluno> ListaAlunos = new ArrayList<Aluno>();

		while (resultados.next()) {
			Aluno aluno = new Aluno();
			aluno.setMatricula(resultados.getString("matricula"));
			aluno.setNome(resultados.getString("nome"));

			ListaAlunos.add(aluno);
		}
		return ListaAlunos;
	}

	public Aluno SelecionarMatricula(String matricula)
			throws ClassNotFoundException, SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("SELECT \"matricula\", \"nome\" FROM aluno WHERE \"matricula\" LIKE ?");
		query.setString(1, "%" + matricula + "%");

		ResultSet resultados = query.executeQuery();
		Aluno aluno = new Aluno();

		while (resultados.next()) {
			aluno.setMatricula(resultados.getString("matricula"));
			aluno.setNome(resultados.getString("nome"));
			break;
		}
		return aluno;
	}

	public void Alterar(Aluno aluno) throws ClassNotFoundException,
			SQLException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("UPDATE aluno SET \"nome\" = ? WHERE \"matricula\" = ?");
		query.setString(1, aluno.getNome());
		query.setString(2, aluno.getMatricula());

		query.executeUpdate();

	}

	public void Deletar(String matricula) throws SQLException,
			ClassNotFoundException {
		connect();
		PreparedStatement query = this.conn
				.prepareStatement("DELETE FROM aluno WHERE \"matricula\" = ?");
		query.setString(1, matricula);
		
		query.executeUpdate();

	}
}
