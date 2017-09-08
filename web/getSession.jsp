<%--
  Created by IntelliJ IDEA.
  User: Warden
  Date: 2017/9/8
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String name = (String) session.getAttribute("name");
%>
session中的name：<%=name%>
</body>
</html>
