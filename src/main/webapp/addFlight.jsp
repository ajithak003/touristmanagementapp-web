<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>add package</title>
    <style>
      *{
  
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  text-decoration: none;
  font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  background-color:aquamarine;
  
}

h1{
    text-align: center;
}
.addpackage{
    border: 3px solid;
    height: 630px;
    width: 45%;
    position: absolute;
    left: 27%;
    padding: 25px;

}
label{
    font-size: 20px;
    font-weight: bolder;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}
input{
    border: 3px solid;
    height: 25px;
    width: 222px;
    font-size: 16px;
    font-weight: bold;
}
textarea{
    border: 3px solid;
}
button{
    height: 30px;
    width: 150px;
    margin-left: 70%;
    margin-top: 20px;
    border-radius: 20px;
    background-color:yellowgreen;
    font-size: 18px;
    font-family: Georgia, 'Times New Roman', Times, serif;
    font-weight: bold;
    border:none
}
.container{
    height: 830px;
}

    </style>
</head>
<body>
<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

<form action="addflight" method="get">
    <div class="container">
    <h1>Add Flight</h1>
      <h2><a href="AdminPage.jsp">Go To Home</a></h2>
    <br><br><br>
	
    <div class="addpackage">
        <table cellspacing="20px" cellpadding="30px">  
        
            <tr>
     <td><label for="location">Flight Name : </label></td> 
     <td> <input type="text" name="flightname" id="flightname" required pattern="[Aa-Zz 0-9 ]{2,}" title="must contain  and numbers only" autofocus></td> 
    </tr>
     
      <tr>
     <td> <label for="depature">Departure Location : </label></td>
     <td> <input type="text" name="Depature" id="Depature" required pattern="[aA-zZ ]{2,}" title="must contain characters only"></td>
     </tr>
      <tr>
<td><label for="destination">destination Location :</label></td>
     <td> <input type="text" name="destination" id="destination" required pattern="[aA-zZ ]{2,}" title="must contain characters only"></td>
      </tr>
      <tr>
          <td><label>Departure Date And Time</label></td>
          <td><input type="datetime-local" name="DepatureDate" id="Date" required ></td>
      </tr>
      <tr>
        <td><label>Arrival Date And Time</label></td>
        <td><input type="datetime-local" name="ArrivalDate" id="Date" required > </td>
    </tr>
      <tr>
     <td> <label for="">Business Class Fare  :</label></td>
      <td><input type="text" name="businessclassfare" id="businessclassfare" pattern="[0-9]{3,10}" required title="must contain number only maximum 10 minimum 3 no. number"></td>
      </tr>
      <tr>
        <td> <label for="">Economic Class Fare  :</label></td>
         <td><input type="text" name="economicclassfare" id="economicclassfare" pattern="[0-9]{3,10}" title="must contain number only maximum 10 minimum 3 no. number" required></td>
         </tr>

      <tr>
     <td> <label for=" ">Status : </label></td>
      <td><input type="text" name="status" id="status" cols="30" rows="3" required pattern="[Aa-Zz]{2,}" title="must contain characters only"></td>
    </tr>
</tr>
<tr>
<td> <label for="">Business Class Seats Count  :</label></td>
<td><input type="text" name="businessclassseat" id="businessclassseatr" required pattern="[0-9]{2,3}" title="must contain number only maximum 10 minimum 2 no. number"></td>
</tr>
<tr>
  <td> <label for="">Economic Class Seats Count  :</label></td>
   <td><input type="text" name="economicclassseat" id="economicclassseat" required pattern="[0-9]{2,3}" title="must contain number only maximum 10 minimum 2 no. number"></td>
   </tr>
    </table>
    <button >Add Flight</button>
    </div>
    </div>
    </form>
 
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