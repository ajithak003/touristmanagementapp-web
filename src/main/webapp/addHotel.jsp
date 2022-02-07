<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>add hotels</title>

<script
	src="https://cdn.jsdelivr.net/npm/sweetalert2@11.3.10/dist/sweetalert2.all.min.js"></script>
<link rel='stylesheet'
	href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel='stylesheet' href="assets/css/addHotel.css">

</head>
<body>

	<form action="addhotel" method="post">
		<h1>Add Hotels</h1>
		<h2>
			<a href="adminPage.jsp">Go To Home</a>
		</h2>
		<br> <br> <br>


		<div class="container">
			<div class="addpackage">
				<table aria-describedby="Add Package">
					<th id=""></th>
					<tr>
						<td><label for="Hotel Name">Hotel Name : </label></td>
						<td><input type="text" name="hotelname" id="hotelname"
							required aria-label="Hotel Name" autofocus
							pattern="[A-Za-z0-9]{2,}"
							title="must contain and character and numbers only not allowed special character and minimum 2 character or numbers">
						</td>
					</tr>

					<tr>
						<td><label for="Hotel Location">Hotel Location : </label></td>
						<td><input type="text" name="hotellocation"
							aria-label="Hotel Location" id="hotellocation" required
							pattern="[A-Za-z]{2,}"
							title="must contain characters only minimum 2 characters"></td>
					</tr>
					<tr>
						<td><label for="Hotel Standard Room One Day Price">Standard
								Room One Day Price :</label></td>
						<td><input type="number" name="standardprice"
							placeholder="Rs. " id="standardprice"
							aria-label="Hotel Standard Room One Day Price" required min="600"
							max="200000"
							title="must contain numbers Rs. 500 minimum Rs. 100000 only"></td>
					</tr>
					<tr>
						<td><label for="Hotel Premium Room One Day Price">Premium
								Room One Day Price :</label></td>
						<td><input type="number" name="premiumprice"
							id="premiumprice" required
							aria-label="Hotel Premium Room One Day Price" placeholder="Rs. "
							min="600" max="200000"
							title="must contain numbers maximum Rs. 500 minimum Rs. 100000  only"></td>
					</tr>
					<tr>
						<td><label for="hotel image">Add Hotel Images :</label></td>
						<td><input type="file" name="hotelimage" id="hotelimage"
							required aria-label="hotel image"></td>
					</tr>
				</table>
				<button>Add hotel</button>
			</div>
		</div>
	</form>

	<script src="assets/js/popUpMessages.js"></script>

	<c:if test="${param.infomsg!=null}">
		<script type="text/javascript">popupMessages('Successfully Added')</script>
	</c:if>

	<c:if test="${param.error!=null}">
		<script type="text/javascript">popupMessages('This Hotel Already Added')</script>
	</c:if>


</body>
</html>