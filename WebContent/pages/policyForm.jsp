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

	<h2>policyForm JSP with Validation</h2>
	
	<form:form method="POST" modelAttribute="policy" action="${pageContext.request.contextPath}/policy/save">
		<table>
			<tr>
				<td>Policy Type: </td>
				<td><form:input path="policy_type"/></td>
				<td><form:errors path="policy_type" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Premium : </td>
				<td><form:input path="premium"/></td>
				<td><form:errors path="premium" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Details: </td>
				<td><form:textarea path="details"/></td>
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