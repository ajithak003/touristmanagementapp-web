<%@page import="java.util.List"%>
<%@page import="com.ajith.model.PackageModeClass"%>
<%@page import="com.ajith.daoImplement.PackageModeClassDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>show All Places</title>

<style>
    table{
        border: 2px solid;
        border-collapse: collapse;
        background-color:paleturquoise;
        
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
</style>

</head>
<body>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

    <h1>Show All Packages</h1>
    <h2><a href="AdminPage.jsp">Go To Home</a></h2>
    <br><br>
    
    
    
    <table cellpading="30px" cellspacing="30px">
        
        <th>Package Id</th>
        <th>Package Name</th>
        <th>One Day Night Price</th>
        <th>Season</th>
        <th>Protocols</th>
        <th>Description</th>
        <th>Action</th>
        <th>Action</th>
<%
    PackageModeClassDaoImplement packageDao = new PackageModeClassDaoImplement();
    List<PackageModeClass> packages = packageDao.getAllPackage();
    for(int i =0; i<packages.size(); i++){
    	
    	PackageModeClass singlePackage = packages.get(i);
    
    %>
        <tr>
            <td><%=singlePackage.getPackageId() %></td>
            <td><%=singlePackage.getName() %></td>
            <td><%=singlePackage.getPriceOneDays() %></td>
            <td><%=singlePackage.getSeason() %></td>
            <td><%=singlePackage.getProtocols() %></td>
            <td><%=singlePackage.getDescription() %></td>
            <td><a href="updatePackage.jsp?packagname=<%=singlePackage.getName() %>">Edit</a></td>
            <td><a href="deletepackage.jsp?packagname=<%=singlePackage.getName() %>">Delete</a></td>
        </tr>
        <%} %>
    </table>
</body>
</html>