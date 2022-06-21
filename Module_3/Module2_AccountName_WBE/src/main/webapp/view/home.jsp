<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/6/2022
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--thu vien jstl--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/datatables.bootstrap4.min.css">

    <script src="jquery/jquery-3.6.0.min.js"></script>
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>

    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/1.12.1/css/dataTables.bootstrap4.min.css"></script>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</head>
<body>
<%--<a href="/customer">Customer</a>--%>
<%--<a href="/customer?action=add">Thêm mới</a>--%>
<%--<h1>Danh sách Customer</h1>--%>
<%--<table border="1" style="border-collapse:  collapse">--%>
<%--    <tr>--%>
<%--        <th>STT</th>--%>
<%--        <th>Id</th>--%>
<%--        <th>Name</th>--%>
<%--        <th>Gender</th>--%>
<%--        <th>Birthday</th>--%>
<%--        <th>Point</th>--%>
<%--        <th>Rank</th>--%>
<%--        <th>Account</th>--%>
<%--        <th>Class id</th>--%>
<%--        <th>Email</th>--%>

<%--    </tr>--%>
<%--    <c:forEach items="${studentList}" var="student" varStatus="status">--%>
<%--        <tr>--%>
<%--            <td>${status.count}</td>--%>
<%--            <td>${student.id}</td>--%>
<%--            <td>${student.name}</td>--%>

<%--            <c:if test="${student.gender}">--%>
<%--                <td>Nam</td>--%>
<%--            </c:if>--%>
<%--            <c:if test="${!student.gender}">--%>
<%--                <td>Nữ</td>--%>
<%--            </c:if>--%>

<%--            <td>${student.birthday}</td>--%>
<%--            <td>${student.point}</td>--%>
<%--            <c:choose>--%>
<%--                <c:when test="${student.point>=8}">--%>
<%--                    <td>Giỏi</td>--%>
<%--                </c:when>--%>
<%--                <c:when test="${student.point>=7}">--%>
<%--                    <td>Khá</td>--%>
<%--                </c:when>--%>
<%--                <c:when test="${student.point>=5}">--%>
<%--                    <td>Trung bình</td>--%>
<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <td>Yếu</td>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>
<%--            <td>${student.account}</td>--%>
<%--            <td>${student.classId}</td>--%>
<%--                &lt;%&ndash;Lấy thông tin tên lớp&ndash;%&gt;--%>
<%--                &lt;%&ndash;            <c:forEach items="${classCGList}" var="cls">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                <c:if test="${cls.id==student.classId}">&ndash;%&gt;--%>
<%--                &lt;%&ndash;                    <td>${cls.name}</td>&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </c:if>&ndash;%&gt;--%>
<%--                &lt;%&ndash;            </c:forEach>&ndash;%&gt;--%>
<%--            <td><c:out value="${student.email}"></c:out></td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
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
                <a class="nav-link" href="">Contract <span class="sr-only">(current)</span></a>
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
</body>
</html>
