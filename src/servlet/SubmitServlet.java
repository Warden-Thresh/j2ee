package servlet;

import charactor.Hero;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SubmitServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = request.getParameter("data");
        System.out.println("服务器端接收到的数据是：" + data);
        JSONObject json = JSONObject.fromObject(data);
        System.out.println("转换为JSON对象后是：" + json);
        Hero hero = (Hero) JSONObject.toBean(json, Hero.class);
        System.out.println("转化为Hero对象后是：" + hero);
    }
}
