<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style type="text/css">
.text-center {
    text-align: center !important;
}
</style>
<script src="./resources/theme/web/js/validateform.js"></script>

<script type="text/javascript">
	function uploadJqueryForm() {
		$('#result').html('');

		$("#form2").ajaxForm({
			success : function(data) {
				$('#result').html(data);
			},
			dataType : "text"
		}).submit();
	}
</script>


<div cass="container-fluid">
	<div class="row">
		<div class="col-md-3 top-social-icons text-center">
			<ul class="social-icons">
				<li class="mr-1"><a href="#"><span
						class="fab fa-facebook-f"></span></a></li>
				<li class="mx-1"><a href="https://www.facebook.com/patel.smit.750"><span
						class="fab fa-google-plus-g"></span></a></li>
				<li class="mx-1"><a href="ttps://mail.google.com/mail/u/0/#inbox">
			</ul>
		</div>
		<div class="col-md-6 logo text-center">
			<h1>
				<a class="navbar-brand" href="index.html"> <i
					class="fas fa-leaf"></i>E-Farming
				</a>
			</h1>
		</div>
		<c:set var="userid" scope="session" value="${userId}" />
		<c:if test="${userid eq null}">
			<div class="col-md-3 login-right-img text-center">
				<a class="request text-uppercase" href="#" data-toggle="modal"
					data-target="#exampleModalCenter">Sign In</a> <a
					class="request text-uppercase" href="#" data-toggle="modal"
					data-target="#exampleModalCenter2">Sign Up</a>
			</div>
		</c:if>
		<c:if test="${userid ne null}">
			<div class="col-md-3 login-right-img text-center">
				<a class="request text-uppercase" href="logout.htm">logout</a>
			</div>
		</c:if>
	</div>
</div>
<div class="header-bg">
	<div class="container">
		<header>
			<nav class="navbar navbar-expand-lg navbar-light">
				<button class="navbar-toggler navbar-toggler-right mx-auto"
					type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-lg-auto text-left">
						<li class="nav-item active"><a class="nav-link"
							href="dashbord.htm">Home <span class="sr-only">(current)</span>
						</a></li>
						<li class="nav-item"><a class="nav-link"
							href="policyadmin.htm">GovermentPolicies</a></li>
						<li class="nav-item"><a class="nav-link" href="eventadmin.htm">Events</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="productadmin.htm">Product</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="queriesadmin.htm">Queries</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="useradmin.htm">Users</a>
						</li>
					</ul>	
				</div>
			</nav>
		</header>
	</div>
</div>
<!--//Login-->
<!--/Register-->

<script src="./resources/theme/web/js/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {

	$("search").keyup(function(){

	});
});

function searchquery() {
	var searchtxt=document.getElementById("search");
	if(searchtxt.length>=3){
		$.ajax({
		type : 'POST',
		async : false,
		url : "searchquery.htm?search=" + searchtxt + "&password=" + password,
		data : {
			'search' : searchtxt	
		},
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
	}else
		{
		
		}
}

</script>





