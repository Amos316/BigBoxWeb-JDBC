package PresentationClass;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessClass.Store;
import BusinessClass.User;
import DatabaseClass.BigBoxDAO;
import DatabaseClass.BigBoxFactory;
import DatabaseClass.UserDB;

/**
 * Servlet implementation class listAllStores
 */
@WebServlet(urlPatterns = {"/listAllStoresServlet"}, initParams= {@WebInitParam(name ="relativePathToFile", value = "/WEB-INF/listAllStores.jsp")})
public class listAllStoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String url = "/listAllStores.jsp";
		BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();
		ArrayList<Store> stores = dao.listAllStores();
		request.setAttribute("stores", stores);
		

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}