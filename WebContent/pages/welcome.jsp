<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<title>Revature LLC - HIMS</title>
</head>
<body>

	<div class="wraper">

		<div class="top">
			<img class="logo" src="<c:url value="/images/hims2.jpg" />" />
			<div class="buffer"></div>
			<div class="nav">
			<ul>
				<li><div id="link">
						<a id="login" href=""><br>LOG IN</a>
					</div>
				</li>
			</ul>
				
			</div>
		</div>
		<!-- <div class="left"></div> -->
		<!-- <div class="right"></div> -->
		<div class="frame">
			<!-- This gets refreshed via AJAX -->
			<div class="main login">
	<div class="title">
		<h2>LOG IN</h2>
	</div>
	<form:form method="POST" modelAttribute="loginBean" action="${pageContext.request.contextPath}/welcome/login">
			<table>
			<tr>
				<td>UserName : </td>
				<td><form:input path="username"/></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><form:input path="password"/></td>
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Log In"/>
				</td>
			</tr>
			</table>
		</form:form>
</div>
		</div>
		<div class="footer"><div class="copyright"><br>© 2016 Revature LLC&nbsp&nbsp</div></div>
	</div>
</body>
<script src="http://code.jquery.com/jquery-1.4.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login").click(function() {
			$('.frame').load("pages/login.jsp .login");
		});
	});
</script>
</html>