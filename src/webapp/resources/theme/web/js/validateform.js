function onloadRegistartionFunction() {
	document.getElementById("password1").onchange = validateform;
	document.getElementById("password2").onchange = validateform;
	document.getElementById("mobileno").onchange = validateform;
	document.getElementById("firstname").onchange = validateform;
	document.getElementById("lastname").onchange = validateform;
	document.getElementById("usertype").onchange = validateform;
}

function validateform() {
	debugger;

	var pass1 = document.getElementById("password1").value;
	var pass2 = document.getElementById("password2").value;
	var phno = document.getElementById("mobileno").value;
	var fname = document.getElementById("firstname").value;
	var lname = document.getElementById("lastname").value;
	var num = /^[0-9]+$/;
	var radio = document.getElementById("usertype").value;
	var radio1 = document.getElementById("usertype1").value;
	var radio2 = document.getElementById("usertype2").value;
	if(fname=="")
	{
	document.getElementById("firstname").setCustomValidity(
	"please enter the field");
	} else {
		document.getElementById("firstname").setCustomValidity('');
	}
if(lname=="")
{
document.getElementById("lastname").setCustomValidity(
"please enter the field");
} else {
	document.getElementById("lastname").setCustomValidity('');
}
	if (fname.length > 20) {
		document.getElementById("firstname").setCustomValidity(
				"First name is not longer than 20 character");

	} else {
		document.getElementById("firstname").setCustomValidity('');
	}
	if (lname.length > 20) {
		document.getElementById("lastname").setCustomValidity(
				"First name is not longer than 20 character");

	} else {
		document.getElementById("lastname").setCustomValidity('');
	}

	if (phno.match(num)) {
		if (phno.length == 10) {
			document.getElementById("mobileno").setCustomValidity('');
		} else {
			document.getElementById("mobileno").setCustomValidity(
					"mobile number has 10 digit");
		}
	} else {
		document.getElementById("mobileno").setCustomValidity(
				"mobile no contains only numbers");
	}
	if (pass1.length > 6 && pass1.length < 12) {
		document.getElementById("password1").setCustomValidity('');
	} else {
		document.getElementById("password1").setCustomValidity(
				"password must between 6 to 12 characters");
	}
	if (pass1 != pass2) {
		document.getElementById("password2").setCustomValidity(
				"Passwords Don't Match");
	} else {
		document.getElementById("password2").setCustomValidity('');
	}
	
}
