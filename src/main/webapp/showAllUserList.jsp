<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>show All User</title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

<style>
a {
	text-decoration: none;
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
	background-color: silver;
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
		</thead>
		<tbody>
			<c:forEach begin="0" items="${showalluserlist}" var="user"
				varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td>${user.getId()}</td>
					<td>${user.getName()}</td>
					<td>${user.getEmail()}</td>
					<td>${user.getMboNo()}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
	</script>
</body>
</html>