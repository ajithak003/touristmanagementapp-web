<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>show All User</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<style>
a {
	text-decoration: none;
	color: blue;
}

h1 {
	text-align: center;
	font-size: 50px;
	color: steelblue
}

h2 {
	margin-left: 20px;
}

table {
	text-align: center;
}

th {
	background: silver;;
	color: black;
	border: 1px solid;
	border-collapse: collapse;
}

td {
	border: 1px solid;
	border-collapse: collapse;
}
</style>
</head>
<body>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>

	<h1>Show All Users</h1>

	<br>
	<br>

	<table aria-describedby="Show All User" id="table_id"
		class="cell-border" style="width: 100%">
		<thead>
			<th id="">Sl.No</th>
			<th id="">User Id</th>
			<th id="">User Name</th>
			<th id="">User Email Id</th>
			<th id="">User Mobile No</th>
			<th id="">User Register Date</th>
			<th id="">User Status</th>
		</thead>
		<tbody>
			<c:forEach begin="0" items="${showalluserlist}" var="user"
				varStatus="loop">

				<fmt:parseDate value="${user.getRegisterDate()}"
					pattern="yyyy-MM-dd'T'HH:mm" var="registerDate" type="both" />

				<tr>
					<td>${loop.count}</td>
					<td>${user.getId()}</td>
					<td>${user.getName()}</td>
					<td>${user.getEmail()}</td>
					<td>${user.getMboNo()}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm"
							value="${registerDate}" /></td>

					<td><c:if test="${user.getStatus().equals('active') }">
							<span class="badge badge-pill badge-success">${user.getStatus()}</span>
						</c:if> <c:if test="${user.getStatus().equals('inactive') }">
							<span class="badge badge-pill badge-danger">${user.getStatus()}</span>
						</c:if></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script src="assets/js/dataTable.js"></script>
	
</body>
</html>