<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
<c:url value="hello" var="somevar" />
        <table align="center">
            <tr>
                <td><a href= "${somevar}">Login</a>
                </td>
                <td><a href="register">Register</a>
                </td>
            </tr>
        </table>
</body>
</html>