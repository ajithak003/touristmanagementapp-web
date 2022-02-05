/**
 * restrict previous date and show only one month (current date to next 30 days) and disable future dates
 */

today();
function today(){
  
var currentTime = new Date() 
var minDate = new Date(currentTime.getFullYear(), currentTime.getMonth(), + currentTime.getDate()+2); //one day next before month
var maxDate =  new Date(currentTime.getFullYear(), currentTime.getMonth() +1, +currentTime.getDate()+2	); // one day before next month
console.log(minDate);
console.log(maxDate);
let date = JSON.stringify(maxDate)
date = date.slice(1,11)
console.log(date)
let dates = JSON.stringify(minDate)
dates = dates.slice(1,11)
console.log(dates)
document.getElementById("date").setAttribute("max",date);
document.getElementById("date").setAttribute("min",dates);

}   
/**
 * animated (sweet alert messages) pop up message fuctions. using swal inbuild fuctions success, error and warning popups
 */

function popupMessages(infoMessage) {

	const message = infoMessage;
	console.log(message);
	switch (message) {

		case "Successfully Added":

			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'success',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});


			toastMixin.fire({
				animation: true,
				title: 'Successfully Added'
			});

			break;

		case "Flight can not be Added":

			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'error',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});

			toastMixin.fire({
				title: 'Flight can not be Added! please try again later',
				icon: 'error'
			});

			break;

		case "This Hotel Already Added":

			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'error',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});

			toastMixin.fire({
				title: 'This Hotel Already Added',
				icon: 'error'
			});

			break;

		case "This Package Already Added!":

			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'error',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});

			toastMixin.fire({
				title: 'This Package Already Added!',
				icon: 'error'
			});

			break;

		case "Username and Password mismach":
			console.log(message);
			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'error',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});


			toastMixin.fire({
				animation: true,
				title: 'Username and Password mismach'
			});

			break;

		case "Successfully Registered":

			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'success',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});



			toastMixin.fire({
				animation: true,
				title: 'Successfully Registered !\n please login'
			});

			break;

		case "Not allowed":
			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'error',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});



			toastMixin.fire({
				animation: true,
				title: 'Not allowed "@admin"!'
			});

			break;

		case "This email id already registered":
			console.log(message);
			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'error',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});



			toastMixin.fire({
				animation: true,
				title: 'This email id already registered!'
			});

			break;

		case "successfully updated":
			Swal.fire({
				icon: 'success',
				title: 'Updated',
				showConfirmButton: false,
				timer: 2000
			})
			break;

		case "cannot be updated":
			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'success',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});

			toastMixin.fire({
				title: 'cannot be updated',
				icon: 'error'
			});

			break;

		case "Successfully deleted":
			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'success',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});


			toastMixin.fire({
				animation: true,
				title: 'Successfully deleted'
			});
			break;

		case "cannot be deleted":
			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'success',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});

			toastMixin.fire({
				title: 'cannot be deleted',
				icon: 'error'
			});

			break;

		case "Insufficient balance":
			Swal.fire({
				icon: 'error',
				title: 'Insufficient balance !',
				showConfirmButton: false,
				timer: 2000
			})
			break;

		case "Transaction failed":
			var toastMixin = Swal.mixin({
				toast: true,
				icon: 'success',
				title: 'General Title',
				animation: false,
				position: 'top-right',
				showConfirmButton: false,
				timer: 3000,
				timerProgressBar: true,
				didOpen: (toast) => {
					toast.addEventListener('mouseenter', Swal.stopTimer)
					toast.addEventListener('mouseleave', Swal.resumeTimer)
				}
			});

			toastMixin.fire({
				title: 'Transaction failed',
				icon: 'error'
			});

			break;
	}

}

function deleteHotel(hotelid) {
	Swal.fire({
		title: "Are you sure about \n deleting this hotel?",
		type: "info",
		showCancelButton: true,
		confirmButtonText: "Delete It",
		confirmButtonColor: "#ff0055",
		cancelButtonColor: "#999999",
		focusConfirm: false,
		focusCancel: true
	}).then((result) => {
		if (result.isConfirmed) {
			window.location.replace("deleteHotel?info=&hotelid=" + hotelid);
		}
	})
}

function packagedelete(packagename) {
	Swal.fire({
		title: "Are you sure about \n deleting this Package?",
		type: "info",
		showCancelButton: true,
		confirmButtonText: "Delete It",
		confirmButtonColor: "#ff0055",
		cancelButtonColor: "#999999",
		focusConfirm: false,
		focusCancel: true
	}).then((result) => {
		if (result.isConfirmed) {
			window.location.replace("deletepackage?info=&packagname=" + packagename);
		}
	})
}

function deleteflight(flightNo) {
	Swal.fire({
		title: "Are you sure about \n deleting this flight?",
		type: "info",
		showCancelButton: true,
		confirmButtonText: "Delete It",
		confirmButtonColor: "#ff0055",
		cancelButtonColor: "#999999",
		focusConfirm: false,
		focusCancel: true
	}).then((result) => {
		if (result.isConfirmed) {
			window.location.replace("deleteFlight?info=&flightno=" + flightNo);
		}
	})
}

function confirm() {
	window.location.replace("bookingsus");
}

/*function confirm() {

	$.ajax({
		type: 'GET',
		url: 'bookingsus',
		cache: false,
		success: function() {
			window.location.replace("bookingsus.jsp");
		}
		
	});
	
}*/


function cancel() {
	Swal.fire({
		title: "Are you sure about \n cancel this booking ?",
		type: "info",
		showCancelButton: true,
		cancelButtonText: "No",
		confirmButtonText: "Yes",
		confirmButtonColor: "#ff0055",
		cancelButtonColor: "#999999",
		focusConfirm: false,
		focusCancel: true
	}).then((result) => {
		if (result.isConfirmed) {
			window.location.replace("userPage.jsp");
		}
	})
}

function cancelBooking(bookingId) {
	Swal.fire({
		title: "if you want to cancel 10% cancelation charge \n will be detected on your total price",
		type: "info",
		showCancelButton: true,
		cancelButtonText: "Cancel",
		confirmButtonText: "  Ok",
		confirmButtonColor: "#ff0055",
		cancelButtonColor: "#999999",
		focusConfirm: false,
		focusCancel: true
	}).then((result) => {
		if (result.isConfirmed) {
			window.location.replace("cancelTrip?bookingid=" + bookingId);
		}
	})
}



