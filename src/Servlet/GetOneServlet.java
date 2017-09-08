package Servlet;

import charactor.Hero;
import dao.HeroDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetOneServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Hero hero = new HeroDao().get(125);
        JSONObject json = new JSONObject();
        json.put("hero", JSONObject.fromObject(hero));
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(json);
    }

}
