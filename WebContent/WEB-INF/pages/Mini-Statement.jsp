<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page import="java.util.List"%> 
    <%@page import="java.util.Iterator"%> 
    <%@page import="VirtualBank.Bank.model.Transaction"%> 
     <%@page import="java.util.Map"%>
    <% List<Transaction> Listra = (List) request.getAttribute("list"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>STATEMENT</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
         integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%
if(session.getAttribute("login")==null)
{
	response.sendRedirect("http://localhost:9080/Bank/"); 
}
%>
<div class="list-group">
  <a href="#" class="list-group-item list-group-item-action">STATEMENT</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-primary">ACCOUNT HOLDER:  ${firstname}  ${lastname}</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-secondary">BRANCH:  ${address}</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-success">ACCOUNT NUMBER:  ${accnum}</a>
  <a href="#" class="list-group-item list-group-item-action list-group-item-danger">BALANCE:  ${amount}</a>
</div>
<table class="table table-borderless" align="centre">
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
STATEMENT [List of Transactions ]
 </th>
 </tr>
 </thead>
</table>
<div class="container">
        <table class="table table-hover table-dark">
            <thead>
                <tr class="tr tr-success">
                    <td>Transaction_id</td> 
                    <td>Account Number [s]</td>
                    <td>Account Number [t]</td>
                    <td>Date</td>
                    <td>Present Amount</td>
                    <td>Amount[dep or trans]</td>
                    <td>Type</td>
                    <td>Balance</td>
                </tr>   
            </thead>
            <tbody>
         <%
// Iterating through subjectList

if(request.getAttribute("list") != null)  // Null check for the object
{
	Iterator<Transaction> iterator = Listra.iterator();  // Iterator interface
	
	 for (Object o: Listra)
     {
  	    Map m=(Map)o;
	%>
	<tr><td><%=m.get("tid")%></td>
		<td><%=m.get("account_number_source")%></td>
		<td><%=m.get("account_number_target")%></td>
		<td><%=m.get("date")%></td>
		<td><%=m.get("Floating_amount")%></td>
		<td><%=m.get("amount")%></td>
		<td><%=m.get("type")%></td>
		<td><%=m.get("balance")%></td>
	</tr>
	<%
	}
}
%>
            </tbody>
        </table>
    </div>
<form class="form-inline my-2 my-lg-0">
      <a class="btn btn-outline-danger" onclick="location.href='/Bank/loginProcess'"  role="button">BACK</a>
    </form>
</body>
</html>