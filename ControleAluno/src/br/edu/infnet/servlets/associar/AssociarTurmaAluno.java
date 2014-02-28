package br.edu.infnet.servlets.associar;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.DAO.TurmaAlunoDAO;
import br.edu.infnet.DAO.TurmaDAO;
import br.edu.infnet.utils.ParameterHelper;

/**
 * Servlet implementation class AssociarTurmaAluno
 */
@WebServlet("/AssociarTurmaAluno")
public class AssociarTurmaAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssociarTurmaAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		TurmaAlunoDAO dao =  new TurmaAlunoDAO();
		int turma = 0;
		String matricula = "";
		
		try {
			ParameterHelper paramHelper = new ParameterHelper();
			turma = Integer.parseInt(request.getParameter(paramHelper.parameterIgnoreCase(request, "turma")));
			matricula = request.getParameter(paramHelper.parameterIgnoreCase(request, "matricula"));
			
			dao.Inserir(turma, matricula);

			request.setAttribute("result", "Aluno associado com sucesso.");
			
		} catch (NumberFormatException | ClassNotFoundException
				| SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			request.setAttribute("result", "Um erro ocorreu ao tentar associar o aluno.");			
		}
		
		RequestDispatcher view = request.getRequestDispatcher("AssociarAluno?id="+turma);
		
		view.forward(request, response);
		
	}

}
