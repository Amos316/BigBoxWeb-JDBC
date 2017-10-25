package PresentationClass;

import java.io.IOException;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxFactory;

/**
 * Servlet implementation class salesServelet
 */
@WebServlet({ "/SalesServlet"})
public class SalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/Sales.jsp";
		String message = " ";
		String sales1 =request.getParameter("id1");
		NumberFormat c = NumberFormat.getCurrencyInstance();
		
		if (sales1 != null && sales1.equals("DIV001") ) {
			message = "";
			BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
			double amt = dao.getSalesSummary("001");
			message = String.valueOf(c.format(amt));
			
		}else if (sales1 != null  && sales1.equals("DIV111")) {
			message = "";
			BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
			double atm = dao.getSalesSummary("111");
			message = String.valueOf(c.format(atm));
			
		}else if (sales1 !=null && sales1.equals("TOTALSALES")) {
			message= "";
			BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
			double m = dao.getSalesSummary();
			message =String.valueOf(c.format(m));
			
		}else {
			message = "choose an option below";
			
		}
		request.setAttribute("message", message);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
