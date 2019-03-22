<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style type="text/css">
.row-inner {
	margin-right: 50px;
	margin-left: 150px;
}
</style>
</head>
<!-- /breadcrumb -->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="index.html">Home</a></li>
	<li class="breadcrumb-item active">Event</li>
</ol>
<!-- //breadcrumb -->
<section class="banner-bottom-w3layouts py-lg-5 py-md-5 py-3">
	<div class="container">
		<div class="inner-sec-w3ls-agileits py-lg-5 py-3">

			<div class="row-inner">
				<!--left-->
				<c:forEach var="eventimage" items="${eventimageList}">
					<c:set var="eventid" scope="application" value="${eventimage[0]}" />



					<div class="blog-des blogger">
						<h3 class="card-title text-uppercase mt-2">
							<a href="#"><c:out value="${eventimage[1]}" /></a>
						</h3>
						<img src="singleeventimage.htm?id=${eventid}" class="img-fluid"
							alt="" height="800px" width="800px"></br>
						</br>

						<table>
							<tr>
								<td><b>Place</b></td>
								<td>&nbsp;&nbsp;:&nbsp;&nbsp;<c:out
										value="${eventimage[3]}" /></td>
							</tr>

							<tr>
								<td><b>Time</b></td>
								<td>&nbsp;&nbsp;:&nbsp;&nbsp;<c:out
										value="${eventimage[5]}" /></td>
							</tr>
							<tr>
								<td><b>Date</b></td>
								<td>&nbsp;&nbsp;:&nbsp;&nbsp;<c:out
										value="${eventimage[6]}" /></td>
							</tr>
						</table>
						</br> <b>DISCRIPTION:</b>
						<p>
							<c:out value="${eventimage[2]}" />
						</p>
						<div class="log-in mt-md-3 mt-2">
							<input type="hidden" id="userId2" name="userId"
								value="<%=session.getAttribute("userId")%>"> <a
								class="hover-2 btn text-uppercase" onclick=checkuserlogin();>join
								now </a>
						</div>
					</div>
			</div>

			</c:forEach>
		</div>
	</div>
	</div>
</section>
<script>
$(document).ready(function() {

	$("button3").click(function() {

	});
});
function checkuserlogin()
{
	debugger;
	var uid = document.getElementById("userId2").value;
	if(uid=="null"){
		alert("You must have to sign in for  the register in  the event");
	}
	else{
	$.ajax({
		type : 'POST',
		async : false,
		url : "farmerentry.htm?userId=" + uid,
		data : {'userId' : uid},
	processData : false,
	contentType : "application/json;charset=utf-8",
	dataType : "json",
	cache : false,
}).done(function(dataList) {
	debugger;
	alert("You successfully registerd for the event");
		});
	}
};
	
</script>

<!--//left-->
