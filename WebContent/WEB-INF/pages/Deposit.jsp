<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
         integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script>
function validLogin()
{
	alert ("DEPOSITED SUCESSFULLY.");
}
</script>
</head>
<body>
<blockquote class="blockquote">
  <p class="mb-0">Welcome for Deposit.</p>
</blockquote>
<div class="form-group">
	<form:form class="needs-validation" onsubmit="return validLogin();" novalidate id="Deposit" modelAttribute="transaction" action="${pageContext.request.contextPath}/DepositProcess/${cid}"  method="post">
		<table>
			<tr>	
				<td><form:label path="account_number_source">Account Number :</form:label></td>
				<td><form:input path="account_number_source" name="account_number"
						id="account_number_source" class="form-control" value="${account_number}" /></td>
			</tr>
			<tr>
				<td><form:label path="Floating_amount">Balance:</form:label></td>
				<td><form:input path="Floating_amount" name="Floating_amount"
						id="Floating_amount" class="form-control" value="${amount}" /></td>
			</tr>
			<tr>
				<td><form:label for="validationCustom05" path="amount">Enter Amount:</form:label></td>
				<td><input type="text" name="amount"
						id="validationCustom05" class="form-control" required  />
						<div class="invalid-feedback">
        Please provide a valid Amount.
      </div>
      </td>
			</tr>
			<tr>
				<td></td>
				<td align="left">
				<form:button id="validationCustom05" name="Deposit" class="btn btn-success" type="submit">Deposit</form:button>
				<a class="btn btn-outline-danger" onclick="location.href='/Bank/loginProcess'"  role="button">BACK</a>
				</td>
			</tr>
			<tr></tr>
		</table>
	</form:form>
	</div>
<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>	
</body>
</html>