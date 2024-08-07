


function cardPattern() {
	var cardNumber = document.getElementById('cardNumber').value;
	if (cardNumber.length == 4 || cardNumber.length == 10 || cardNumber.length == 16) {
		document.getElementById("cardNumber").value = cardNumber + '  ';

	}

}

function expiryDatePattern() {
	var expiryDate = document.getElementById('expiryDate').value;
	if (expiryDate.length == 2) {
		document.getElementById("expiryDate").value = expiryDate + '/';
	}
}




function validate(event) {
	const cardNumber = document.getElementById('cardNumber').value;
	const cvv = document.getElementById('cvv').value;
	const amount = document.getElementById('amount').value;
	const expiryDate = document.getElementById('expiryDate').value;
	const mobileNumber = document.getElementById('mobileNumber').value;
	const cardNumberPattern = /\d{4} {2}\d{4} {2}\d{4} {2}\d{4}/;
	const cvvPattern = /^\d{3}$/;
	const expiryDatePattern = /^(0[1-9]|1[0-2])\/(2[4-9]|3[0-3])$/;
	const mobileNumberPattern = /^\d{10}$/

	var isValid = true;

    if (!cardNumberPattern.test(cardNumber)) {
        document.getElementById('cardNumberError').textContent = 'Card number must be 16 digits.';
        isValid = false;
    } else {
        document.getElementById('cardNumberError').textContent = '';
    }

    if (!cvvPattern.test(cvv)) {
        document.getElementById('cvvError').textContent = 'CVV must be 3 digits.';
        isValid = false;
    } else {
        document.getElementById('cvvError').textContent = '';
    }

    if (amount < 10000) {
        document.getElementById('amountError').textContent = 'Amount must be a minimum of 10000 or more.';
        isValid = false;
    } else {
        document.getElementById('amountError').textContent = '';
    }

    if (!expiryDatePattern.test(expiryDate)) {
        document.getElementById('expiryDateError').textContent = 'Invalid expiry date.';
        isValid = false;
    } else {
        document.getElementById('expiryDateError').textContent = '';
    }
    
    if (!mobileNumberPattern.test(mobileNumber)) {
        document.getElementById('mobileNumberError').textContent = 'Invalid Mobile Number';
        isValid = false;
    } else {
        document.getElementById('mobileNumberError').textContent = '';
    }

    if (!isValid) {
        event.preventDefault();  // Prevent the default button action
        return false;
    }

}


 
/*function sendOTP(){
                // Prevent the default form submission
                event.preventDefault();

                // Serialize form data
                var formData = $(this).serialize();

                // Perform AJAX request
                $.ajax({
                    url: 'sendOTP',  // URL of the server-side script
                    type: 'POST',    // HTTP method
                    data: formData,  // Data to be sent
                    success: function(response) {
                        alert("OTP sent successfully!");
                    },
                    error: function(xhr, status, error) {
                        alert("Error sending OTP");
                    }
                });
            }*/