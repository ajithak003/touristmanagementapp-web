<%@page import="com.ajith.model.UserClass"%>
<%@page import="java.util.List"%>
<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>show All User</title>

<style>
    table{
        border: 2px solid;
        border-collapse: collapse;
        background-color:mintcream;
        margin-left: 30%;
       
    }
    tr,td,th{
        border: 2px solid;
        text-align: center;
        padding: 10px;
    }
    a{
        text-decoration: none;
    }
    h1{
        text-align: center;
        font-size: 50px;
        color:steelblue
    }

   h2{
       margin-left: 20px;
       
   }
</style>

</head>
<body>
<% List<UserClass> users = (List<UserClass>) session.getAttribute("showalluserlist"); %>


<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
<h2><a href="AdminPage.jsp">Go To Home</a></h2>

    <h1>Show All Users</h1> 
  
    <br><br>
    
    
   
    <table cellpading="30px" cellspacing="30px">

        
        <th>User Id</th>
        <th>User Name</th>
        <th>User Email Id</th>
        <th>User Mobile No</th>
        
    <%  
        for(int i =0; i<users.size(); i++){
         UserClass user = users.get(i); 
    %>



        <tr>
            <td><%=user.getId() %></td>
            <td><%=user.getName() %></td>
            <td><%=user.getEmail() %></td>
            <td><%=user.getMboNo() %></td>
            
        </tr>
        <% }%>
    </table>
   
</body>
</html>