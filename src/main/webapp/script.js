/**
 * 
 */




function onsub() {
     var username = document.getElementById("user_name");
     var mbo = document.getElementById("mbo");
     console.log("hi");
     if (username.value.trim() == "" || mbo.value.trim() == "") {
          console.log("false");
          alert("please enter the user name and mobile no");
          return false;
     }
     else {

          console.log("ture");
          return true;
     }

}

function otpfun() {
     var otp = document.getElementById("otp");
     console.log("hi");
     if (otp.value.trim() == "") {
          console.log("false");
          alert("please enter the user name and mobile no");
          return false;
     }
     else {

          console.log("ture");
          return true;
     }

}
function resetpsw() {
     var psw = document.getElementById("rpsw");
     var cpsw = document.getElementById("cpsw");
     console.log("hi");
     if (psw.value.trim() == "" || cpsw.value.trim() == "") {
          console.log("false");
          alert("please enter the user name and mobile no");
          return false;
     }
     
}