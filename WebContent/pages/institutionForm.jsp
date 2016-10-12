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

	<h2>Enter new Client</h2>
	
	<form:form method="POST" modelAttribute="institution" action="${pageContext.request.contextPath}/institution/save">
		<table>
			<tr>
				<tr>
				<td>Institution Name: </td>
				<td><form:input path="name"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
			<tr>
				<tr>
				<td>Network ID: </td>
				<td><form:input path="network.network_id"/></td>
				<td><form:errors path="network.network_id" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Street Number: </td>
				<td><form:input path="street_number"/></td>
				<td><form:errors path="street_number" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>Street Name; </td>
				<td><form:input path="street_name"/></td>
				<td><form:errors path="street_name" cssClass="error"/></td>
			</tr>
			<tr>
				<td>City: </td>
				<td><form:input path="city"/></td>
				<td><form:errors path="city" cssClass="error"/></td>
			</tr>
			<tr>
				<td>State: </td>
				<td><form:input path="state"/></td>
				<td><form:errors path="state" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Zip Code: </td>
				<td><form:input path="zipcode"/></td>
				<td><form:errors path="zipcode" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>