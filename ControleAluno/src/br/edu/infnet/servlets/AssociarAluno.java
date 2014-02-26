package br.edu.infnet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.DAO.TurmaDAO;
import br.edu.infnet.DTO.Turma;

/**
 * Servlet implementation class AssociarAluno
 */
@WebServlet("/AssociarAluno")
public class AssociarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssociarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		TurmaDAO turmaDAO =  new TurmaDAO();
		Turma turma = turmaDAO.SelecionarPorId( Integer.parseInt( request.getAttribute("id") ) , true);
		
	}

}
