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
<form action="/calculator" method="post">
    <input type="number" name="x1" value="${x1}">
    <input type="number" name="x2" value="${x2}">
    <br>
    <br>
    <button type="submit" name="math" value="+">Addition(+)</button>
    <button type="submit" name="math" value="-">Subtraction(-)</button>
    <button type="submit" name="math" value="*" >Multiplication(*)</button>
    <button type="submit" name="math" value="/">Division(/)</button>
</form>
<p>Result ${math}: ${result}</p>
<p>${mess}</p>
</body>
</html>
