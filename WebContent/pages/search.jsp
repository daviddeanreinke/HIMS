<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="main login">

	<div class="title">
		<h2>Patient Search</h2>
	</div>
	
	<form:form method="POST" modelAttribute="clientInfo" action="${pageContext.request.contextPath}/main/searchPatient">
		<table>
			<tr>
				<td>Policy Number : </td>
				<td><form:input path="policy_number"/></td>
				<td><form:errors path="policy_number" cssClass="error"/></td>
			</tr>
			<tr>
				<td>DL#, ID# or last 4 of SSN : </td>
				<td><form:input path="clientID"/></td>
				<td><form:errors path="clientID" cssClass="error"/></td>
			</tr>
			<tr>   
				<td>First Name : </td>
				<td><form:input path="firstname"/></td>
				<td><form:errors path="firstname" cssClass="error"/></td>
			</tr>
			<tr>
				<td>Last Name : </td>
				<td><form:input path="lastname"/></td>
				<td><form:errors path="lastname" cssClass="error"/></td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Search"/>
				</td>
			</tr>
		</table>
	</form:form>
	</div>
<!-- if statement here c:when -->
<c:choose>
<c:when test="${sessionScope.patientList != null}">
<!-- another div for search results -->
<div class="main login">
<table class="table table-striped patientSearch" style="border-bottom: 1px solid black">
		<thead>
		<tr>
			<th>Policy Number</th>
			<th>Client ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Birthdate</th>
			<th>Network Status</th>
			<th></th>
		</tr>
		</thead>
		<c:forEach items="${sessionScope.patientList}" var="patient">
			<tr>
				<td>${patient.policy_number}</td>
				<td>${patient.clientID}</td>
				<td>${patient.firstname}</td>
				<td>${patient.lastname}</td>
				<td>${patient.birthdate}</td>
				<td><c:choose>
					<c:when test="${sessionScope.sessionInfo.network_id == patient.networkID}">
						<span class="glyphicon glyphicon-ok ok"></span>
					</c:when>
					<c:otherwise>
						<span class="glyphicon glyphicon-remove out"></span>
					</c:otherwise>
					</c:choose>
				</td>
				
				<td>
					<button type="button" class="btn btn-info btn-sm"
						data-toggle="modal" data-target="#myModal${patient.clientID}">Details</button> 
						<!-- Modal -->
					<div class="modal fade" id="myModal${patient.clientID}" role="dialog">
						<div class="modal-dialog">
							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4 class="modal-title">Patient Details</h4>
								</div>
								<div class="modal-body">
									<p>
									<table class="table table-striped">
									<tr><td>Policy Number</td><td>${patient.policy_number}</td><td></td></tr>
									<tr><td>Patient ID</td><td>${patient.clientID}</td><td></td></tr>
									<tr><td>First Name</td><td>${patient.firstname}</td><td></td></tr>
									<tr><td>Last Name</td><td>${patient.lastname}</td><td></td></tr>
									<tr><td>Birthdate</td><td>${patient.birthdate}</td><td></td></tr>
									<tr><td>Policy Type</td><td>${patient.policyType}</td><td></td></tr>
									<tr><td>Network ID</td><td>${patient.networkName}</td>
										<c:choose>
											<c:when test="${sessionScope.sessionInfo.network_id == patient.networkID}">
												<td>In Network</td>
												<td><span class="glyphicon glyphicon-ok ok"></span></td>
											</c:when>
											<c:otherwise>
												<td>Out of Network</td>
												<td><span class="glyphicon glyphicon-remove out"></span></td>
											</c:otherwise>
											</c:choose>
										</td></tr>
									</table>
									</p>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
								</div>
							</div>

						</div>
					</div>

				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</c:when>
<c:otherwise>
</c:otherwise>
</c:choose>

	<div class="footer">
		<div class="copyright"><br>© 2016 Revature LLC&nbsp&nbsp</div>
	</div>
	
</body>


