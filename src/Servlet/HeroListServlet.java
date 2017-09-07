package Servlet;

import charactor.Hero;
import dao.HeroDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HeroListServlet extends HttpServlet{
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Hero> heroes = new HeroDao().list();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<table align='center' border='1' cellspacing='0'>\r\t");
        stringBuffer.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td><td>edit</td><td>delete</td><tr>\r\n");
        String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='editHero?id=%d'>edit</a></td><td><a href='deleteHero?id=%d'>delete</a></td></tr>\r\n";
        for (Hero hero :
                heroes) {
            String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(),hero.getId(),hero.getId());
            stringBuffer.append(tr);
        }
        stringBuffer.append("</table>");
        response.getWriter().write(stringBuffer.toString());
    }
}
