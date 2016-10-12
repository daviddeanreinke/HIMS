<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HIMS</title>

<style type="text/css">
.error {
	color: #ff0000;
}
</style>
</head>
<body>

	<h2>Check Client Policy Plan</h2>

	<form:form method="POST" modelAttribute="client"
		action="${pageContext.request.contextPath}/claim/verify">
		<table>
			<tr>
			<tr>
				<td>Client First Name:</td>
				<td><form:input path="client_firstname" /></td>
				<td><form:errors path="client_firstname" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Client Last Name:</td>
				<td><form:input path="client_lastname" /></td>
				<td><form:errors path="client_lastname" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>

	<form:form method="POST" modelAttribute="claim"
		action="${pageContext.request.contextPath}/claim/save">
		<table>
			<tr>
				<td>Institution ID:</td>
				<td><form:input path="institution.institution_id" /></td>
				<td><form:errors path="institution.institution_id" cssClass="error" /></td>
			</tr>


			<tr>
				<td>Claim Date:</td>
				<td><form:input path="claim_date" /></td>
				<td><form:errors path="claim_date" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><form:input path="claim_amount" /></td>
				<td><form:errors path="claim_amount" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Details:</td>
				<td><form:textarea path="details" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>