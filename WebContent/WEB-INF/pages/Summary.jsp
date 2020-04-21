<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>ACCOUNT-SUMMARY</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
         integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
.center-div
{
  position: absolute;
  margin: auto;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  width: 100px;
  height: 100px;
  background-color: #ccc;
  border-radius: 3px;
}
</style>
<body>
<%

if(session.getAttribute("login")==null)
{
	response.sendRedirect("http://localhost:9080/Bank/"); 
}
%>
<div class="list-group">
  <a href="#" class="list-group-item list-group-item-action">ACCOUNT-SUMMARY</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-primary">ACCOUNT HOLDER:  ${firstname}  ${lastname}</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">BRANCH:  ${address}</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-success">ACCOUNT NUMBER:  ${account_number}</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-danger">AMOUNT:  ${amount}</a>
</div>
<div class="centre-div">
<form class="form-inline my-2 my-lg-0">
      <a class="btn btn-outline-danger" onclick="location.href='/Bank/loginProcess'"  role="button">BACK</a>
    </form>
    </div>
</body>
</html>