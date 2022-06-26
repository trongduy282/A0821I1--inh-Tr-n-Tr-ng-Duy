<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/21/2022
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>home</h1>
<form action="/save" method="post">
    <input type="checkbox" name="condiment" value="Lettuce">Lettuce
    <input type="checkbox" name="condiment" value="Tomato">Tomato
    <input type="checkbox" name="condiment" value="Mustard">Mustard
    <input type="checkbox" name="condiment" value="Sprouts">Sprouts
    <input type="submit" value="submit">
</form>
<%--<h1> Số nhập là: ${number}</h1>--%>
<c:forEach items="${condiment}" var="condiment">
    <p>${condiment}</p>
</c:forEach>
</body>
</html>
