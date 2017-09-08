<%--
  Created by IntelliJ IDEA.
  User: Warden
  Date: 2017/9/8
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    if (null != cookies) {
        for (int i = 0; i < cookies.length; i++) {
            out.print(cookies[i].getName()+":"+cookies[i].getValue()+"<br>");
        }
    }
%>