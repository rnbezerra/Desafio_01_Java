import java.sql.SQLException;

import br.edu.infnet.DAO.AlunoDAO;
import br.edu.infnet.DTO.Aluno;
import br.edu.infnet.conection.Conexao;


public class TestRun {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlunoDAO dao = new AlunoDAO();
		try {
			System.out.println(dao.Selecionar().size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Aluno aluno = new Aluno();
//		aluno.setMatricula("i20140001");
//		aluno.setNome("Iago");
//		try {
//			dao.Inserir(aluno);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
