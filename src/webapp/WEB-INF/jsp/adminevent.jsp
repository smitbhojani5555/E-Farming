<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>admin product</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />

</style>




</head>
<body>


	<!-- Trigger the modal with a button -->


	<!-- Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<form method="post" enctype="multipart/form-data"
					action="addevent.htm">
					<div class="modal-header">

						<h4 class="modal-title">Add New Event</h4>
					</div>

					<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Subject:</label>
							<input type="text" class="form-control" id="subject"
								name="subject">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Discription:</label>
							<input type="text" class="form-control" id="discription"
								name="discription">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Place:</label>
							<input type="text" class="form-control" id="place" name="place">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Date:</label>
							Date: <input type="text" id="date" name="date"
								placeholder="dd/mm/yy" />
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Time:</label>
							Date: <input type="text" id="time" name="time"
								placeholder="hh:mm:" />
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">EventImage:</label>
							<input type="file" class="form-control" id="eventimage"
								name="eventimage" multiple="multiple">
						</div>

					</div>
					<div class="modal-footer">
						<button type="subimt" class="btn btn-info btn-lg"
							data-toggle="modal" data-target="#myModal" id="button">Save</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>


					</div>
				</form>
			</div>

		</div>
	</div>
	<div class="container">
		<h2>EVENTS:</h2>
		<p>LIST OF THE EVENTS:</p>
		<div align="right">
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#myModal">ADD NEW EVENTS</button>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>Subject</th>
					<th>Description</th>
					<th>Place</th>
					<th>Date</th>
					<th>Time</th>
					<th>Image</th>
					<th>Delete</th>
					<th>status</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="event" items="${eventList}">

					<tr>
						<td><c:out value="${event[1]}" /></td>
						<td><c:out value="${event[2]}" /></td>
						<td><c:out value="${event[3]}" /></td>
						<td><c:out value="${event[4]}" /></td>
						<td><c:out value="${event[5]}" /></td>
						<td><img src="eventimage.htm?eventid=${event[0]}" alt=""
							height="100px" width="100px"></td>
						<td><a href="deleteevent.htm?eventid=${event[0]}"> X </a></td>
						<c:set var="status" scope="application" value="${event[7]}" />
						<td><a href="#" onclick="deleteStatus(${status},${event[0]})"
							id="button"> <c:if test="${status == 1}">
									<i class="fa fa-check"></i>
								</c:if> <c:if test="${status == 0}">
									<i class="fa fa-times"></i>
								</c:if>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
<script src="./resources/theme/web/js/myjs.js"></script>
<script>
$(document).ready(function() {

	$("button").click(function() {
		

	});
});
function deleteStatus(status,eventid) {
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
		url : "delete.htm?status="+ status +"&eventid="+eventid,
		processData : false,	
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		cache : false,
	}).done(function(eventList) {
		debugger;
		if (status.response == 1) {
			alert('You are successfully Login');
		} else {
			alert('sorry incorrect password');
		}
	});

}

</script>

</body>


