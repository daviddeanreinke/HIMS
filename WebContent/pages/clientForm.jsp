<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$(".datepicker").datepicker({ dateFormat: "yy-mm-dd" }).val();
	});
</script>
<title>HIMS</title>

<style type="text/css">
.error {
	color: #ff0000;
}
</style>
</head>
<body>

	<h2>Enter new Client</h2>
	
	<form:form method="POST" modelAttribute="client" action="${pageContext.request.contextPath}/client/save">
		<table>
			<tr>
				<tr>
				<td>Client First Name: </td>
				<td><form:input path="firstname"/></td>
				<td><form:errors path="firstname" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Client Last Name: </td>
				<td><form:input path="lastname"/></td>
				<td><form:errors path="lastname" cssClass="error"/></td>
			</tr>
			<tr>
				<tr>
				<td>Identification Number ( DL# or last 4 of ssn ): </td>
				<td><form:input path="client_id"/></td>
				<td><form:errors path="client_id" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Policy Type: </td>
				<td><form:select path="policyPlan.policy_type">
						<form:option value="HMO" label="(HMO) Health Maintenance Organization"/>
						<form:option value="PPO" label="(PPO) Preferred Provider Organization"/>
						<form:option value="EPO" label="(EPO) Exclusive Provider Organization"/>
						<form:option value="POS" label="(POS) Point of Service Plan"/>
					</form:select>
				<td><form:errors path="policyPlan.policy_type" cssClass="error"/></td>
			<tr>
			<tr>
				<tr>
				<td>Network ID: </td>
				<td><form:input path="network.network_id"/></td>
				<td><form:errors path="network.network_id" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Expiration Date: </td>
				<td><form:input cssClass="datepicker" path="expiration_date" readOnly="true"/></td>
				<td><form:errors path="expiration_date" cssClass="error"/></td>
			</tr>
				<td colspan="3">
					<input type="submit" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>