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
.main {
	padding: 20px;
	margin-left: auto;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 
				0 6px 20px 0 rgba(0, 0, 0, 0.19);
	background-color: #ecf2f9;
	background-image: url(../images/banner.jpg);
}

.footer{
	width: 100%;
	height: 35px;
	border-top: 1px solid black;
	border-left: 1px solid black;
	position: fixed;
	bottom: 0;
	background-image: linear-gradient(to bottom, #edf0f2, #c1cad4);
}
</style>
</head>
<body>

	<div class="banner">
	</div>
	
	<div class="sidebar">
	</div>
	
	<div class="main">
		<h2>create login</h2>
		<form:form method="POST" modelAttribute="login" action="${pageContext.request.contextPath}/save">
			<table>
			<tr>
				<td>UserName : </td>
				<td><form:input path="userid"/></td>
				<td><form:errors path="userid" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><form:input path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Institution ID :  </td>
				<td><form:input path="institution.institution_id"/></td>
				<td><form:errors path="institution.institution_id" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" />
				</td>
			</tr>
			</table>
		</form:form>
	</div>
	
	<div class="footer">
	</div>
	
</body>
</html>