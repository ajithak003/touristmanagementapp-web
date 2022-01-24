<%@page import="com.ajith.model.PackageModeClass"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet" %>
<%@page import="com.ajith.daoImplement.PackageModeClassDaoImplement" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel = "icon" type = "" href = "Assets/logo.png">
            <title>Popular Places</title>
            <style>
            *{
  
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-decoration: none;
    font-family: Arial, sans-serif;
    
}
body{
        
   background-color:rgb(248, 237, 221);
}

 h1{
    position: absolute;
    top: 300px;
    left: 30%;
    background-color:black;
    border-radius: 25%;
    color: white;
} 
.firsrrow{
    padding-left: 20%;
}	

.firstrowimg{
    
   
     top: 400px;
      width: 298px; 
      height: 350px; 
      border-radius: 10px;

}
.table{
    left: 0px;
}
h2{
    text-align: center;
    font-weight: bold;
    font-size: 35px;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
}
second{
 border: 3px solid;

}

 </style>
 </head>

<body>

    <%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

<div class="second">
<h3><a href="UserPage.jsp">Go To Home</a></h3>
    <table cellspacing="30px" cellpadding ="1000px" class="table">

       <%
     PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
       List<PackageModeClass> packages = packageDao.getAllPackage();
		
					for(int i=0; i<packages.size();i++){
						
						PackageModeClass rs = packages.get(i);
			%>

        <%if(i%4==0) {%>
        <tr>
        <%} %>
        
            <td>
                <div class="firstrow">
                    <a href="singlePackage.jsp?location=<%=rs.getName() %>">
                        <img class="firstrowimg" src="Assets/<%=rs.getImage() %>" alt="">
                    </a>
                    <h2 name="location"><%=rs.getName()%></h2>
                </div>
            </td>

<%} %>
       
    </table>

 </div>
  </body>

</html>