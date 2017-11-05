package PresentationClass;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessClass.Division;
import BusinessClass.Store;
import BusinessClass.User;
import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxDB;
import DatabaseClass.BigBoxFactory;
import DatabaseClass.UserDB;

@WebServlet(urlPatterns = { "/WelcomeServlet" })
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/Welcome.jsp";

		// get current action
		String action = request.getParameter("action");
		String list = request.getParameter("list");
		String listdivs = request.getParameter("List All Divisions");
		String sales = request.getParameter("Sales Summary");
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		NumberFormat c = NumberFormat.getCurrencyInstance();

		HttpSession session = request.getSession();
		url = "/AddStores.jsp";

		if (action != null && action.equalsIgnoreCase("submit")) {

			{

				url = "/Allstores.jsp";
			}
		} else if (action != null && action.equalsIgnoreCase("send")) {

			url = "/AllDivisions";

		} else if (action != null && action.equals(sales)) {
			url = "/Sales.jsp";
			String formattedSales = c.format(dao.getSalesSummary());
			request.setAttribute("sales", formattedSales);
		} else {
			url = "/AllDivisions.jsp";
			int dID = Integer.parseInt(request.getParameter("dID"));
			String dNum = request.getParameter("dNum");
			String dname = request.getParameter("dname");
			String daddress = request.getParameter("daddress");
			String dcity = request.getParameter("dcity");
			String dstate = request.getParameter("dstate");
			String dzip = request.getParameter("dzip");
			Division division = new Division();

			division.setId(dID);
			division.setDivNum(dNum);
			division.setName(dname);
			division.setAddress(daddress);
			division.setCity(dcity);
			division.setState(dstate);
			division.setZip(dzip);
			dao.addDivision(division);
			request.setAttribute("Division", division);

		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}