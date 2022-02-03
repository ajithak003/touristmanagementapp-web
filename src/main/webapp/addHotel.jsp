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

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	text-decoration: none;
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
}
body{background-color: aquamarine;}

h1 {
	text-align: center;
	color: blue;
}

.addpackage {
	border: 3px solid;
	height: 450px;
	width: 45%;
	position: absolute;
	left: 27%;
	padding: 25px;
}

label {
	font-size: 20px;
	font-weight: bolder;
	font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande',
		'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

input {
	border: 3px solid;
	height: 25px;
	width: 222px;
	font-size: 16px;
	font-weight: bold;
}

input::-webkit-inner-spin-button {
	-webkit-appearance: none;
	margin: 0;
}

textarea {
	border: 3px solid;
}

button {
	height: 30px;
	width: 150px;
	margin-left: 70%;
	margin-top: 10px;
	border-radius: 20px;
	background-color: gold;
	font-size: 18px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	border: none
}

td {
	padding-top: 20px;
	padding-bottom: 20px;
}
a{
	color: blue;
}
</style>

</head>
<body>

	<form action="addhotel" method="post">
		<h1>Add Hotels</h1>
		<h2>
			<a href="adminPage.jsp">Go To Home</a>
		</h2>
		<br> <br> <br>

		<c:if test="${sessionScope.addHotelerror !=null}">
			<script type="text/javascript">
				alert("This Hotel Already Added");
			</script>
		</c:if>


		<div class="container">
			<div class="addpackage">
				<table aria-describedby="Add Package">
					<th id=""></th>
					<tr>
						<td><label for="">Hotel Name : </label></td>
						<td><input type="text" name="hotelname" id="hotelname"
							required pattern="[Aa-Zz]{2,}"
							title="must contain characters only" autofocus></td>
					</tr>

					<tr>
						<td><label for="">Hotel Location : </label></td>
						<td><input type="text" name="hotellocation"
							id="hotellocation" required pattern="[Aa-Zz]{2,}"
							title="must contain characters only"></td>
					</tr>
					<tr>
						<td><label for="">Standard Room One Day Price :</label></td>
						<td><input type="number" name="standardprice"
							placeholder="Rs. " id="standardprice" required min="600"
							max="200000"
							title="must contain numbers maximum 500 no. minimum 100000 only"></td>
					</tr>
					<tr>
						<td><label for="">Premium Room One Day Price :</label></td>
						<td><input type="text" name="premiumprice" id="premiumprice"
							required placeholder="Rs. " min="600" max="200000"
							title="must contain numbers maximum 500 no. minimum 100000 no. only"></td>
					</tr>
					<tr>
						<td><label>Add Images URL </label></td>
						<td><input type="file" name="hotelimage" id="hotelimage"
							required></td>
					</tr>
				</table>
				<button>Add hotel</button>
			</div>
		</div>
	</form>
	
	
	<c:if test="${param.infomsg!=null}">
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
   
                  susAdded();
                   function susAdded(){
                    toastMixin.fire({
                    animation: true,
                    title: 'Successfully Added'
                   });
                  }
             </script>
	</c:if>

	<c:if test="${param.error!=null}">
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
				alreadyAdded();
				function alreadyAdded() {
					toastMixin.fire({
						title : 'This Hotel Already Added',
						icon : 'error'
					});
				}
			</script>
	</c:if>
	
	
</body>
</html>