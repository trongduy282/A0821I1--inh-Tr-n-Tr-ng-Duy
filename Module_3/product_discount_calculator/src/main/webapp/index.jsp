<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/19/2022
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <form action="/DiscountServlet" method="post">

    <input type="text" name="ProductDescription" /> ProductDescription
    <input type = "text"  name="ListPrice"/> ListPrice
    <input type = "text"  name="DiscountPercent"/> DiscountPercent
    <input type="submit">
  </form>
  ${result} ket qua
  </body>
</html>
