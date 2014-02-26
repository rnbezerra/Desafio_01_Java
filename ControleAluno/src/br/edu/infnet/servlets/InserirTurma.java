package br.edu.infnet.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.DAO.AlunoDAO;
import br.edu.infnet.DAO.TurmaDAO;
import br.edu.infnet.DTO.Aluno;
import br.edu.infnet.DTO.Turma;

/**
 * Servlet implementation class InserirTurma
 */
@WebServlet("/InserirTurma")
public class InserirTurma extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserirTurma() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Turma turma = new Turma();
		turma.setNome(request.getParameter("txtNome"));
		
		TurmaDAO dao = new TurmaDAO();
		
		try {
			dao.Inserir(turma);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("VisualizarTurmas.jsp");
		
	}

}
