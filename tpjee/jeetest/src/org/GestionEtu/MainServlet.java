package org.GestionEtu;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

	/**
	 * stateless service may be initialized as servlet attribute
	 */
	private EtudiantService etudiantService = new EtudiantServiceImpl();

	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		String searchText = request.getParameter("searchText");

		List<Etudiant> listStudents = null;

		if (searchText != null && !searchText.equals("")) {
			// search by title
			listStudents = etudiantService.getStudentsByName(searchText);
		} else {
			// list all books
			listStudents = etudiantService.getAllStudents();
		}

		// put list in request scope to be retrieved in jsp page
		request.setAttribute("listStudents", listStudents);

		// redirect to jsp page
		String pageName = "/accueil.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(pageName);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
