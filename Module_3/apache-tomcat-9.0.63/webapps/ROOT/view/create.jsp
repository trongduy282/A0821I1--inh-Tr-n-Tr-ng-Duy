<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/28/2022
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới sản phẩm</h1>
<form action="/product?action=add" method="post">
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
            <td>
                <button type="submit">Lưu</button>
            </td>
        </tr>
    </table>

</form>
</body>
</html>
