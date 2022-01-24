<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>terms and condition</title>
<style>
body{
    background-color:ivory;
}
.box{
    text-align: center;
    margin-top: 100px;
    font-size: 20px;
}
.btn{
    height: 40px;
    width: 70px;
    background-color: rgb(99, 99, 243);
    font-size: 20px;
    color: white;
    border-radius: 20px;
    border: none;
}
</style>
</head>
<body>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

    <form action="dateChangeflight.jsp">
    <%  int bookingId = Integer.parseInt(request.getParameter("bookingid"));
  //  System.out.println("trip page  "+bookingId);
        session.setAttribute("datechangeid", bookingId);
    %>
    <div class="box">
   <h4> Notes : if you want to change tour date 1000 will be detected</h4>

    <h4><input type="checkbox" name="yes" id="yes" value="accept" required>accept terms and policy</h4>
    <h3>change Date : <input type="date" name="changedate" id="changedate" required> </h3> 
    <button class="btn" id="btn">Ok</button>
</div>
</form>
<script>

today();
function today(){
  
var currentTime = new Date() 
var minDate = new Date(currentTime.getFullYear(), currentTime.getMonth(), + currentTime.getDate()+2); //one day next before month
var maxDate =  new Date(currentTime.getFullYear(), currentTime.getMonth() +1, +currentTime.getDate()+2	); // one day before next month
console.log(minDate);
console.log(maxDate);
let date = JSON.stringify(maxDate)
date = date.slice(1,11)
console.log(date)
let dates = JSON.stringify(minDate)
dates = dates.slice(1,11)
console.log(dates)
document.getElementById("changedate").setAttribute("max",date);
document.getElementById("changedate").setAttribute("min",dates);

}   

</script>
</body>
 

</html>