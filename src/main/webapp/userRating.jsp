<%@page import="com.ajith.model.UserClass"%>
<%@page import="com.ajith.model.UserFeedbackClass"%>
<%@page import="java.util.List"%>
<%@page import="com.ajith.daoImplement.UserTableDaoImplement"%>
<%@page import="com.ajith.daoImplement.RatingDaoImplement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
 <html lang="en">
 <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>user show all rating</title>

    <style>
        body{
            background-color: rgb(238, 234, 228);
        }
         .container{
            border: 2px solid;
            border-radius: 10px;
            width: 700px;
            margin-left: 300px;
            padding: 20px
        }
        .title{
            font-size: 40px;
            text-align: center;
        }
        .name{
            position: relative;
            margin-left: 20px;
            color:mediumblue;
        }
        h3{
            position: relative;
            margin-left: 200px;
            margin-top: -45px;
            font-size: 25px;
        }
        p{
            margin-left: 10px;
            margin-top: 0px;
            font-size: 16px;
        }
       .rate{
            position: relative;
            margin-left: 480px;
            margin-top: -50px;
            font-size: 30px;
            
        } 
       a{
       text-decoration: none;
       }
       
    </style>
</head>
<body>
     
     <%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
      
     <h1 class="title">Ratings</h1>
      <h3><a href="UserPage.jsp">Go To Home</a></h3>
     <br>
     <% RatingDaoImplement ratingDao = new RatingDaoImplement();
     UserTableDaoImplement userDao = new UserTableDaoImplement();
     
     List<UserFeedbackClass> ratings = ratingDao.getAllFeedback();
     
     for(int i =0; i<ratings.size(); i++){
     
    	 UserFeedbackClass rating = ratings.get(i);
    	 
    	 UserClass user = userDao.getSingleUserById(rating.getUserId());
     
     %>
     <a></a>
     <div class="container">
     <h2 class="name"><%=user.getName() %></h2>
     <h3><%=rating.getPackageName() %> Trip</h3>
     
      <%if(rating.getRating()==5.0) {%>
     
     <h1 class="rate">&#11088;&#11088;&#11088;&#11088;&#11088;</h1>
     <%}else if (rating.getRating()==4.0) {%>
     <h1 class="rate">&#11088;&#11088;&#11088;&#11088;</h1>
     <%} 
     else if(rating.getRating()==3.0) {%>
     
     <h1 class="rate">&#11088;&#11088;&#11088;</h1>
     <%}else if (rating.getRating()==2.0) {%>
     <h1 class="rate">&#11088;&#11088;</h1>
     <%} else if (rating.getRating()==1.0){%>
      <h1 class="rate">&#11088;</h1>
      <%} if(rating.getDescribtion()==null){
      %> <p> </p><%}else if(rating.getDescribtion()!=null) {%>
     <p><%=rating.getDescribtion()%></p>
     <%} %>
     
</div>
<br><br>
<%} %>

</body>
</html>