<%--
  Created by IntelliJ IDEA.
  User: Warden
  Date: 2017/9/7
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
        Cookie c = new Cookie("name", "Gareen");
        c.setMaxAge(100);
        c.setPath("127.0.0.1");
        response.addCookie(c);
%>
<a href="getCookie.jsp">跳转到获取cookie的页面</a>