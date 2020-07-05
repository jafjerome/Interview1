<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <html>
        <head>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
         integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <title>Registration</title>
        </head>
        <style>
        .header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}
        </style>
        <body>
        <div class="header">
    <h1>WELCOME TO REGISTRATION</h1>
          </div>
            <div class="form-group">
            <form:form id="regForm" modelAttribute="user" action="registerProcess" method="post" >
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="username">Username</form:label>
                        </td>
                        <td>
                            <form:input path="username" name="username" id="username"class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="password">Password</form:label>
                        </td>
                        <td>
                            <form:password path="password" class="form-control" name="password" id="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="firstname">FirstName</form:label>
                        </td>
                        <td>
                            <form:input path="firstname" name="firstname" id="firstname" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="lastname">LastName</form:label>
                        </td>
                        <td>
                            <form:input path="lastname" name="lastname" id="lastname" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="email">Email</form:label>
                        </td>
                        <td>
                            <form:input path="email" class="form-control" aria-describedby="emailHelp"  id="email" placeholder="xxxx@xxx.com"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="address">Address</form:label>
                        </td>
                        <td>
                            <form:input path="address" name="address" id="address" class="form-control"   />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="phone">Phone</form:label>
                        </td>
                        <td>
                            <form:input path="phone" name="phone" id="phone" class="form-control" Placeholder="11111-11111"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="amount">Amount</form:label>
                        </td>
                        <td>
                            <form:input path="amount" name="amount" id="amount" class="form-control" Placeholder="Opening Balance"/>
                        </td>
                    </tr>
                    <tr>
                    <td></td>
                        <td>
                            <form:button id="register" class="btn btn-success" name="register">Register</form:button>
                        </td>
                        
                        <td>
                        <a class="btn btn-primary" onclick="location.href='/Bank/'" role="button">Home</a>
                        </td>
                        
                    </tr>
                </table>
            </form:form>
            </div>
        </body>
        </html>