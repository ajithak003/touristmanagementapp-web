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
<title>ahowAllHotels</title>
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

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

::-webkit-scrollbar {
	display: none;
}

.edit {
	background-color: #2196F3;
	font-weight: bold;
	border: none;
	border-radius: 10px;
	height: 30px;
	width: 50px;
}

.update {
	color: white;
}

.delete {
	background-color: #f44336;
	color: white;
	font-weight: bold;
	border: none;
	border-radius: 5px;
	border-radius: 10px;
	height: 30px;
	width: 60px;
}
</style>
</head>
<body>

	<c:set var="update" scope="session" value="${param.updatehote}" />
	<c:set var="delete" scope="session" value="${param.deletehote}" />
	<c:set var="updateerror" scope="session" value="${param.updateerror}" />
	<c:set var="deleteerror" scope="session" value="${param.deleteerror}" />
	
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

	<h1>Show All Hotels</h1>

	<br>
	<br>

	<table aria-describedby="Show All Hotels" id="table_id"
		class="cell-border" style="width: 100%">
		<thead>
			<th id="">Sl.No</th>
			<th id="">Hotel Id</th>
			<th id="">Hotel Name</th>
			<th id="">Hotel Location</th>
			<th id="">Standard Room Price (Rs)</th>
			<th id="">Premium Room Price (Rs)</th>
			<th id="">Status</th>
			<th id="">Action</th>
			<th id="">Action</th>
		</thead>
		<tbody>
			<c:forEach begin="0" items="${showalladminhotel}" var="hotel"
				varStatus="loop">

				<tr>
					<td>${loop.count}</td>
					<td>${hotel.getHotelId()}</td>
					<td>${hotel.getHotelName()}</td>
					<td>${hotel.getLocation()}</td>
					<td>${hotel.getMidRangePrice()}</td>
					<td>${hotel.getPremiumPrice()}</td>
					<td>
				        <c:if test="${hotel.getStatus().equals('active') }">
				        <span class="badge badge-pill badge-success">${hotel.getStatus()}</span>
				        </c:if>
				        <c:if test="${hotel.getStatus().equals('inactive') }" 	>
                        <span class="badge badge-pill badge-danger">${hotel.getStatus()}</span>
                        </c:if>
                        </td>
					<td><button class="edit"><a  class="update" 
					href="updateHotel?hotelid=${hotel.getHotelId()}">Edit</a></button></td>
					<td> <button class="delete" onclick="deleteHotel(${hotel.getHotelId()})">Delete</button></td>
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