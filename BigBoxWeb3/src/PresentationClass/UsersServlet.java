package PresentationClass;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import BusinessClass.User;
import DatabaseClass.UserDB;

@WebServlet("/UsersServlet")
public class UsersServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String url = "/index.jsp";
		String message= "";
		// get current action
		String action = request.getParameter("action");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (action!=null && action.equalsIgnoreCase("login")) {
			url = "/index.jsp";
			User user = UserDB.selectUser(userName); 
		  if (user !=null) {
			  url = "/Welcome.jsp";
			  
		  }else {
			
			
			if (userName == null || password == null || userName.isEmpty() || password.isEmpty() || user==null)  {
				message ="Please try again";
				url = "/index.jsp";

			
				}
					
			}
		   
			request.setAttribute("user", user);
			session.setAttribute("user", user);
			request.setAttribute("message", message);
			Cookie c = new Cookie("userCookie", userName);
			c.setMaxAge(60*60*248365*1);
			c.setPath("/");
			response.addCookie(c);
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}