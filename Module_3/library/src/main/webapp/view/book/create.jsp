<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/15/2022
  Time: 7:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Muon Sach</title>
</head>
<body>
<center>
    <h1>Muon Sach</h1>
    <h2>
        <a href="book?action=book">List All Book</a>
    </h2>
    <c:if test="${mess!=null}">
        <p>${mess}</p>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Mượn Sách</h2>
            </caption>
            <tr>
                <th>Mã Mượn Sách:</th>
                <td>
                    <input type="text" name="renting_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Book Name:</th>
                <td>
                    <input type="text" name="book_name" id="book_name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="student_name" id="student_name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngày mượn sách:</th>
                <td>
                    <input type="text" name="rental_day" id="rental_day" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngày trả sách:</th>
                <td>
                    <input type="text" name="return_day" id="return_day" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
