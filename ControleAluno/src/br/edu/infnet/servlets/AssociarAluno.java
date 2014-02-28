package br.edu.infnet.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.DAO.AlunoDAO;
import br.edu.infnet.DAO.TurmaDAO;
import br.edu.infnet.DTO.Aluno;
import br.edu.infnet.DTO.Turma;
import br.edu.infnet.utils.ParameterHelper;

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
		
		
		
		Turma turma = null;
		TurmaDAO turmaDAO =  new TurmaDAO();
		ArrayList<Aluno> alunoList = null;
		
		try {
			alunoList =  new AlunoDAO().Selecionar();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			ParameterHelper paramHelper = new ParameterHelper();
			turma = turmaDAO.SelecionarPorId( Integer.parseInt( request.getParameter( paramHelper.parameterIgnoreCase(request, "id") ) ) , true);
			
			
			request.setAttribute("Turma", turma);
			request.setAttribute("AlunosLista", alunoList);
			RequestDispatcher view = request.getRequestDispatcher("AssociarAluno.jsp");
			view.forward(request, response);
			
			
		} catch (NumberFormatException | ClassNotFoundException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
	}


//	private String parameterIgnoreCase(HttpServletRequest request, String parameter)
//	{
//	
//		Enumeration<String> e = request.getParameterNames();
//		
//		parameter.toLowerCase();
//		String element;
//		
//		while(e.hasMoreElements()) {
//			
//			element = e.nextElement();
//			
//			if( parameter.equalsIgnoreCase( element ) )
//			{
//				return element;
//			}
//		}
//		
//		return null;
//	}

}