<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style type="text/css">
.row-inner
{
margin-right:50px;
margin-left:150px;
}
</style>
<!-- /breadcrumb -->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="home.htm">Home</a></li>
	<li class="breadcrumb-item active">Event</li>
</ol>
<!-- //breadcrumb -->
<section class="banner-bottom-w3layouts py-lg-5 py-md-5 py-3">
	<div class="container">
		<div class="inner-sec-w3ls-agileits py-lg-5 py-3">
			<div class="row-inner">
				<!--left-->
				
					<div class="blog-sec">
						<div class="about-in blog-grid-info text-left">
							<div class="card img">
								<c:forEach var="event" items="${eventList1}">
									<c:set var="eventid" scope="application"
													value="${event[0]}" />
									<div class="card-body img">
										<img src="eventimage.htm?eventid=${eventid}"  alt=""
										height="900px" width="900px"	class="img-fluid">
										<div class="blog-des blogger">
										<table>
										<tr>
										<td><b>Place</b></td>
										<td>&nbsp;&nbsp;:&nbsp;&nbsp;<c:out
													value="${event[3]}" /></td>										
										</tr>
										<tr>
										<td><b>Subject</b></td>
										<td>&nbsp;&nbsp;:&nbsp;&nbsp;<c:out
													value="${event[1]}" /></td>										
										</tr>
										<tr>
										<td><b>Time</b></td>
										<td>&nbsp;&nbsp;:&nbsp;&nbsp;<c:out
													value="${event[5]}" /></td>										
										</tr>
										<tr>
										<td><b>Date</b></td>
										<td>&nbsp;&nbsp;:&nbsp;&nbsp;<c:out
													value="${event[4]}" /></td>										
										</tr>
										</table>
											
											
                                         <form method="post" action="farmerentry.htm">
											<div class="log-in mt-md-3 mt-2">
												<a class="hover-2 btn text-uppercase" href="eventredirect.htm?id=${eventid}">Read
													More</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<a class="hover-2 btn text-uppercase" id="button3" onclick="checklogin();">Join Now</a>
											</div><input type="hidden" id="userId1" name="userId" value="<%=session.getAttribute("userId")%>">
											</form>	
											</div>	
										</div>
									</div></br>
									</c:forEach>					    
									</br>
							</div>
						</div>
					</div>
				</div>
				<!--//left-->
			</div>
		</div>
	</div>
</section>
<script>
$(document).ready(function() {

	$("button3").click(function() {

	});
});
function checklogin()
{
	debugger;
	var uid = document.getElementById("userId1").value;
	if(uid=="null"){
		alert("You must have to login for the join the event");
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
	alert("You are registerd for the event");
		});
	}
}
	
</script>
