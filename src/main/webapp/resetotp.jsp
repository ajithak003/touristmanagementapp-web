<%@page import="com.ajith.model.UserClass"%>
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
    <title>otp page</title>

    <link rel="stylesheet" href="/css/forget.css">

</head>
<body>
     
     <%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
     
      <% 
         String email = (String) request.getParameter("emailid");
         UserTableDaoImplement userDao = new UserTableDaoImplement();
         UserClass user = userDao.reRegister(email);  
         
         if(user==null){%>
        	 <h1>Please enter correct email id!</h1>
     <%    }
         else{
      %>


    <form  id="otp" onsubmit="return otpfun()" action="resetPassword.html">
        <div class="container">
            <div class="textbox">
                <input type="text" name="" id="" placeholder="Enter the OTP" pattern="[0-9]{4}" required>
            </div>
            <button class="btn" type="submit">submit</button>
    </form>
    
    <script type="text/javascript" >
    
    </script>
    <%} %>
</body>
</html>
    