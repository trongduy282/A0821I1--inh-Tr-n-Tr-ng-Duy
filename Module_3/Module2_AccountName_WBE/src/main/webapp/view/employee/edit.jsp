<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/11/2022
  Time: 9:42 PM
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
        <a href="employee?action=employee">List All Employee</a>
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
                    Edit Employee
                </h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="employee_id" value="<c:out value='${employee.employee_id}' />"/>
            </c:if>
            <tr>
                <th>Employee Name</th>
                <td>
                    <input type="text" name="employee_name" size="45"
                           value="<c:out value='${employee.employee_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="text" name="employee_birthday" size="45"
                           value="<c:out value='${employee.employee_birthday}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee ID Card:</th>
                <td>
                    <input type="text" name="employee_id_card" size="45"
                           value="<c:out value='${employee.employee_id_card}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="employee_salary" size="45"
                           value="<c:out value='${employee.employee_salary}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="employee_phone" size="45"
                           value="<c:out value='${employee.employee_phone}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="employee_email" size="45"
                           value="<c:out value='${employee.employee_email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="employee_address" size="45"
                           value="<c:out value='${employee.employee_address}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Position ID:</th>
                <td>
                    <input type="text" name="position_id" size="45"
                           value="<c:out value='${employee.position_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Education Degree ID:</th>
                <td>
                    <input type="text" name="education_degree_id" size="45"
                           value="<c:out value='${employee.education_degree_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Division ID:</th>
                <td>
                    <input type="text" name="division_id" size="45"
                           value="<c:out value='${employee.division_id}' />"
                    />
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