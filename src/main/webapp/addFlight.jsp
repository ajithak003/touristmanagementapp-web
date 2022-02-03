
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=, initial-scale=1.0">
<link rel="icon" type="" href="Assets/logo.png">
<title>add package</title>

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
	height: 630px;
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
	margin-top: 20px;
	border-radius: 20px;
	background-color: yellowgreen;
	font-size: 18px;
	font-family: Georgia, 'Times New Roman', Times, serif;
	font-weight: bold;
	border: none
}

td {
	padding-top: 13px;
	padding-bottom: 13px;
}

.container {
	height: 830px;
}
a{
	color: blue;
}
</style>
</head>
<body>


	<form action="addflight" method="post">
		<div class="container">
			<h1>Add Flight</h1>
			<h2>
				<a href="adminPage.jsp">Go To Home</a>
			</h2>
			<br> <br> <br>

			<div class="addpackage">
				<table aria-describedby="add package">
					<th id=""></th>

					<tr>
						<td><label for="location">Flight Name : </label></td>
						<td><input type="text" name="flightname" id="flightname"
							required pattern="[Aa-Zz 0-9 ]{2,}"
							title="must contain  and numbers only" autofocus></td>
					</tr>

					<tr>
						<td><label for="depature">Departure Location : </label></td>
						<td><input type="text" name="Depature" id="Depature" required
							pattern="[aA-zZ ]{2,}" title="must contain characters only"></td>
					</tr>
					<tr>
						<td><label for="destination">destination Location :</label></td>
						<td><input type="text" name="destination" id="destination"
							required pattern="[aA-zZ ]{2,}"
							title="must contain characters only"></td>
					</tr>
					<tr>
						<td><label>Departure Date And Time</label></td>
						<td><input type="datetime-local" name="DepatureDate"
							id="Date" required></td>
					</tr>
					<tr>
						<td><label>Arrival Date And Time</label></td>
						<td><input type="datetime-local" name="ArrivalDate" id="Date"
							required></td>
					</tr>
					<tr>
						<td><label for="">Business Class Fare :</label></td>
						<td><input type="number" name="businessclassfare"
							placeholder="Rs" id="businessclassfare" min="600" max="200000"
							required
							title="must contain number only maximum 600 minimum 200000"></td>
					</tr>
					<tr>
						<td><label for="">Economic Class Fare :</label></td>
						<td><input type="number" name="economicclassfare"
							placeholder="Rs" id="economicclassfare" min="600" max="200000"
							title="must contain number only maximum 600 minimum 200000"
							required></td>
					</tr>

					<tr>
						<td><label for=" ">Status : </label></td>
						<td><input type="text" name="status" id="status" cols="30"
							rows="3" required pattern="[Aa-Zz]{2,}"
							title="must contain characters only"></td>
					</tr>
					</tr>
					<tr>
						<td><label for="">Business Class Seats Count :</label></td>
						<td><input type="text" name="businessclassseat"
							id="businessclassseatr" required pattern="[0-9]{2,3}"
							title="must contain number only maximum 10 minimum 2 no. number"></td>
					</tr>
					<tr>
						<td><label for="">Economic Class Seats Count :</label></td>
						<td><input type="text" name="economicclassseat"
							id="economicclassseat" required pattern="[0-9]{2,3}"
							title="must contain number only maximum 50 minimum 200 no. number"></td>
					</tr>
				</table>
				<button>Add Flight</button>
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
						title : 'Flight can not be Added! please try again later',
						icon : 'error'
					});
				}
			</script>
	</c:if>

	<script>

   today();
   function today(){
     
   var currentTime = new Date() 
   var minDate = new Date(currentTime.getFullYear(), currentTime.getMonth(), + currentTime.getDate()+1); //one day next before month
   var maxDate =  new Date(currentTime.getFullYear(), currentTime.getMonth() +1, +currentTime.getDate()+1); // one day before next month
   console.log(minDate);
   console.log(maxDate);
   let date = JSON.stringify(maxDate)
   date = date.slice(1,11)
   console.log(date)
   let dates = JSON.stringify(minDate)
   dates = dates.slice(1,11)
   console.log(dates)
   document.getElementById("Date").setAttribute("max",date);
   document.getElementById("Date").setAttribute("min",dates);

   }   
 
</script>

</body>

</html>