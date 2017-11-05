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

@WebServlet("/AddstoresServlet")
public class AddstoresServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "/AddStores.jsp";

		
		String divisionID = (request.getParameter("divisionID"));
		String StoreNumber = request.getParameter("StoreNumber");
		double sales = Double.parseDouble(request.getParameter("sales"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		Store s = new Store();
		Division d = new Division();
		d.setDivNum(divisionID);
		s.setDivision(d);
		s.setStoreNum(StoreNumber);
		s.setSales(sales);
		s.setName(name);
		s.setAddress(address);
		s.setCity(city);
		s.setState(state);
		s.setZip(zip);
		dao.addStore(s);
		request.setAttribute("store", s);
		url = "/listAllStoresServlet";

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}
