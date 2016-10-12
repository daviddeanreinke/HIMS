<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

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
					<div id="link">
						<li><c:choose>
								<c:when test="${sessionScope.sessionInfo != null}">
										Welcome ${sessionScope.sessionInfo.user_id} <br>
									<a href="<c:url value="/welcome/logout" />" >LOGOUT</a>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose></li>
						<div id="link">
							<li><a id="search" href="<c:url value="/main/search" />">PATIENT<br>SEARCH
							</a></li>
						</div>
						<div id="link">
							<li><a id="claim" href="<c:url value="/main/claim" />">SUBMIT&nbspA<br>CLAIM
							</a></li>
						</div>
						<div id="link">
							<li><a id="about" href="<c:url value="/welcome/about" />">ABOUT<br>HIMS
							</a></li>
						</div>
						<div id="link">
							<li><a id="terms" href="<c:url value="/welcome/terms" />">TERMS OF<br>SERVICE
							</a></li>
						</div>
					</div>
				</ul>

			</div>
		</div>
		<!-- <div class="left"></div> -->
		<!-- <div class="right"></div> -->
		<div class="frame">
			<!-- This gets refreshed via AJAX -->

		<c:choose>
			<c:when test="${sessionScope.page == 'about'}">
				<%@ include file="about.jsp"%>
			</c:when>

			<c:when test="${sessionScope.page == 'claim' }">
				<%@ include file="claim.jsp"%>
			</c:when>
			
			<c:when test="${sessionScope.page == 'search'}">
				<%@ include file="search.jsp"%>
			</c:when>
			
			<c:when test="${sessionScope.page == 'terms'}">
				<%@ include file="terms.jsp"%>
			</c:when>
		</c:choose>

		</div>
		<div class="footer"><div class="copyright"><br>© 2016 Revature LLC&nbsp&nbsp</div></div>
	</div>
</body>
<!--  
<script type="text/javascript">
	$(document).ready(function() {
		$("#browse").click(function() {
			$('.frame').load("pages/browse.jsp");
		});
		$("#commit").click(function() {
			$('.frame').load("pages/claim.jsp");
		});
		$("#about").click(function() {
			$('.frame').load("pages/about.jsp");
		});
		$("#terms").click(function() {
			$('.frame').load("pages/terms.jsp");
		});
		
		$('#browse').click(function() {
    		$.ajax({
         		type: "GET",
         		cache: false,
         		url: "main/browse",
         		data: "",
         		success: function(response){
             		$('.frame').html(response);
         }
    });
});
	});
</script>-->
</html>