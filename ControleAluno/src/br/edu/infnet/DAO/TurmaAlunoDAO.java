package br.edu.infnet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.infnet.DTO.Aluno;
import br.edu.infnet.DTO.Turma;
import br.edu.infnet.conection.Conexao;

public class TurmaAlunoDAO {

	   Connection conn = null;

       private void connect() throws ClassNotFoundException, SQLException {
               Conexao conexao = new Conexao();
               conn = conexao.getConexao();

       }

       public void Inserir(Turma turma, Aluno aluno) throws ClassNotFoundException, SQLException {
               connect();
               PreparedStatement query = this.conn
                               .prepareStatement("INSERT INTO \"turma_aluno\"( \"id_turma\", \"matricula_aluno\")  VALUES (?,?)");
               query.setInt(1, turma.getId() );
               query.setString(2, aluno.getMatricula() );
               query.execute();

       }
       

       public void Deletar(Integer id) throws ClassNotFoundException, SQLException
       {
    	   
    	   connect();
    	   PreparedStatement query = this.conn
    			   .prepareStatement("DELETE FROM \"turma_aluno\" WHERE \"id\"= ?");
    	   
    	   query.setInt(1, id);
    	   query.executeUpdate();
       }
       
       
       public void Deletar(Turma turma, Aluno aluno) throws ClassNotFoundException, SQLException
       {
    	   
    	   connect();
    	   PreparedStatement query = this.conn
    			   .prepareStatement("DELETE FROM \"turma_aluno\" WHERE \"id_turma\"= ? AND \"matricula_aluno\"= ? ");
    	   
    	   query.setInt(1, turma.getId() );
    	   query.setString(2, aluno.getMatricula() );
    	   query.executeUpdate();
       }	
	
}
