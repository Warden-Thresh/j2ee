package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if ("admin".equals(name)&&"123".equals(password)) {
			request.getSession().setAttribute("userName",name);
			response.sendRedirect("listHero");
		}else{
			response.sendRedirect("login.html");
		}

	}
	
}
