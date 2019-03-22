<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<head>
<style type="text/css">
.form-gap {
	padding-top: 70px;
}
</style>
</head>
<!------ Include the above in your HEAD tag ---------->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<div class="form-gap"></div>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="text-center">
						<h3>
							<i class="fa fa-lock fa-4x"></i>
						</h3>
						<h2 class="text-center">Reset Password?</h2>
						<p>You can reset your password here.</p>
						<div class="panel-body">

							<form id="register-form" role="form" autocomplete="off"
								class="form" method="post" action="updatepassword.htm" >

								<div class="form-group">
									<div class="input-group">

										<input id="newpassword" name="newpassword" placeholder="Password"
											class="form-control" type="text">
									</div>
								</div>
								<div class="form-group">
									<div class="input-group">

										<input id="newpassword1" name="newpassword1"
											placeholder="Confirm Password" class="form-control"
											type="text">
									</div>
									<input type="hidden" class="hide" name="userId" id="token"
									value="<%=session.getAttribute("userId1")%>">
								</div>		
									<div class="form-group">
									<input name="recover-submit" class="btn btn-lg btn-primary btn-block"
										value="Reset Password" type="submit">					
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function matchpassword() {
		debugger;
		var pwd1 = document.getElementById("newpassword").value;
		var pwd2 = document.getElementById("newpassword1").value;

		if (pwd1 == pwd2) {
			alert("Password is changed");
		} else {
			alert("password is not matched");
		}
	}
</script>