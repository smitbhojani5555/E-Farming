<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>admin queries</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="./resources/theme/web/js/myjs.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>


	
		</div>
	</div>
	<div class="container">
		<h2>QUERIES:</h2>
		<p>LIST OF THE QUERIES:</p>

		<table class="table">
			<thead>
				<tr>
					<th>Subject</th>
					<th>Description</th>
					<th>Remove</th>
					<th>Validate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="query" items="${problemList1}">
					<c:set var="problemid" scope="application" value="${query[3]}" />
					<tr>
						<td><c:out value="${query[2]}" /></td>
						<td><c:out value="${query[5]}" /></td>
						<td><a href="deletequeries.htm?problemid=${problemid}"> X </a></td>
									<c:set var="status" scope="application" value="${query[6]}" />
								<td><a href="#" onclick="deleteStatus(${status},${problemid})" id="button1">
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

<script src="./resources/theme/web/js/myjs.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	$("button1").click(function() {
		

	});
});
function deleteStatus(status,problemid) {
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
		url : "deletequery.htm?status="+ status +"&problemid="+problemid,
		processData : false,	
		contentType : "application/json;charset=utf-8",
		dataType : "json",
		cache : false,
	}).done(function(result) {
		var userId = result.userId;
		debugger;
		if (result.response == true) {
			alert('u r successfully Login');
		} else {
			alert('sorry incorrect password');
		}
	});

	
}

</script>


