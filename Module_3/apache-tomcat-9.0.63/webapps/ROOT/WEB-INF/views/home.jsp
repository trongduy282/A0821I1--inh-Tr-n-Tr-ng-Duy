<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/21/2022
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Language: </td>
        <td>${Email.languages} </td>
    </tr>
    <tr>
        <td>Page Size </td>
        <td>${Email.pageSize} </td>
    </tr>
    <tr>
        <td>Spam Filter: </td>
        <td>${Email.spamFilter} </td>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${Email.signature} </td>
    </tr>
</table>
</body>
</html>
