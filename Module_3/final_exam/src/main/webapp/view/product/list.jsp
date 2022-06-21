<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2022
  Time: 6:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/datatables.bootstrap4.min.css">

    <script src="jquery/jquery-3.6.0.min.js"></script>
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>

    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
    <style>
        .icon-create {
            display: inline-block !important;
            position: relative;
            left: 23px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="/product">Product <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/"> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/"> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/"> <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<center>
    <h1>Product Management</h1>
    <%--    <h2>--%>
    <%--        <a href="/customer?action=create">Add New User</a>--%>
    <%--    </h2>--%>

</center>
<%--<div align="center">--%>
<%--    <table border="1" cellpadding="5">--%>

<%--        <caption><h2>List of Customer</h2></caption>--%>
<%--        <tr>--%>
<%--            <th>customer_id</th>--%>
<%--            <th>customer_type_id</th>--%>
<%--            <th>customer_name</th>--%>
<%--            <th>customer_birthday</th>--%>
<%--            <th>customer_gender</th>--%>
<%--            <th>customer_id_card</th>--%>
<%--            <th>customer_phone</th>--%>
<%--            <th>customer_email</th>--%>
<%--            <th>customer_address</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="customer" items="${customerList}">--%>
<%--            <tr>--%>
<%--                <td><c:out value="${customer.customer_id}"/></td>--%>
<%--                <td><c:out value="${customer.customer_type_id}"/></td>--%>
<%--                <td><c:out value="${customer.customer_name}"/></td>--%>
<%--                <td><c:out value="${customer.customer_birthday}"/></td>--%>
<%--                <td><c:out value="${customer.customer_gender}"/></td>--%>
<%--                <td><c:out value="${customer.customer_id_card}"/></td>--%>
<%--                <td><c:out value="${customer.customer_phone}"/></td>--%>
<%--                <td><c:out value="${customer.customer_email}"/></td>--%>
<%--                <td><c:out value="${customer.customer_address}"/></td>--%>
<%--                <td>--%>
<%--                    <a href="/customer?action=edit&id=${customer.customer_id}">Edit</a>--%>
<%--                    <a href="/customer?action=delete&id=${customer.customer_id}">Delete</a>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</div>--%>
<form action="/product?action=search" method="get">
    <input  hidden name="action"  value="search" placeholder="Nhập tên">
    <input name="nameSearch" placeholder="Nhập tên">
    <%--    <select name="classId">--%>
    <%--        <option value=""> Chọn</option>--%>
    <%--        <c:forEach items="${classList}" var="cls">--%>
    <%--            <option value="${cls.id}">${cls.name}</option>--%>
    <%--        </c:forEach>--%>
    <%--    </select>--%>
    <button type="submit"> Tìm kiếm</button>
</form>
<table id="example" class="table table-striped table-bordered table-hover table-responsive-md " >
    <thead>

    <tr class="bg-dark" >
        <th style="color: white">Product Name</th>
        <th style="color: white">Price</th>
        <th style="color: white">Quantity</th>
        <th style="color: white;width:15%">Color</th>
        <th style="color: white;width:20%">Category</th>
        <th style="color: white">Action</th>
        <th style="width:8%"><a href="/product?action=create"><ion-icon  class="icon-create" name="add-circle-outline" style="color: white;margin-left:2px"></ion-icon></a></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${productList}" var="product" varStatus="theCount">
        <tr>
            <td>${product.product_name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.category_id}</td>
<%--            <td>${product.des}</td>--%>
<%--            <td>${customer.customer_address}</td>--%>
            <td class="text-center">
                <a href="/product?action=edit&id=${product.product_id}"><ion-icon  name="create" style="color:black"></ion-icon></a>
                <!-- Button trigger modal -->
                <a style="cursor: pointer;" data-toggle="modal" data-target="#exampleModal-${product.product_id}">
                    <ion-icon  name="trash" style="color:black"></ion-icon>
                </a>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal-${product.product_id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Delete Product</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Do you want to delete product ${product.product_name} ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <a  class="btn btn-primary" href="/product?action=delete&id=${product.product_id}">OK</a>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>$(document).ready(function () {
    $('#example').DataTable();
});</script>
</body>
</html>
