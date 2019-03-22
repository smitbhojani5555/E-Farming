window.onload = function() {
	document.getElementById("userId").onchange = validateuser;
}
function validateuser() {
	var userId = document.getElementById("userId").value;
	if (userId == null) {
		document.getElementById("subject").setCustomValidity(
				"u must have login");
	} else {
		document.getElementById("subject").setCustomValidity('');
		// empty string means no validation error
	}
}