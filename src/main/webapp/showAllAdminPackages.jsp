<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>show All Places</title>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

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

<link rel='stylesheet' href="assets/css/showAllAdminPackages.css">

</head>
<body>


	<c:set var="update" scope="session" value="${param.updatepackage}" />
	<c:set var="delete" scope="session" value="${param.deletepackage}" />
	<c:set var="error" scope="session" value="${param.updateerror}" />
	<c:set var="error" scope="session" value="${param.deleteerror}" />

	<script src="assets/js/popUpMessages.js"></script>

	<c:choose>
		<c:when test="${update!=null}">
			<script type="text/javascript">
			popupMessages('successfully updated')
		</script>
		</c:when>

		<c:when test="${updateerror!=null}">
			<script type="text/javascript">
			popupMessages('cannot be updated')
		</script>
		</c:when>

		<c:when test="${delete!=null}">
			<script type="text/javascript">
			popupMessages('Successfully deleted')
		</script>
		</c:when>
		<c:when test="${deleteerror!=null}">
			<script type="text/javascript">
			popupMessages('cannot be deleted')
		</script>
		</c:when>
	</c:choose>

	<h2>
		<a href="adminPage.jsp">Go To Home</a>
	</h2>
	<h1>Show All Packages</h1>

	<br>
	<br>



	<table aria-describedby="Show All packages" id="table_id"
		class="cell-border" style="width: 100%">
		<thead>
			<th id="">Sl.No</th>
			<th id="">Package Id</th>
			<th id="">Package Name</th>
			<th id="">One Day Night Price (Rs)</th>
			<th id="">Season</th>
			<th id="">Protocols</th>
			<th id="">Description</th>
			<th id="">Status</th>
			<th id="">Action</th>
			<th id="">Action</th>
		</thead>
		<tbody>
			<c:forEach begin="0" items="${showalladminpackage}"
				var="singlePackage" varStatus="loop">

				<tr>
					<td>${loop.count}</td>
					<td>${singlePackage.getPackageId()}</td>
					<td>${singlePackage.getName()}</td>
					<td>${singlePackage.getPriceOneDays()}</td>
					<td>${singlePackage.getSeason()}</td>
					<td>${singlePackage.getProtocols()}</td>
					<td>${singlePackage.getDescription()}</td>
					<td><c:if
							test="${singlePackage.getStatus().equals('active') }">
							<span class="badge badge-pill badge-success">${singlePackage.getStatus()}</span>
						</c:if> <c:if
							test="${singlePackage.getStatus().trim().equals('inactive') }">
							<span class="badge badge-pill badge-danger">${singlePackage.getStatus()}</span>
						</c:if></td>
					<td><button class="edit">
							<a class="update"
								href="updatePackage?packagname=${singlePackage.getName()}">Edit</a>
						</button></td>
					<td><button class="delete"
							onclick="packagedelete('${singlePackage.getName()}')">Delete</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<script src="assets/js/dataTable.js"></script>

</body>
</html>