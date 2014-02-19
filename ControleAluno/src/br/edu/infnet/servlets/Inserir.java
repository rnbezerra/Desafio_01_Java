package br.edu.infnet.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.DAO.AlunoDAO;
import br.edu.infnet.DTO.Aluno;

/**
 * Servlet implementation class Inserir
 */
@WebServlet("/Inserir")
public class Inserir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inserir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Aluno aluno = new Aluno();
		aluno.setMatricula(request.getParameter("txtMatricula"));
		aluno.setNome(request.getParameter("txtNome"));
		
		AlunoDAO dao = new AlunoDAO();
		
		try {
			
			dao.Inserir(aluno);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");
		
	}

}
