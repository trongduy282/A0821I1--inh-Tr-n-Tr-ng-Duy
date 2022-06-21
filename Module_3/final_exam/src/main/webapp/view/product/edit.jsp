<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management Application</title>
</head>
<body>
<center>
    <h1>Product Management</h1>
    <h2>
        <a href="product?action=product">List All Product</a>
    </h2>
    <c:if test="${mess!=null}">
        <p>${mess}</p>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Product
                </h2>
            </caption>
            <c:if test="${product != null}">
                <input type="hidden" name="product_id" value="<c:out value='${product.product_id}' />"/>
            </c:if>
<%--            <tr>--%>
<%--                <th>Customer Type ID:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="customer_type_id" size="45"--%>
<%--                           value="<c:out value='${customer.customer_type_id}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
            <tr>
                <th>Product Name:</th>
                <td>
                    <input type="text" name="product_name" size="45"
                           value="<c:out value='${product.product_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price:</th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quantity:</th>
                <td>
                    <input type="text" name="quantity" size="45"
                           value="<c:out value='${product.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Color:</th>
                <td>
                    <input type="text" name="color" size="45"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description:</th>
                <td>
                    <input type="text" name="des" size="45"
                           value="<c:out value='${product.des}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category:</th>
                <td>
                    <input type="text" name="category_id" size="45"
                           value="<c:out value='${product.category_id}' />"
                    />
                </td>
            </tr>
<%--            <tr>--%>
<%--                <th>Customer Address:</th>--%>
<%--                <td>--%>
<%--                    <input type="text" name="customer_address" size="45"--%>
<%--                           value="<c:out value='${customer.customer_address}' />"--%>
<%--                    />--%>
<%--                </td>--%>
<%--            </tr>--%>
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