<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/10/2022
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management Application</title>
</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="service?action=user">List All Service</a>
    </h2>
    <c:if test="${mess!=null}">
        <p>${mess}</p>
    </c:if>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Service</h2>
            </caption>
            <tr>
                <th>Service Name:</th>
                <td>
                    <input type="text" name="service_name" id="service_name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service Area:</th>
                <td>
                    <input type="text" name="service_area" id="service_area" size="45"/>
                </td>
            </tr>

            <tr>
                <th>Service Cost:</th>
                <td>
                    <input type="text" name="service_cost" id="service_cost" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service Max People:</th>
                <td>
                    <input type="text" name="service_max_people" id="service_max_people" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Rent Type ID:</th>
                <td>
                    <input type="text" name="rent_type_id" id="rent_type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service Type ID:</th>
                <td>
                    <input type="text" name="service_type_id" id="service_type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Standard Room:</th>
                <td>
                    <input type="text" name="standard_room" id="standard_room" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Description Other Convenience:</th>
                <td>
                    <input type="text" name="description_other_convenience" id="description_other_convenience" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Pool Area:</th>
                <td>
                    <input type="text" name="pool_area" id="pool_area" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Number of Floor:</th>
                <td>
                    <input type="text" name="number_of_floors" id="number_of_floors" size="45"/>
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