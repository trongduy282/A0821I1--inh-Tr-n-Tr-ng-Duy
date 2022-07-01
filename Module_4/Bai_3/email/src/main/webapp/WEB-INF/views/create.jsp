<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/30/2022
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create student</title>
</head>
<body>
<h1>Create new Student</h1>
<a href="${pageContext.request.contextPath}/home">Back to saved Setting</a>
<form:form action="${pageContext.request.contextPath}/create" method="post" modelAttribute="email">
    <table border="1">
            <%--        <tr>--%>
            <%--            <td>ID</td>--%>
            <%--            <td><form:input path="id"></form:input></td>--%>
            <%--        </tr>--%>
            <%--        <tr>--%>
            <%--            <td>Name</td>--%>
            <%--            <td><form:input path="name"></form:input></td>--%>
            <%--        </tr>--%>
        <tr>
            <td>Language</td>
            <td>
                <form:select path="languages" items="${language}"/>
                    <%--                    <form:radiobuttons path="className" items="${classNames}"/>--%>
            </td>
        </tr>
        <tr>
            <td>Page Size</td>
            <td>
                <form:select path="pageSize" items="${pageSize}"/>
                    <%--                    <form:radiobuttons path="className" items="${classNames}"/>--%>
            </td>
        </tr>
        <tr>
            <td>Spam Filter</td>
            <td>
                <form:radiobutton path="spamFilter" value="true"></form:radiobutton>Enable
                <form:radiobutton path="spamFilter" value="false"></form:radiobutton>No
            </td>
        </tr>
        <tr>
            <td>Signature</td>
            <td><form:input path="signature"></form:input></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Register"/>
            </td>
        </tr>
            <%--        <tr>--%>
            <%--            <td>Phone Number</td>--%>
            <%--            <td><form:input path="phoneNumber"></form:input></td>--%>
            <%--        </tr>--%>
            <%--        <tr>--%>
            <%--            <td>Sex</td>--%>
            <%--            <td>--%>
            <%--                <form:radiobutton path="sex" value="true"></form:radiobutton>Male--%>
            <%--                <form:radiobutton path="sex" value="false"></form:radiobutton>Female--%>
            <%--            </td>--%>
            <%--        </tr>--%>
            <%--        <tr>--%>
            <%--            <td></td>--%>
            <%--            <td>--%>
            <%--                <input type="submit" value="Register"/>--%>
            <%--            </td>--%>
            <%--        </tr>--%>
    </table>
</form:form>
</body>
</html>
