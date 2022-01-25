<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>AdminPage</title>

    <style>
    *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
    font-family: Arial, sans-serif;
    
}
body{
        
    background-image: url("Assets/home.png.jpg") ;
      background-repeat: no-repeat;
}
h1{
   
    color:rgb(241, 11, 57);
    text-align: center;
    font-weight: bold;
    font-size: 50px;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
   
}
#link{
    width: 100%;
    background: black;
    height: 75px;

}

ul{
   
    list-style: none;
    padding: 0;
    margin: 0;
    float: left;
    position: relative;
    left: 70px;
}

ul li{
    float: left;
    margin-top: 10px;
    
     }

ul li a{
    width: 180px;
    color: white;
    display: block;
    text-decoration: none;
    font-size: 20px;text-align: center;
    padding: 10px;
    border-radius: 10px;
    font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    font-weight: bold;
    text-align: center;
}
a:hover{
    background: cornsilk;
    color:mediumblue;
}

ul li ul{
    background: #000033;
}


ul li ul li{
    float: none;
    position: relative;
    left: 0px;
}
ul li ul{
   display: none;
   position: relative;
   left: 0px;
}

ul li:hover ul {
    display: block;
    
}

span{
    position: absolute;
    right: 120px;
    color: bisque;
   font-size: 20px;
   top: 30px;
   font-weight: bold;
   font-family: Verdana, Geneva, Tahoma, sans-serif;
}
 

    </style>
  
    
</head>

<body>


  <h1 >Tourist Management</h1><span>Welcome 
        
            <c:out value="${sessionScope.welcom }"/>  
        
  </span>
  <br>
  
  
<div id="link" >
<ul>
<li><a href="#">Home</a>
</li>
<li><a href="showAllPlaces.jsp" >Popular Places</a></li>
<li ><a>Package</a>
<ul class="list"> 
  <li><a href="addPackage.jsp">Add Package</a></li>
  <li><a href="showAllAdminPackages.jsp">show all package</a></li>
</ul></li>


<li ><a>flights</a>
  <ul class="list">
    <li><a href="addFlight.jsp">Add flight</a></li>
    <li><a href="showAllFlight.jsp">show all flight</a></li>
  </ul></li>
  <li></li>
  <li><a>Hotels</a>
    <ul class="list">
    <li><a href="addHotel.jsp">Add hotel</a></li>
    <li><a href="showAllHotel.jsp">show all hotel</a></li>
  </ul>
  </li>
  <li ><a>More</a>
    <ul class="list">
      <li><a href="showAllUserList">View User List</a></li>
      <li><a href="showAllUserBooking.jsp">view all booking</a></li>
      <li><a href="adminratings">view all feedback</a></li>
    </ul></li>
<li><a href="logout.jsp" >Logout</a></li>

</ul>



</div>

    
</body>
</html>