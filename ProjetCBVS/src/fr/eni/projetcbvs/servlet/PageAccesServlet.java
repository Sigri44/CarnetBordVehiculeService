package fr.eni.projetcbvs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetcbvs.bo.Personne;
import fr.eni.projetcbvs.dal.DALException;
import fr.eni.projetcbvs.dal.DaoFactory;
import fr.eni.projetcbvs.dal.PersonneDAO;

/**
 * Servlet implementation class PageAccesServlet
 */
@WebServlet("/PageAccesServlet")
public class PageAccesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PageAccesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String mail = request.getParameter("email");
		String motdepasse = request.getParameter("motDePasse");
		
		int niveau = 0;
		Personne personne = null;
		PersonneDAO personneDAO = DaoFactory.getPersonneDAO();
		try {
			personne = personneDAO.selectByEmailAndPassword(mail, motdepasse);
			if(personne != null){
				niveau = personne.getNiveau();
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		if (niveau != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("niveau", niveau);
			
			if (niveau == 1) {
				response.sendRedirect( request.getContextPath() + "/accesAdmin");
			} else {
				response.sendRedirect( request.getContextPath() + "/accesUser");
			}
		} else {
			response.sendRedirect( request.getContextPath() + "/connexion");
		}
	}
}
