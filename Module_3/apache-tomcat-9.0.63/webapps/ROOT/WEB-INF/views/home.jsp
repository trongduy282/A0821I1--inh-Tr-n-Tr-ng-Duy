<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/21/2022
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>home</h1>
<form action="/converter" method="post">
    <input type="text" name="text" placeholder="Enter word">
    <input type="submit" value="submit">
</form>
<%--<h1> Số nhập là: ${number}</h1>--%>

<h1>Chuyển đổi là: ${number}</h1>
</body>
</html>
