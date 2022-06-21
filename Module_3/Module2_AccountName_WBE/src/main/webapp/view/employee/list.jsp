<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/11/2022
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
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
                <a class="nav-link" href="/employee">Employee <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/service">Service <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/contract">Contract <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/customer">Customer <span class="sr-only">(current)</span></a>
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
    <h1>Employee Management</h1>
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
<form action="/employee?action=search" method="get">
    <input  hidden name="action"  value="search" placeholder="Nhập tên">
    <input name="nameSearch" placeholder="Nhập tên">
    <input name="cardSearch" placeholder="Nhập ID Card">
    <input name="addressSearch" placeholder="Nhập địa chỉ">
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
        <th style="color: white">Name</th>
        <th style="color: white">Birthday</th>
        <th style="color: white">Card</th>
        <th style="color: white">Salary</th>
        <th style="color: white;width:15%">Phone</th>
        <th style="color: white;width:20%">Email</th>
        <th style="color: white">Address</th>
        <th style="color: white">Position ID</th>
        <th style="color: white">Education Degree ID</th>
        <th style="color: white">Division ID</th>
        <th style="width:8%"><a href="/employee?action=create"><ion-icon  class="icon-create" name="add-circle-outline" style="color: white;margin-left:2px"></ion-icon></a></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="employee" varStatus="theCount">
        <tr>
            <td>${employee.employee_name}</td>
            <td>${employee.employee_birthday}</td>
            <td>${employee.employee_id_card}</td>
            <td>${employee.employee_salary}</td>
            <td>${employee.employee_phone}</td>
            <td>${employee.employee_email}</td>
            <td>${employee.employee_address}</td>
            <td>${employee.position_id}</td>
            <td>${employee.education_degree_id}</td>
            <td>${employee.division_id}</td>
            <td class="text-center">
                <a href="/employee?action=edit&id=${employee.employee_id}"><ion-icon  name="create" style="color:black"></ion-icon></a>
<%--                <!-- Button trigger modal -->--%>
<%--                    <ion-icon  name="trash" style="color:black"></ion-icon>--%>
<%--                </a>--%>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                    Delete
                </button>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Are You Sure?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <a  class="btn btn-primary" href="/employee?action=delete&id=${employee.employee_id}">OK</a>
                            </div>
                        </div>
                    </div>
                </div>
<%--                <a href="/employee?action=delete&id=${employee.employee_id}">Delete</a>--%>
                <!-- Modal -->
<%--                <div class="modal fade" id="exampleModal-${employee.employee_id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">--%>
<%--                    <div class="modal-dialog" role="document">--%>
<%--                        <div class="modal-content">--%>
<%--                            <div class="modal-header">--%>
<%--                                <h5 class="modal-title" id="exampleModalLabel">Delete Employee</h5>--%>
<%--                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                    <span aria-hidden="true">&times;</span>--%>
<%--                                </button>--%>
<%--                            </div>--%>
<%--                            <div class="modal-body">--%>
<%--                                Do you want to delete employee ${employee.employee_name} ?--%>
<%--                            </div>--%>
<%--                            <div class="modal-footer">--%>
<%--                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--                                <a  class="btn btn-primary" href="/employee?action=delete&id=${employee.employee_id}">OK</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
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

