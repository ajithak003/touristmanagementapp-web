
function verifyEmail() {
	var email = document.getElementById("email").value;
	const emailPattern = /^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$/;

	if (!emailPattern.test(email)) {
		document.getElementById('EmailError').textContent = 'Invalid Email Formate.';
		return;
	}

	$.ajax({
		type: "POST",
		url: "EmailVerificationServlet",
		data: { email: email },
		success: function(response) {
			if (!response.exists) {
				document.getElementById('EmailError').textContent = 'Email ID already exists.';
			}
		},
		error: function() {
			document.getElementById('EmailError').textContent = 'Error occurred during verification.';
		}
	});
}


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
	//console.log("function calling")
	var password = document.getElementById("psw").value;

	if (password.match(/(?=[A-Z])/)) {
		document.getElementById("upper").style.color = "rgb(31, 224, 31)";
	} else {
		document.getElementById("upper").style.color = "black";
	}

	if (password.match(/(?=[a-z])/)) {
		document.getElementById("lower").style.color = "rgb(31, 224, 31)";
	} else {
		document.getElementById("lower").style.color = "black";
	}

	if (password.match(/(?=[0-9])/)) {
		document.getElementById("number").style.color = "rgb(31, 224, 31)";
	} else {
		document.getElementById("number").style.color = "black";
	}

	if (password.match(/(?=.*[!@#\$%\^&\*])/)) {
		document.getElementById("special").style.color = "rgb(31, 224, 31)";
	} else {
		document.getElementById("special").style.color = "black";
	}

	if (password.length > 7) {
		document.getElementById("char").style.color = "rgb(31, 224, 31)";
	} else {
		document.getElementById("char").style.color = "black";
	}

}