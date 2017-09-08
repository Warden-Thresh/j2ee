package Servlet;

import charactor.Hero;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetManyServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Hero> heroes =new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Hero hero = new Hero();
            hero.setName("name"+i);
            hero.setHp(500 + i);
            heroes.add(hero);
        }
        String result = JSONSerializer.toJSON(heroes).toString();
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(result);
    }
}
