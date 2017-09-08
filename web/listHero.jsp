<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Warden
  Date: 2017/9/8
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>英雄列表</title>
    <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
    <link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
    <script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('a').addClass("btn btn-default btn-xs");

        });
    </script>
</head>
<body>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>damage</td>
        <td>hp</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${heroes}" var="hero" varStatus="st">
        <tr>
            <td>${hero.id}</td>
            <td>${hero.name}</td>
            <td>${hero.damage}</td>
            <td>${hero.hp}</td>
            <td><a href="editHero?id=${hero.id}">edit</a></td>
            <td><a href="deleteHero?id=${hero.id}" >delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" align="center">
            <a href="?start=0" ${next gt 5?"" :"hidden"}>[首  页]</a>
            <a href="?start=${pre}" ${next gt 5?"" :"hidden"}>[上一页]</a>
            <a href="?start=${next}" ${pre lt last-5?"" :"hidden"}>[下一页]</a>
            <a href="?start=${last}" ${pre lt last-5?"" :"hidden"}>[末页]</a>
        </td>
    </tr>
</table>
</body>
</html>
