<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/28/2022
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<h1>Edit product</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>
<p>
    <a href="/product">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" placeholder="nhâp id"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" placeholder="nhâp tên"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" placeholder="nhâp giá"></td>
            </tr>
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" placeholder="nhập mô tả"></td>
            </tr>
            <tr>
                <td>Manufacturers</td>
                <td><input type="text" name="manufacturers" placeholder="nhập nhà sản xuất"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>