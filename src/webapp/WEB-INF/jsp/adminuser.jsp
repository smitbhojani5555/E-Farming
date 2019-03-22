<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>admin user</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <script src="./resources/theme/web/js/myjs.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
</head>
<body>

  
 
<div class="container">
  <h2>USER: </h2>
  <p>LIST OF THE USER:</p>    <div align="right">
  <!-- Trigger the modal with a button -->
  
  
  </div>
          
           
  <table class="table">
    <thead>
      <tr>
        <th>Email</th>
        <th>FirstName</th>
         <th>LastName</th>
        <th>MobileNo</th>
        <th>UserType</th>
         
              <th>UserDocument</th>
               <th>Validate</th>
                
      </tr>
    </thead>
    <tbody>
     <c:forEach var="user" items="${userList}">
	<c:set var="id" scope="application" value="${user[0]}" />
      <tr>
        <td><c:out value="${user[4]}"/></td>
        <td><c:out value="${user[1]}"/></td>
        <td><c:out value="${user[2]}"/></td>
        <td><c:out value="${user[8]}"/></td>
        <td><c:out value="${user[9]}"/></td>
          
          <td><img src="userdocumentimage.htm?userid=${id}" alt=""
									height="100px" width="100px"></td>
									<td><a href="deleteuser.htm?userid=${id}">   X    </a></td>
									
					
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
</div>

</body>
</html>
  



<script>
$(document).ready(function() {

	$("button").click(function() {
		

	});
});
function deleteStatus(status,productid) {
	debugger;

	if(status==1)
		{
		status=0;
		}else
			{
			status=1;
			}
	
	$.ajax({
		type : 'POST',
		async : false,
		url : "userdelete.htm?status="+ status +"&productid="+id,
		processData : false,	
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		cache : false,
	}).done(function(productList) {
		debugger;
		if (status.response == 1) {
			alert('u r successfully Login');
		} else {
			alert('sorry incorrect password');
		}
	});
	
}

</script>

 <script type="text/javascript">
   function submitForm() {
	   debugger;
   var frm = document.getElementsByName('myform')[0];
   frm.submit(); // Submit the form
   
   // Reset all form data
   return false; // Prevent page refresh
            }
        </script>
<script type="text/javascript">
	$(document).ready(function() {

		$("button").submit(function() {

		});
	});
	function addProduct() {
		debugger;
		var productname = document.getElementById("productname").value;
		var price = document.getElementById("price").value;
		var discription = document.getElementById("discription").value;
		var content = document.getElementById("content").value;
		
		if (window.File && window.FileReader && window.FileList && window.Blob) {
			  document.getElementById('productimage').addEventListener('change', handleFileSelect, false);
			} else {
			  alert('The File APIs are not fully supported in this browser.');
			}
			function handleFileSelect(evt) {
			  var f = evt.target.files[0]; 
			  var reader = new FileReader();
			  reader.onload = (function(theFile) {
			    return function(e) {
			    	debugger;
			      var binaryData = e.target.result;

			    };
			  })(f);
			  // Read in the image file as a data URL.
			  reader.readAsBinaryString(f);
			}
		
	
		$.ajax({
			type : 'POST',
			 enctype: 'multipart/form-data',
			async : false,
			url : "insertproduct.htm?productname=" + productname + "&price=" + price+ "&discription=" + discription+ "&content=" + content +"&productimage="+ file ,
			processData : false,
			contentType : "application/json;charset=utf-8",
			dataType : "json",
			cache : false,
		}).done(function() {
			debugger;
			if (result.response == true) {
				alert('u r successfully Login');
			} else {
				alert('sorry incorrect password');
			}
		});
	}
	</script>
