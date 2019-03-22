<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>admin product</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <script src="./resources/theme/web/js/myjs.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style type="text/css">
  button.close {
    padding: 0;
    cursor: pointer;
    background: 0 0;
    border: 0;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
  </style>
</head>
<body>

  
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
       <form method="post" enctype="multipart/form-data" action="insertproduct.htm" id="myform" name="myform">
        <div class="modal-header">
                    <h4 class="modal-title">New Product</h4>
        </div>
       
        <div class="modal-body">
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">ProductName:</label>
            <input type="text" class="form-control" id="productname" name="productname">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Price:</label>
            <input type="text" class="form-control" id="price" name="price">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Description:</label>
            <input type="text" class="form-control" id="discription" name="discription">
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">ProductContent:</label>
            <input type="text" class="form-control" id="content" name="content">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">ProductImage:</label>
            <input type="file" class="form-control" id="productimage" name="productimage" enctype="multipart/form-data">
          </div>
          
                  </div>
        <div class="modal-footer">
          <button type="subimt" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" id="button" onclick="return (submitForm());">Save</button>
           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
           
       
        </div>
          </form>
      </div>
      
    </div>
</div>
<div class="container">
  <h2>PRODUCTS: </h2>
  <p>LIST OF THE PRODUCTS:</p>    <div align="right">
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">ADD NEW PRODUCTS
  </button>
  </div>
          
           
  <table class="table">
    <thead>
      <tr>
        <th>Productname</th>
        <th>Content</th>
        <th>Discription</th>
          <th>Price</th>
            <th>Image</th>
            <th>Remove</th>
             <th>Status</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productList1}">
					<c:set var="productid" scope="application" value="${product[0]}" />
      <tr>
        <td><c:out value="${product[1]}"/></td>
        <td><c:out value="${product[5]}"/></td>
        <td><c:out value="${product[2]}"/></td>
        <td>&#x20B9;&nbsp;<c:out value="${product[3]}"/></td>
        <td><img src="productimage.htm?productid=${productid}" alt=""
									height="100px" width="100px"></td>
									<td><a href="deleteproduct.htm?productid=${productid}">   X    </a></td>
									<c:set var="status" scope="application" value="${product[6]}" />
								<td><a href="#" onclick="deleteStatus(${status},${productid})" id="button">
												<c:if test="${status == 1}">
													<i class="fa fa-check"></i>
												</c:if> <c:if test="${status == 0}">
													<i class="fa fa-times"></i>
												</c:if>
						</a>
						</td>
      </tr>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
</div>

</body>
</html>
    </table>
</div>

</body>

 <script type="text/javascript">
   function submitForm() {
	   debugger;
   var frm = document.getElementsByName('myform')[0];
   frm.submit(); // Submit the form
   
   // Reset all form data
   return false; // Prevent page refresh
            }
        </script>
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
		url : "productdelete.htm?status="+ status +"&productid="+productid,
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

</body>


        