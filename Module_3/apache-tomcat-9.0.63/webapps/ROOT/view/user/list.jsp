<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/4/2022
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/user?action=create">Add New User</a>
    </h2>

</center>
<div align="center">
    <table border="1" cellpadding="5">

        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/user?action=edit&id=${user.id}">Edit</a>
                    <a href="/user?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<form action="/user" method="get">
    <h1>Country search</h1>
    <input type="text" name="countryName" placeholder="input countryName">
    <br>
    <input type="submit" name="action" value="search">
</form>
</body>
</html>