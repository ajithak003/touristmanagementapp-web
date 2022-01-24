<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel = "icon" type = "" href = "Assets/logo.png">
<title>register Form</title>
<Style>
body{
    margin: 0;
    padding: 0;
    font-family: sans-serif;
    background: url("blure.jpg");
    background-size: cover;
}


.loginbox{
    border: 2px solid;
    background-color:cornsilk;
    border-radius: 20px;
    padding:30px;
    width: 290px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    color:black;
    padding-left: 40px;
    padding-right: 40px;
       
}
.loginbox h1{
     
    float: left;
    font-size: 35px ;
    border-bottom: 6px solid #1ef725;
    margin-bottom: 30px;
    padding: 10px 0;
   
   
}
.textbox{
    width: 100%;
    overflow: hidden;
    font-size: 16px;
    padding: 8px 0;
    margin:8px 0 ;
    border-bottom: 1px solid #1ef725;
}
.textbox input{
    border: none;
    outline: none;
    background: none;
    color: whiye;
    font-size: 18px;
    width: 80%;
    float: left;
    margin: 6px;
}
.btn{
    width: 100%;
    background: none;
    
    border: 2px solid #1ef725;
    color:blue;
    padding: 5px;
    font-size: 18px;
    }
    
</Style>
</head>
<body>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>

<form action="register" id="register" method="post" >
      <div class="loginbox">
          <h1>Register</h1>
          <div class="textbox">
            <input type="text" placeholder="FullName" name="FullName" value="" required autofocus pattern="[aa-Zz]{2,}" title="must contain numbers only">
          </div>
          <div class="textbox">
             <input type="email" placeholder="Email" name="regemail" value="" required  pattern="[A-Za-z0-9]+[@][a-zA-Z]+[.][A-Za-z]{2,3}">
          </div>
          <div class="textbox">
              <input type="text" placeholder="Mobile No" name="regmobile" value="" required pattern="[6-9][0-9]{9}" title="Must contain 10 numbers only"> 
          </div >
          
          <div class="textbox">
              <input type="password" placeholder="Password" name="regpsw" value="" id="psw" onkeyup="checkpattern()" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$">
          </div>
        
        <div>
            <ul>
              <li id="upper">Atleast one uppercase[A-Z]</li>
              <li id="lower">Atleast one lowercase  [a-z]</li>
              <li id="number">Atleast one number [0-9]</li>
              <li id="special">Atleast one special character [@$!%*?&]</li>
              <li id="char">Alleast 8 character</li>
            </ul>
           </div>
           
            <button class="btn" type="submit">Sign up</button>
            <br>
             <% String notallow=(String)session.getAttribute("notallow");
            if(notallow!=null) {%>
            <h4><%=session.getAttribute("notallow") %></h4>
           
            <%} session.removeAttribute("notallow"); %>
            <% String error=(String)session.getAttribute("error");
            if(error!=null) {%>
            <h4><%=session.getAttribute("error") %></h4>
           
            <%} session.removeAttribute("error"); %>
            

          <div>
          </div>
      </div>
  </form>
  <script type="text/javascript">
function checkpattern(){
console.log("function calling")
var password = document.getElementById("psw").value;
console.log(password)
if(password.match(/(?=[A-Z])/)){
  console.log("upper")
    document.getElementById("upper").style.color = "rgb(31, 224, 31)";
}
else{
  document.getElementById("upper").style.color = "black";
}

if(password.match(/(?=[a-z])/)){
  console.log("lower")
    document.getElementById("lower").style.color = "rgb(31, 224, 31)";
}
else{
  document.getElementById("lower").style.color = "black";
}

if(password.match(/(?=[0-9])/)){
  console.log("number")
  document.getElementById("number").style.color = "rgb(31, 224, 31)";
}
else{
  document.getElementById("number").style.color = "black";
}

if(password.match(/(?=.*[!@#\$%\^&\*])/)){
  console.log("special")
  document.getElementById("special").style.color = "rgb(31, 224, 31)";
}
else{
  document.getElementById("special").style.color = "black";
}

if(password.length > 7){
  console.log("character")
  document.getElementById("char").style.color = "rgb(31, 224, 31)";
}
else{
  document.getElementById("char").style.color = "black";
}

}
</script>
</body>
 
</html>
