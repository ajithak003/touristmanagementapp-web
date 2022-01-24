<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" type = "" href = "Assets/logo.png">
    <title>resertPassword</title>

    <link rel="stylesheet" href="/css/forget.css">
    
</head>

<body>

<%  response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");%>
         
    <form  id="forget" onsubmit="return onsub()" action="otppsw.html">
        <div class="container" > 
            <div class="textbox">
                <input type="email" name="emailid" id="user_name" placeholder="Email" required autofocus>
                
    </div >
    

            <div class="textbox">
                <input type="text" placeholder="Mobile No" name="mbo" id="mbo" value="" required pattern="[0-9]{10}"
                    title="Must contain 10 numbers only">
            </div>


            <table cellspacing="30px">
                <tr>
                    <td> <button class="btn" type="submit" >send OTP</button></td>
                    <td> <button class="btn" type="reset">Reset</button></td>
                </tr>
            </table>



        </div>
    </form>

   




    <script type="text/javascript" src="/js/script.js"></script>
</body>

</html>