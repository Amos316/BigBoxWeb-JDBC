package PresentationClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessClass.Division;
import BusinessClass.Store;
import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxFactory;

/**
 * Servlet implementation class AddDivisionServlet
 */
@WebServlet("/AddDivisionServlet")
public class AddDivisionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/AddDivisions.jsp";

		int Id = Integer.parseInt(request.getParameter("dID"));
		String divNum = request.getParameter("dNum");
		String name = request.getParameter("dname");
		String address = request.getParameter("daddress");
		String city = request.getParameter("dcity");
		String state = request.getParameter("dtate");
		String zip = request.getParameter("dzip");
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		Division d = new Division();
		d.setId(Id);
		d.setDivNum(divNum);
		d.setName(name);
		d.setAddress(address);
		d.setCity(city);
		d.setState(state);
		d.setZip(zip);
		dao.addDivision(d);
		request.setAttribute("Division", d);
		url = "/AllDivisionsServlet";

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}