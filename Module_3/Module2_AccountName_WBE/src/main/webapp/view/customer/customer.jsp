<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/6/2022
  Time: 8:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--thu vien jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

        <title>Title</title>
        <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="datatables/css/datatables.bootstrap4.min.css">

        <script src="jquery/jquery-3.6.0.min.js"></script>
        <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>

        <script src="datatables/js/jquery.dataTables.min.js"></script>
        <script src="datatables/js/dataTables.bootstrap4.min.js"></script>
        <script src="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css"></script>
</head>
<body>
<table id="example" class="table table-striped table-bordered table-hover table-responsive-md " >
    <thead>

    <tr class="bg-dark" >
        <th style="color: white">Name</th>
        <th style="color: white">Birthday</th>
        <th style="color: white">Card</th>
        <th style="color: white;width:15%">Number phone</th>
        <th style="color: white;width:20%">Email</th>
        <th style="color: white">Address</th>
        <th style="width:8%"><a href="/customer?action=create"><ion-icon name="add-circle-outline" style="color: white;margin-left:2px"></ion-icon></a></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer" varStatus="theCount">
        <tr>
            <td>${customer.customer_name}</td>
            <td>${customer.customer_birthday}</td>
            <td>${customer.customer_id_card}</td>
            <td>${customer.customer_phone}</td>
            <td>${customer.customer_email}</td>
            <td>${customer.customer_address}</td>
            <td class="text-center">
                <a href="/customer?action=edit&id=${customer.customer_id}"><ion-icon  name="create" style="color:black"></ion-icon></a>
                <!-- Button trigger modal -->
                <a style="cursor: pointer;" data-toggle="modal" data-target="#exampleModal-${customer.customer_id}">
                    <ion-icon  name="trash" style="color:black"></ion-icon>
                </a>

                <!-- Modal -->
                <div class="modal fade" id="exampleModal-${customer.customer_id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Do you want to delete customer ${customer.customer_name} ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <a  class="btn btn-primary" href="/customer?action=delete&id=${customer.customer_id}">OK</a>
                            </div>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/customer?action=add">Thêm mới</a>
<h1>Danh sách customer</h1>
<table border="1" style="border-collapse:  collapse">
    <tr>
        <th>customer_id</th>
        <th>customer_type_id</th>
        <th>customer_name</th>
        <th>customer_birthday</th>
        <th>customer_gender</th>
        <th>customer_id_card</th>
        <th>customer_phone</th>
        <th>customer_email</th>
        <th>customer_address</th>

    </tr>
    <c:forEach items="${studentList}" var="student" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>

            <c:if test="${student.gender}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!student.gender}">
                <td>Nữ</td>
            </c:if>

            <td>${student.birthday}</td>
            <td>${student.point}</td>
            <c:choose>
                <c:when test="${student.point>=8}">
                    <td>Giỏi</td>
                </c:when>
                <c:when test="${student.point>=7}">
                    <td>Khá</td>
                </c:when>
                <c:when test="${student.point>=5}">
                    <td>Trung bình</td>
                </c:when>
                <c:otherwise>
                    <td>Yếu</td>
                </c:otherwise>
            </c:choose>
            <td>${student.account}</td>
            <td>${student.classId}</td>
                <%--Lấy thông tin tên lớp--%>
                <%--            <c:forEach items="${classCGList}" var="cls">--%>
                <%--                <c:if test="${cls.id==student.classId}">--%>
                <%--                    <td>${cls.name}</td>--%>
                <%--                </c:if>--%>
                <%--            </c:forEach>--%>
            <td><c:out value="${student.email}"></c:out></td>
        </tr>
    </c:forEach>
</table>
<script>$(document).ready(function () {
    $('#example').DataTable();
});</script>
</body>
</html>

