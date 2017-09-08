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
        int start = 0;
        int count = 5;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
            //当浏览器没有传参数start时
        }
        int next = start + count;
        int pre = start - count;

        int total = new HeroDao().getTotal();
        System.out.println(total);
        int last;
        if (0 == total % count) {
            last = total - count;
        }else {
            last=total-total%count;
        }
        pre = pre < 0 ? 0 : pre;
        next = next > last ? last : next;
        response.setContentType("text/html;charset=UTF-8");
        List<Hero> heroes = new HeroDao().list(start,count);
        request.setAttribute("pre",pre);
        request.setAttribute("next", next);
        request.setAttribute("last", last);
        request.setAttribute("heroes",heroes);
        request.getRequestDispatcher("listHero.jsp").forward(request,response);
    }
}
