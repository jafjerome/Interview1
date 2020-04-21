<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>HOME</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
         integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");


%>
<form:form  modelAttribute="user" method="post">
<nav  class="navbar navbar-expand-lg navbar-light bg-light" >
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <a class="navbar-brand" href="/Bank/Profile">${firstname}</a>
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="/Bank/Deposit/${cid}">Deposit <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/Bank/Transfer/${cid}">Transfer</a>
      </li>
      <form:form action="summary">
      <li class="nav-item">
        <a class="nav-link" href="/Bank/Summary/${cid}">Summary</a>
      </li>
      </form:form>
      <li class="nav-item">
        <a class="nav-link" href="/Bank/Mini-Statement/${cid}">Statement</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <a class="btn btn-outline-danger" onclick="location.href='/Bank/Logoff'"  role="button">LogOff</a>
    </form>
  </div>
</nav>
</form:form>
<table class="table table-borderless" >
 <thead>
 <tr>
 <th></th>
 <th></th>
 <th></th>
 <th></th>
 <th></th>
<th>
 Welcome ${firstname} ${lastname}
 </th>
 </tr>
 </thead>
 </table>
 <table class="table table-borderless" >
 <thead>
 <tr>
 <th></th>
 <th></th>
 <th></th>
 <th></th>
 <th></th>
 <th></th>
 <th></th>
<th>
 ACCOUNT NUMBER : ${accnum}
 </th>
 </tr>
 </thead>
 </table>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>