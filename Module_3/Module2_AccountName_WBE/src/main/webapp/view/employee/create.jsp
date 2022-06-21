<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/11/2022
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="employee?action=user">List All Employee</a>
    </h2>
    <c:if test="${mess!=null}">
        <p>${mess}</p>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Employee</h2>
            </caption>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="employee_name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="text" name="employee_birthday" id="birthday" size="45"/>
                </td>
            </tr>

            <tr>
                <th>Employee ID Card:</th>
                <td>
                    <input type="text" name="employee_id_card" id="id_card" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="employee_salary" id="salary" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="employee_phone" id="phone" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="employee_email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="employee_address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Position ID:</th>
                <td>
                    <select name="position_id" id="position_id">
                        <c:forEach items="${positionList}" var="pos" >
                            <option value="${pos.position_id}">${pos.position_name}</option></c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee Education Degree ID:</th>
                <td>
                    <select name="education_degree_id" id="education_degree_id">
                        <c:forEach items="${educationList}" var="edu" >
                            <option value="${edu.education_degree_id}">${edu.education_degree_name}</option></c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Employee Division ID:</th>
                <td>
                    <input type="text" name="division_id" id="division_id" size="45"/>
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
