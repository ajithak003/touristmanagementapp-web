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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

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

	<c:set var="update" scope="session" value="${param.updatehote}" />
	<c:set var="delete" scope="session" value="${param.deletehote}" />
	<c:set var="error" scope="session" value="${param.updateerror}" />
	<c:set var="error" scope="session" value="${param.deleteerror}" />
	<c:choose>
		<c:when test="${update!=null}">

			<script>
				update();
				function update() {
					Swal.fire("Updated", "", "success");
				}
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
					<td><a href="updateHotel?hotelid=${hotel.getHotelId()}">Edit</a></td>
					<td><a href="deleteHotel?hotelid=${hotel.getHotelId()}"
						onclick="hotelDelete()">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		$(document).ready(function() {
			$('#table_id').DataTable();
		});
		
		 function hotelDelete() {
			        console.log("enter");
					var result = confirm("Are you sure about deleting this hotel?");

					if (result == false) {
						event.preventDefault();
					}
				
			}
		

		
	</script>
</body>
</html>