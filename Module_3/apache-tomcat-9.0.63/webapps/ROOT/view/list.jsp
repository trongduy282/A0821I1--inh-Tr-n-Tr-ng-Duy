<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/28/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--thu vien jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product?action=add">Thêm mới</a>
<h1>Danh sách sản phẩm</h1>
<a href="/product?action=edit">Edit</a>
<table border="1" style="border-collapse:  collapse">
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacturers</th>
    </tr>
    <c:forEach items="${productList}" var="product" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${product.id}</td>
            <td><a href="/product?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.manufacturers}</td>
            <td><a href="/product?action=update&id=${product.getId()}">edit</a></td>
            <td><a href="/product?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
