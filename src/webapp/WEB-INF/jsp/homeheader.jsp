<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="./resources/theme/web/js/validateform.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
	function updatetext() {
		debugger;
		var pt = document.getElementById("usertype").checked;
		var pt1 = document.getElementById("usertype1").checked;
		var pt2 = document.getElementById("usertype2").checked;

		if (pt1) {
			document.getElementById("agronomisttype").style.display='block';
			document.getElementById("userdoc").style.display='block';
		} else {
			document.getElementById("agronomisttype").style.display='none';
			document.getElementById("userdoc").style.display='none';
		}
		if(pt2)
			{
			document.getElementById("companyname").style.display='block';
			document.getElementById("divfirstname").style.display='none';
			document.getElementById("divlastname").style.display='none';
			document.getElementById("lastname").removeAttribute('required');
			document.getElementById("firstname").removeAttribute('required');
			}
		else{
			document.getElementById("divfirstname").style.display='block';
			document.getElementById("divlastname").style.display='block';
			document.getElementById("companyname").style.display='none';
			document.getElementById("name").removeAttribute('required');
			
			
		}

	}
</script>



<div cass="container-fluid">
	<div class="row">
		<div class="col-md-3 top-social-icons text-center">
			<ul class="social-icons">
				<li class="mr-1"><a href="https://www.facebook.com/patel.smit.750"><span
						class="fab fa-facebook-f"></span></a></li>
				<li class="mx-1"><a href=""><span
						class="fab fa-google-plus-g"></span></a></li>
				<li class="mx-1"><a href="https://mail.google.com/mail/u/0/#inbox">
			</ul>
		</div>
		<div class="col-md-6 logo text-center">
			<h1>
				<a class="navbar-brand" href="home.htm"> <i
					class="fas fa-leaf"></i>E-Farming
				</a>
			</h1>
		</div>
		<c:set var="userid"  value="${userId}" />
		<c:if test="${userid eq null}">
			<div class="col-md-3 login-right-img text-center">
				<a class="request text-uppercase" href="#" data-toggle="modal"
					data-target="#exampleModalCenter">Sign In</a> <a
					class="request text-uppercase" href="#" data-toggle="modal"
					data-target="#exampleModalCenter2"onclick="updatetext();">Sign Up</a>
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
						<li class="nav-item active" id="home"><a class="nav-link"
							href="fromhome.htm">Home <span class="sr-only">(current)</span>
						</a></li>
						<c:set var="isadmin" scope="session" value="${isadmin}" />
						<c:if test="${isadmin eq true}">
							<li class="nav-item"><a class="nav-link" href="dashbord.htm">DASHBORD</a>
							</li>
						</c:if>
						<li class="nav-item"><a class="nav-link" href="product.htm">Product</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="govermentpolicies.htm">GovermentPolicies</a></li>
						<li class="nav-item"><a class="nav-link" href="event.htm">Events</a>
						</li>
						<c:set var="usertype" scope="session" value="${userType}" />
						<c:if test="${usertype ne 3}">
						<li class="nav-item"><a class="nav-link" href="queries.htm">Queries</a>
						</li>
						</c:if>
						
						<li class="nav-item"><a class="nav-link" href="contact.htm">Contact</a>
						</li>
						<li class="nav-item"><a class="nav-link" href="about.htm">About</a>
						</li>
						<c:set var="usertype" scope="session" value="${userType}" />
						<c:if test="${usertype eq 3}">
						<li class="nav-item"><a class="nav-link" href="productmanage.htm">Manage Product</a>
						</li>
						</c:if>
						 <input
									type="hidden" id="userId" name="userId"
									value="<%=session.getAttribute("userId")%>">
					</ul>
					
						<c:if test="${isadmin ne true}">
							
						
					<form method="post" class="form-inline-search my-2 my-lg-0 header-search"
						onkeyup="searchquery();" onsubmit="getProblemid();">
						<input type="search" placeholder="Search here..." name="Search"
							id="search" required="" list="DataList">
						<button class="btn btn1 my-2 my-sm-0" type="submit">
							<i class="fas fa-search"></i>
						</button>
						<datalist id="DataList"></datalist>
				</div>
				</form>
</c:if>
			</nav>
	</div>
	</nav>

	</header>
</div>
</nav>

</header>
</div>
</div>
</div>
<!-- main image slider container -->
<div class="slide-window">
	<div class="slide-wrapper" style="width: 300%;">
		<div class="slide">
			<div class="slide-caption text-center">
				<p class="text-uppercase">The right choice</p>
				<h3 class="text-uppercase">Improving agriculture, improving
					lives.</h3>
				<div class="cont-btn">
					<a class="btn text-uppercase" href="contact.htm"> Contact</a>
				</div>

			</div>
		</div>
		<div class="slide slide2">
			<div class="slide-caption text-center">
				<p class="text-uppercase">Ready to go</p>
				<h3 class="text-uppercase">High tech advantages with experts
					guidence.</h3>
				<div class="cont-btn">
					<a class="btn text-uppercase" href="contact.htm"> Contact</a>
				</div>

			</div>
		</div>
		<div class="slide slide3">
			<div class="slide-caption text-center">
				<p class="text-uppercase">The right choice.</p>
				<h3 class="text-uppercase">Improving agriculture, improving
					lives.</h3>
				<div class="cont-btn">
					<a class="btn text-uppercase" href="contact.htm"> Contact</a>
				</div>
			</div>
		</div>
	</div>
	<div class="slide-controller">
		<div class="slide-control-left">
			<div class="slide-control-line"></div>
			<div class="slide-control-line"></div>
		</div>
		<div class="slide-control-right">
			<div class="slide-control-line"></div>
			<div class="slide-control-line"></div>
		</div>
	</div>
</div>
<!-- main image slider container -->

<div class="modal fade" id="exampleModalCenter" tabindex="-1"
	role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="login px-4 mx-auto mw-100">
					<h5 class="text-center mb-4">Login Now</h5>
					<form method="post">
						<div class="form-group">
							<label class="mb-2">Email Address</label> <input type="email"
								class="form-control" id="email1" name="email1"
								aria-describedby="emailHelp" placeholder="" required="">
							<small id="emailHelp" class="form-text text-muted">We'll
								never share your email with anyone else.</small>
						</div>
						<div class="form-group">
							<label class="mb-2">Password</label> <input type="password"
								class="form-control" id="password" name="password"
								placeholder="" required=""> <input type="hidden"
								id="userId" name="userId"
								value="<%=session.getAttribute("userId")%>">
						</div>
						<button type="submit" class="btn btn-primary submit mb-4"
							onclick="userLogin();">Sign In</button>
						<p class="text-center pb-4">
							<a href="#" data-toggle="modal"
								data-target="#exampleModalCenter2"> Don't Have An Account?</a></br>
								<a href="#" data-toggle="modal"
								data-target="#exampleModalCenter3"> Forgot Password?</a>
						</p>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!--//Login-->
<div class="modal fade" id="exampleModalCenter3" tabindex="-1"
	role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="login px-4 mx-auto mw-100">
					<h5 class="text-center mb-4">Forgot Password</h5>
					<form method="post" action="forgotpassword.htm">
					<div class="form-group">
					<label>Select Registration Type</label> </br> <input type="radio"
								 name="fusertype" value="1" checked="checked"
								>&nbsp; Farmer &nbsp;&nbsp; <input
								type="radio" name="fusertype" value="2"
								>&nbsp;Agronomist&nbsp;&nbsp; <input
								type="radio"  name="fusertype" value="3"
								>&nbsp;Company</br>
								</div>
						<div class="form-group">
							<label class="mb-2">Email address</label> <input type="email"
								class="form-control" id="email1" name="forgotemail"
								aria-describedby="emailHelp" placeholder="" required="">
							
						</div>
						
						<button type="submit" class="btn btn-primary submit mb-4"
							>Send Me Link</button>
						<p class="text-center pb-4">
							
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<!--/Register-->
<!--/Register-->
<div class="modal fade" id="exampleModalCenter2" tabindex="-1"
	role="dialog" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header text-center">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="login px-4 mx-auto mw-100">
					<h5 class="text-center mb-4">Register Now</h5>
					<form name="myform" method="post" action="register.htm"
						onsubmit="return(validateform());" enctype="multipart/form-data">
						<div class="form-group">
							<label>Select Registration Type</label> </br> <input type="radio"
								id="usertype" name="usertype" value="1" checked="checked"
								onclick="updatetext()">&nbsp; Farmer &nbsp;&nbsp; <input
								type="radio" id="usertype1" name="usertype" value="2"
								onclick="updatetext()">&nbsp;Agronomist&nbsp;&nbsp; <input
								type="radio" id="usertype2" name="usertype" value="3"
								onclick="updatetext()">&nbsp;Company</br></br>
							<div class="form-group" id="divfirstname">

								<label>FirstName :</label> <input type="text"
									class="form-control" id="firstname" name="firstname"
									placeholder="" required="">
							</div>
							<div class="form-group" id="divlastname">
								<label>LastName :</label> <input type="text" class="form-control"
									id="lastname" name="lastname" placeholder="" required="" >
							</div>
							
								<div class="form-group"  id="companyname">
									<label>CompanyName :</label> <input type="text"
										class="form-control" id="name" name="name" placeholder=""required="">
								</div>
							
							<div class="form-group">
								<label>Email :</label><input type="email" class="form-control"
									id="email" name="email" aria-describedby="emailHelp"
									placeholder="" required="">
							</div>
							<div class="form-group">
								<label>Mobile No :</label> <input type="text" class="form-control"
									id="mobileno" name="mobileno" placeholder="" required="">
							</div>
							<div class="form-group">
								<label class="mb-2">Password :</label> <input type="password"
									class="form-control" id="password1" name="password1"
									placeholder="" required="">
							</div>
							<div class="form-group">
								<label>Confirm Password :</label> <input type="password"
									class="form-control" id="password2" name="password2"
									placeholder="" required="">
							</div>

						</div>
						<div class="form-group" id="agronomisttype">
							<label>Select Agronomist Type :</label> <select 
								name="agronomisttype">
								<option selected="selected" value="10">Select</option>
								<option value="Agronomy">Agronomy</option>
								<option value="Horticultutre">Horticulture</option>
								<option value="Lovestock">Live stock</option>
								<option value="SoilScince" >Soil science</option>
								<option value="Plantbreeding">Plantbreeding</option>
								<option value="Antmology">Antmology</option>
								<option value="Antmology">Meterology</option>
								<option value="Equipments Expert">Equipments Experts</option>
							</select>
						</div>
						<div class="form-group">
							<label>UserImage :</label> <input type="file" name="file"
								id="userphoto">
						</div>
						<div class="form-group" id="userdoc">
							<label>User Document :</label> <input type="file"
								name="userdocument" id="userdocument">
						</div>
						

						<button type="submit" class="btn btn-primary submit mb-4" " id="btn">Register
</button>
						<p class="text-center pb-4">
							<a href="#">By clicking Register, I agree to your terms</a>
						</p>
					</form>

				</div>
			</div>

		</div>
	</div>
</div>
<!--//Register-->
<script src="./resources/theme/web/js/jquery.min.js"></script>


<script>
	$(document).ready(function() {

		$("button").submit(function() {

		});
	});
	function userLogin() {
		debugger;
		var username = document.getElementById("email1").value;
		var password = document.getElementById("password").value;
		$.ajax({

			type : 'POST',
			async : false,
			url : "login.htm?username=" + username + "&password=" + password,
			data : {
				'username' : username,
				'password' : password
			},
			processData : false,
			contentType : "application/json;charset=utf-8",
			dataType : "json",
			cache : false,
		}).done(function(result) {
			var userId = result.userId;
			debugger;
			if (result.response == true) {
				alert('You are successfully Login');
			} else {
				alert('sorry incorrect credential');
			}
		});
	}
	debugger;
	document.getElementById("password1").onchange = validateform;
	document.getElementById("password2").onchange = validateform;
	document.getElementById("mobileno").onchange = validateform;
	document.getElementById("firstname").onchange = validateform;
	document.getElementById("lastname").onchange = validateform;
	document.getElementById("usertype").onchange = validateform;

	function validateform() {
		debugger;

		var pass1 = document.getElementById("password1").value;
		var pass2 = document.getElementById("password2").value;
		var phno = document.getElementById("mobileno").value;
		var fname = document.getElementById("firstname").value;
		var lname = document.getElementById("lastname").value;
		
		var email = document.getElementById("email").value;
		var num = /^[0-9]+$/;
		var radio = document.getElementById("usertype").value;
		var radio1 = document.getElementById("usertype1").value;
		var radio2 = document.getElementById("usertype2").value;
		var file = document.getElementById("userphoto").value;
		var Filename = document.getElementById("userphoto").files[0];
		var fileExtension = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
		if(fname==="")
			{
			document.getElementById("firstname").setCustomValidity(
			"please enter the field");
			} else {
				document.getElementById("firstname").setCustomValidity('');
			}
		if(lname==="")
		{
		document.getElementById("lastname").setCustomValidity(
		"please enter the field");
		} else {
			document.getElementById("lastname").setCustomValidity('');
		}
		
		if (fname.length > 20) {
			document.getElementById("firstname").setCustomValidity(
					"First name is not longer than 20 character");

		} else {
			document.getElementById("firstname").setCustomValidity('');
		}
		if (lname.length > 20) {
			document.getElementById("lastname").setCustomValidity(
					"First name is not longer than 20 character");

		} else {
			document.getElementById("lastname").setCustomValidity('');
		}

		if (phno.match(num)) {
			if (phno.length == 10) {
				document.getElementById("mobileno").setCustomValidity('');
			} else {
				document.getElementById("mobileno").setCustomValidity(
						"mobile number has 10 digit");
			}
		} else {
			document.getElementById("mobileno").setCustomValidity(
					"mobile no contains only numbers");
		}
		if (pass1.length > 6 && pass1.length < 12) {
			document.getElementById("password1").setCustomValidity('');
		} else {
			document.getElementById("password1").setCustomValidity(
					"password must between 6 to 12 characters");
		}
		if (pass1 != pass2) {
			document.getElementById("password2").setCustomValidity(
					"Passwords Don't Match");
		} else {
			document.getElementById("password2").setCustomValidity('');
		}

		function validateFile(Filename) {
			var arryExtentions = new Array("jpg", "jpeg", "gif", "png");
			var arryFile = new Array(Filename.name.split("."));
			var extention = arryFile[arryFile.length - 1].toLowerCase();
			for (var i = 0; i < arryExtentions.length; i++) {
				if (arryExtentions[i] == extention) {
					alert('welcome');
					return true;

				} else {
					alert("sorry wrong extension for the file")
					return false;
				}

			}
		}

	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

		$("search").keyup(function() {

		});
	});
	document.getElementById("search").onchange = searchquery;
	function searchquery() {
		debugger;
		var searchtxt = document.getElementById("search").value;
		if (searchtxt.length > 3) {

			$.ajax({
				type : 'POST',
				async : false,
				url : "searchquery.htm?search=" + searchtxt,
				data : {
					'search' : searchtxt
				},
				processData : false,
				contentType : "application/json;charset=utf-8",
				dataType : "json",
				cache : false,
			}).done(
					function(dataList) {
						debugger;
						$("#DataList").empty();
						for (var i = 0; i < dataList.length; i++) {
							var id = dataList[i].index;
							$("#DataList").append(
									"<option value='" + dataList[i].problem + "'>"
											+ id + "</option>");

						}
					});
		}

	}
</script>
<script type="text/javascript">
	function getProblemid() {
		debugger;
		 var x = document.getElementById("DataList").options.item(0).innerHTML;
		 
		 window.open("${pageContext.request.contextPath}/problem.htm?problemid="+x); 
	}
</script>

<script type="text/javascript">
function activeblur(){
	 var btn = document.getElementById('btn');
     btn.disabled = true;
     btn.innerText = 'Posting...'

} 
	</script>



