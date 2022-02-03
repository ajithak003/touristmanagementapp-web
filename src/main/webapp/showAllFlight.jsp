<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.11.4/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<title>showAllFlight</title>
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
 .edit{
 background-color: #2196F3;
 font-weight: bold;
 border: none;
 border-radius: 10px;
 height: 30px;
 width: 50px;
 } 
.update{
 color:white;
 }
 .delete{
 background-color: #f44336;
 color: white;
 font-weight: bold;
 border: none;
 border-radius: 5px;
 border-radius: 10px;
 height: 30px;
 width: 50px;
 } 
   

</style>

</head>
<body>
	

		<c:set var="update" scope="session" value="${param.updateflight}" />
		<c:set var="delete" scope="session" value="${param.deleteflight}" />
		<c:set var="error" scope="session" value="${param.updateerror}" />
		<c:set var="error" scope="session" value="${param.deleteerror}" />
		<c:choose>
			<c:when test="${update!=null}">

				<script>
				Swal.fire({
					  icon: 'success',
					  title: 'Updated',
					  showConfirmButton: false,
					  timer: 1500})
				
			</script>
			</c:when>

			<c:when test="${delete!=null}">

				<script>

				var toastMixin = Swal.mixin({
				    toast: true,
				    icon: 'success',
				    title: 'General Title',
				    animation: false,
				    position: 'top-right',
				    showConfirmButton: false,
				    timer: 3000,
				    timerProgressBar: true,
				    didOpen: (toast) => {
				      toast.addEventListener('mouseenter', Swal.stopTimer)
				      toast.addEventListener('mouseleave', Swal.resumeTimer)
				    }
				  });
   
                  deleted();
                   function deleted(){
                    toastMixin.fire({
                    animation: true,
                    title: 'Successfully deleted'
                   });
                  }
             </script>

			</c:when>
			<c:when test="${deleteerror!=null}">
		 <script>
			var toastMixin = Swal.mixin({
		    toast: true,
		    icon: 'success',
		    title: 'General Title',
		    animation: false,
		    position: 'top-right',
		    showConfirmButton: false,
		    timer: 3000,
		    timerProgressBar: true,
		    didOpen: (toast) => {
		      toast.addEventListener('mouseenter', Swal.stopTimer)
		      toast.addEventListener('mouseleave', Swal.resumeTimer)
		    }
		  });
				deleteError();
				function deleteError() {
					toastMixin.fire({
						title : 'cannot be deleted',
						icon : 'error'
					});
				}
			</script>
			</c:when>
		</c:choose>

		<h2>
			<a href="adminPage.jsp">Go To Home</a>
		</h2>
		<h1>Show All Flight</h1>

		<br> <br>
		<table aria-describedby="Show All Flight" id="table_id"
			class="cell-border" style="width: 100%">
			<thead>
				<th id="">Sl.No</th>
				<th id="">Flight No</th>
				<th id="">Flight Name</th>
				<th id="">Departure</th>
				<th id="">Destination</th>
				<th id="">Departure Date And Time</th>
				<th id="">Arrival Date And Time</th>
				<th id="">Business Class Fare (Rs)</th>
				<th id="">Economic Class Fare (Rs)</th>
				<th id="">Status</th>
				<th id="">Business Class Seats Status</th>
				<th id="">Economic Class Seat Status</th>
				<th id="">Action</th>
				<th id="">Action</th>
			</thead>
			<tbody>
				<c:forEach begin="0" items="${showalladminflight}"
					var="singleFlight" varStatus="loop">

					<fmt:parseDate value="${singleFlight.getDepatureDateTime()}"
						pattern="yyyy-MM-dd'T'HH:mm" var="DepartureDateTime" type="both" />
					<fmt:parseDate value="${singleFlight.getArrivalDateTime()}"
						pattern="yyyy-MM-dd'T'HH:mm" var="ArrivalDateTime" type="both" />

					<tr>
						<td>${loop.count}</td>
						<td>${singleFlight.getFlightNo()}</td>
						<td>${singleFlight.getFlightName()}</td>
						<td>${singleFlight.getDepature()}</td>
						<td>${singleFlight.getDestination()}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm"
								value="${DepartureDateTime}" /></td>
						<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm"
								value="${ArrivalDateTime}" /></td>
						<td>${singleFlight.getBusinessClassFare()}</td>
						<td>${singleFlight.getEconomicClassFare()}</td>
						<td>${singleFlight.getStatus()}</td>
						<td>${singleFlight.getBusinessClassSeat()}</td>
						<td>${singleFlight.getEconomicClassSeat()}</td>
						<td><button class="edit"><a class="update"
							href="updateFlight?flightno=${singleFlight.getFlightNo()}">Edit</a></button></td>
						<td><button class="delete"
							onclick="deleteflight(${singleFlight.getFlightNo()})">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script>
			$(document).ready(function() {
				$('#table_id').DataTable();
			});
			
			 function deleteflight(flightNo) {
				 Swal.fire({
					 title: "Are you sure about \n deleting this flight?",
					    type: "info",
					    showCancelButton: true,
					    confirmButtonText: "Delete It",
					    confirmButtonColor: "#ff0055",
					    cancelButtonColor: "#999999",
					    focusConfirm: false,
					    focusCancel: true
					}).then((result) => {
					  if (result.isConfirmed) {
					    window.location.replace("deleteFlight?info=&flightno=" + flightNo);
					  }
					})
			}
			 
			 
			
		</script>
</body>
</html>