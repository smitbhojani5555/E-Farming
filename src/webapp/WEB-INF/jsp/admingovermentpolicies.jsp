<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>admin policy</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <script src="./resources/theme/web/js/myjs.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


  <!-- Trigger the modal with a button -->


  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
       <form method="post" enctype="multipart/form-data" action="addpolicy.htm" >
        <div class="modal-header">
         
          <h4 class="modal-title">Add Goverment Policies</h4>
        </div>
       
        <div class="modal-body">
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">Title:</label>
            <input type="text" class="form-control" id="title" name="title">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Discription:</label>
            <input type="text" class="form-control" id="discription" name="discription">
          </div>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">critearea:</label>
            <input type="text" class="form-control" id="criteareaa" name="critearea">
          </div>
           <div class="form-group">
            <label for="recipient-name" class="col-form-label">crated by:</label>
            <input type="text" class="form-control" id="createdby" name="createdby">
          </div>
                  </div>
        <div class="modal-footer">
          <button type="subimt" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" id="button" >Save</button>
           <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
          </form>
      </div>
      
    </div>
</div>
<div class="container">
  <h2>POLICY: </h2>
  <p>LIST OF THE POLICY:</p>   <div align="right">         
     <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">ADD NEW POLICY
  </button>        
  </div>
  <table class="table">
    <thead>
      <tr>
        <th>Title</th>
        <th>Description</th>
      
         <th>Critearea</th>
          <th>Remove</th>
         <th>Status</th>
         
      </tr>
    </thead>
    <tbody>
    <c:forEach var="policy" items="${govermentpoliciesList1}">
					<c:set var="policyid" scope="application" value="${policy[0]}" />
      <tr>
        <td><c:out value="${policy[2]}"/></td>
        <td><c:out value="${policy[1]}"/></td>
        
        <td><c:out value="${policy[4]}"/></td>
        <td><a href="deletepolicy.htm?policyid=${policyid}">   X    </a></td>
        <c:set var="status" scope="application" value="${policy[5]}" />
        <td><a href="#" onclick="deleteStatus(${status},${policyid})" id="button">
												<c:if test="${status == 1}">
													<i class="fa fa-check"></i>
												</c:if> <c:if test="${status == 0}">
													<i class="fa fa-times"></i>
												</c:if>
						</a>
						</td>
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


<script>
$(document).ready(function() {

	$("button").click(function() {
		

	});
});
function deleteStatus(status,policyid) {
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
		url : "deletepolicies.htm?status="+ status +"&policyid="+policyid,
		processData : false,	
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		cache : false,
	}).done(function() {
		debugger;
		if (status.response == 1) {
			alert('u r successfully Login');
		} else {
			alert('sorry incorrect password');
		}
	});

	
}

</script>

