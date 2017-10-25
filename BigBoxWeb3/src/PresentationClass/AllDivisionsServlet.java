package PresentationClass;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessClass.Division;
import BusinessClass.Store;
import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxFactory;

/**
 * Servlet implementation class AllDivisionsServlet
 */
@WebServlet("/AllDivisionsServlet")
public class AllDivisionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String url = "/AllDivisions.jsp";
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		ArrayList<Division> divisions = dao.listAllDivisions();
		request.setAttribute("divisions", divisions);
		

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}