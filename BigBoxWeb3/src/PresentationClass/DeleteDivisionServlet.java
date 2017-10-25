package PresentationClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessClass.Division;
import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxFactory;

/**
 * Servlet implementation class DeleteDivisionServlet
 */
@WebServlet("/DeleteDivisionServlet")
public class DeleteDivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/DeleteDivisions.jsp";
		String num = request.getParameter("Number");
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		Division d = new Division();
		d.setDivNum(num);
		dao.deleteDivision(d);
		url = "/DeleteDivisions.jsp";
		
		
		getServletContext()
		.getRequestDispatcher(url)
		.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
