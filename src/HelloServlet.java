import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	public void init(ServletConfig config){
        System.out.println("init of Hello Servlet");
    }
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		try {
			response.setDateHeader("Expires",0 );
			response.setHeader("Cache-Controll","no-cache");
			response.setHeader("pragma","no-cache");
			response.getWriter().println("<h1>Hello Servelt!</h1>");
			response.getWriter().println(new Date().toLocaleString());
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
