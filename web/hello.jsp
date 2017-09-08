<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="charactor.Hero" %>
<%@ page import="dao.HeroDao" %><%--
  Created by IntelliJ IDEA.
  User: Warden
  Date: 2017/9/7
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
<%="hello jsp"%>
<%
    List<Hero> heroes = new ArrayList<>();
    heroes = new HeroDao().list();
%>
<table width="200px" align="center" border="1" cellspacing="0">
    <%for (Hero hero :heroes){%>
    <tr>
        <td><%=hero.getName()%></td>
    </tr>
        <%}%>
</table>
<br>
<%=new Date().toLocaleString()%>
<jsp:include page="footer.jsp">
    <jsp:param name="year" value="2017"/>
</jsp:include>
</body>
</html>
