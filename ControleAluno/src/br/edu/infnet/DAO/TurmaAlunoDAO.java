package br.edu.infnet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.infnet.DTO.Aluno;
import br.edu.infnet.DTO.Turma;
import br.edu.infnet.conection.Conexao;

public class TurmaAlunoDAO {

	   Connection conn = null;

       private void connect() throws ClassNotFoundException, SQLException {
               Conexao conexao = new Conexao();
               conn = conexao.getConexao();

       }

       public void Inserir(int turma, String matricula) throws ClassNotFoundException, SQLException {
               connect();
               PreparedStatement query = this.conn
                               .prepareStatement("INSERT INTO \"turma_aluno\"( \"id_turma\", \"matricula_aluno\")  VALUES (?,?)");
               query.setInt(1, turma);
               query.setString(2, matricula);
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
       
       
       public void Deletar(int turma, String matricula) throws ClassNotFoundException, SQLException
       {
    	   
    	   connect();
    	   PreparedStatement query = this.conn
    			   .prepareStatement("DELETE FROM \"turma_aluno\" WHERE \"id_turma\"= ? AND \"matricula_aluno\"= ? ");
    	   
    	   query.setInt(1, turma);
    	   query.setString(2, matricula);
    	   query.executeUpdate();
       }
       
       /*public ArrayList<Turma> Selecionar() throws ClassNotFoundException, SQLException {
               connect();
               PreparedStatement query = this.conn
                               .prepareStatement("SELECT \"id\", \"nome\" FROM \"turma\" ");

               ResultSet resultados = query.executeQuery();
               ArrayList<Turma> ListaTurmas = new ArrayList<Turma>();

               while (resultados.next()) {
                       Turma Turma = new Turma();
                       Turma.setId( Integer.parseInt(resultados.getString("id")));
                       Turma.setNome(resultados.getString("nome"));

                       ListaTurmas.add(Turma);
               }
               return ListaTurmas;
       }

       public Turma SelecionarId(Integer id)
                       throws ClassNotFoundException, SQLException {
               connect();
               PreparedStatement query = this.conn
                               .prepareStatement("SELECT \"id\", \"nome\" FROM \"turma\" WHERE \"id\" = ?");
               query.setString(1, id.toString() );

               ResultSet resultados = query.executeQuery();
               Turma turma = new Turma();

               while (resultados.next()) {
                       turma.setId(Integer.parseInt(resultados.getString("id")));
                       turma.setNome(resultados.getString("nome"));
                       break;
               }
               return turma;
       }
*/
	
	
}
