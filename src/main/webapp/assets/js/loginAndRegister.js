/**
 * this function used to visible password in login page
 */

function showPassword() {
			var x = document.getElementById("psw");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
		
/**
    this function used check password pattern in register page
 */		

function checkpattern() {
			console.log("function calling")
			var password = document.getElementById("psw").value;
			console.log(password)
			if (password.match(/(?=[A-Z])/)) {
				console.log("upper")
				document.getElementById("upper").style.color = "rgb(31, 224, 31)";
			} else {
				document.getElementById("upper").style.color = "black";
			}

			if (password.match(/(?=[a-z])/)) {
				console.log("lower")
				document.getElementById("lower").style.color = "rgb(31, 224, 31)";
			} else {
				document.getElementById("lower").style.color = "black";
			}

			if (password.match(/(?=[0-9])/)) {
				console.log("number")
				document.getElementById("number").style.color = "rgb(31, 224, 31)";
			} else {
				document.getElementById("number").style.color = "black";
			}

			if (password.match(/(?=.*[!@#\$%\^&\*])/)) {
				console.log("special")
				document.getElementById("special").style.color = "rgb(31, 224, 31)";
			} else {
				document.getElementById("special").style.color = "black";
			}

			if (password.length > 7) {
				console.log("character")
				document.getElementById("char").style.color = "rgb(31, 224, 31)";
			} else {
				document.getElementById("char").style.color = "black";
			}

		}