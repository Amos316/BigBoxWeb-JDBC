package PresentationClass;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessClass.Store;
import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxFactory;

/**
 * Servlet implementation class UpdateStoresServelet
 */
@WebServlet("/UpdateStoresServlet")
public class UpdateStoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/UpdateStores.jsp";
		String strNbr = request.getParameter("StoreNumber");
		Store s = new Store();
		s.setStoreNum(strNbr);
		request.setAttribute("store", s);
		String diviD = request.getParameter("divisionID");
		double sales = Double.parseDouble(request.getParameter("sales"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		s = new Store(diviD, strNbr, sales,name,address,city,state, zip);
		dao.updateStore(s);
		url = "/listAllStoresServlet";
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
