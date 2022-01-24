<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
 <html>

    <head>
      <meta charset="UTF-8">
      <link rel="stylesheet" type="text/css" href="style.css">
      <link rel = "icon" type = "" href = "Assets/logo.png">
      <title>Ratings</title>
    <style>
      *{
        margin: 0;
        padding: 0;
        
    }
    .rate {
        position: absolute;
        margin-left: 600px;
        margin-top: 200px;
        height: 46px;
        padding: 0 10px;

        border: none;
        border-radius: 20px;
    }
    .rate:not(:checked) > input {
        position:absolute;
        top:-9999px;
    }
    .rate:not(:checked) > label {
        float:right;
        width:1em;
        overflow:hidden;
        white-space:nowrap;
        cursor:pointer;
        font-size:30px;
        color:#ccc;
    }
    .rate:not(:checked) > label:before {
        content: '\2605';
       
    }
    .rate > input:checked ~ label {
        color: #15ff00;    
    }
    .rate:not(:checked) > label:hover,
    .rate:not(:checked) > label:hover ~ label {
        color: #00e1ff;  
    }
    .rate > input:checked + label:hover,
    .rate > input:checked + label:hover ~ label,
    .rate > input:checked ~ label:hover,
    .rate > input:checked ~ label:hover ~ label,
    .rate > label:hover ~ input:checked ~ label {
        color: #fffb00;
    }
    textarea{
        position: relative;
        margin-top: 280px;
        margin-left: 480px;
        height: 100px;
        width: 450px;
        border: 3px solid;
    }
    textarea, :placeholder-shown{
        font-size: 25px;   
    }
    button{
        position: absolute;
        left: 900px;
        height: 40px;
        width: 120px;
        border: none;
        border-radius: 150px;
    background-color:rgb(196, 221, 243);    
    font-size: 20px;
        font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
        color:black;
        font-weight: bold;
    
    }
    </style>
    
    </head>
    
    <body>
    
   
    
    <form action="rating" method="get"> 
    
    <% 
    int bookingId = Integer.parseInt(request.getParameter("bookingid"));
    //System.out.println(bookingId);
    
    %>
    
      <div class="rate">
        <input type="radio" id="star5" name="rate" value="5" required/> 
        <label for="star5" title=" 🤩 Excellent">5 stars</label>
        <input type="radio" id="star4" name="rate" value="4"  required/>
        <label for="star4" title="😎 very good">4 stars</label>
        <input type="radio" id="star3" name="rate" value="3" required/>
        <label for="star3" title="😁 Good">3 stars</label>
        <input type="radio" id="star2" name="rate" value="2" required/>
        <label for="star2" title="🙂 Average">2 stars</label>
        <input type="radio" id="star1" name="rate" value="1" required/>
        <label for="star1" title="😶 Bad">1 star</label>
      </div>
      <br>
      <textarea name="describe" id="" cols="30" rows="10" placeholder="Describe your experience"></textarea>
      <br><br><br>
      <button name="bookingId" value="<%=bookingId%>">Rate Now</button>
      </form>
    </body>
           
    
    
    </html>