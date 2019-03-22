<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<link href="./resources/theme/web/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<link rel="stylesheet" href="./resources/theme/web/css/component.css"
	type="text/css" media="all">
<link href="./resources/theme/web/css/style.css" rel='stylesheet'
	type='text/css' />
<link href="./resources/theme/web/css/single.css" rel='stylesheet'
	type='text/css' />
<link href="./resources/theme/web/css/fontawesome-all.css"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=BenchNine:300,400,700"
	rel="stylesheet">
</head>
<style type="text/css">
/**
 * Oscuro: #283035
 * Azul: #03658c
 * Detalle: #c7cacb
 * Fondo: #dee1e3
 ----------------------------------*/
* {
	margin: 0;
	padding: 0;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

a {
	color: #03658c;
	text-decoration: none;
}

ul {
	list-style-type: none;
}

body {
	font-family: 'Roboto', Arial, Helvetica, Sans-serif, Verdana;
	background: #dee1e3;
}

/** ====================
 * Lista de Comentarios
 =======================*/
.comments-container {
	margin: 2px auto 14px;
	width: 768px;
}

.comments-container h1 {
	font-size: 36px;
	color: #283035;
	font-weight: 400;
}

.comments-container h1 a {
	font-size: 18px;
	font-weight: 700;
}

.comments-list {
	margin-top: 30px;
	position: relative;
}

/**
 * Lineas / Detalles
 -----------------------*/
.comments-list:before {
	content: '';
	width: 2px;
	height: 100%;
	background: #dee1e3;
	position: absolute;
	left: 32px;
	top: 0;
}

.comments-list:after {
	content: '';
	position: absolute;
	background: #c7cacb;
	bottom: 0;
	left: 27px;
	width: 7px;
	height: 7px;
	border: 3px solid #dee1e3;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
}

.reply-list:before, .reply-list:after {
	display: none;
}

.reply-list li:before {
	content: '';
	width: 60px;
	height: 2px;
	background: #c7cacb;
	position: absolute;
	top: 25px;
	left: -55px;
}

.comments-list li {
	margin-bottom: 15px;
	display: block;
	position: relative;
}

.comments-list li:after {
	content: '';
	display: block;
	clear: both;
	height: 0;
	width: 0;
}

.reply-list {
	padding-left: 88px;
	clear: both;
	margin-top: 15px;
}
/**
 * Avatar
 ---------------------------*/
.comments-list .comment-avatar {
	width: 65px;
	height: 65px;
	position: relative;
	z-index: 99;
	float: left;
	border: 3px solid #FFF;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	overflow: hidden;
}

.comments-list .comment-avatar img {
	width: 100%;
	height: 100%;
}
.comments-list .comment-avatar b {
	font-family:arial;
}


.reply-list .comment-avatar {
	width: 50px;
	height: 50px;
}

.comment-main-level:after {
	content: '';
	width: 0;
	height: 0;
	display: block;
	clear: both;
}
/**
 * Caja del Comentario
 ---------------------------*/
.comments-list .comment-box {
	width: 680px;
	float: right;
	position: relative;
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15);
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15);
}

.comments-list .comment-box:before, .comments-list .comment-box:after {
	content: '';
	height: 0;
	width: 0;
	position: absolute;
	display: block;
	border-width: 10px 12px 10px 0;
	border-style: solid;
	border-color: transparent #FCFCFC;
	top: 8px;
	left: -11px;
}

.comments-list .comment-box:before {
	border-width: 11px 13px 11px 0;
	border-color: transparent rgba(0, 0, 0, 0.05);
	left: -12px;
}

.reply-list .comment-box {
	width: 610px;
}

.comment-box .comment-head {
	background: #FCFCFC;
	padding: 10px 12px;
	border-bottom: 1px solid #E5E5E5;
	overflow: hidden;
	-webkit-border-radius: 4px 4px 0 0;
	-moz-border-radius: 4px 4px 0 0;
	border-radius: 4px 4px 0 0;
}

.comment-box .comment-head i {
	float: right;
	margin-left: 14px;
	position: relative;
	top: 2px;
	color: #A6A6A6;
	cursor: pointer;
	-webkit-transition: color 0.3s ease;
	-o-transition: color 0.3s ease;
	transition: color 0.3s ease;
}

.comment-box .comment-head i:hover {
	color: #03658c;
}

.comment-box .comment-name {
	color: #283035;
	font-size: 14px;
	font-weight: 700;
	float: left;
	margin-right: 10px;
}

.comment-box .comment-name a {
	color: #283035;
}

.comment-box .comment-head span {
	float: left;
	color: #999;
	font-size: 13px;
	position: relative;
	top: 1px;
}

.comment-box .comment-content {
	background: #FFF;
	padding: 12px;
	font-size: 15px;
	color: #595959;
	-webkit-border-radius: 0 0 4px 4px;
	-moz-border-radius: 0 0 4px 4px;
	border-radius: 0 0 4px 4px;
}

.comment-box .comment-name.by-author, .comment-box .comment-name.by-author a
	{
	color: #03658c;
}

.comment-box .comment-name.by-author:after {
	content: 'autor';
	background: #03658c;
	color: #FFF;
	font-size: 12px;
	padding: 3px 5px;
	font-weight: 700;
	margin-left: 10px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}
.ct{
font-size: 0.7rem;
  font-weight: 300;
  line-height: 1.0;
  color: #212529;
  text-align: left;
}
/** =====================
 * Responsive
 ========================*/
@media only screen and (max-width: 766px) {
	.comments-container {
		width: 480px;
	}
	.comments-list .comment-box {
		width: 390px;
	}
	.reply-list .comment-box {
		width: 320px;
	}
}

</style>


<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1"
	crossorigin="anonymous">
	<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="home.htm">Home</a></li>
	<li class="breadcrumb-item active">Queries</li>
</ol>
<div class="row">
	<!-- Contenedor Principal -->
	<div class="comments-container">
		

		<ul id="comments-list" class="comments-list">
		<c:forEach var="problem" items="${problemList}">
			<li>
			 
			 
			  
				<div class="comment-main-level">
				
					<!-- Avatar -->
					<div class="comment-avatar1">
						<div class="comment-avatar">
							<img src="userimage.htm?userid=${problem[4]}" alt="">
							
						</div>
					
						<!-- Contenedor del Comentario -->
						<div class="comment-box">
							<div class="comment-head">
								
									<a href="problem.htm?problemid=${problem[3]}"><c:out
												value="${problem[2]}" /></a></br>
								<h6 class="ct">by&nbsp;&nbsp;<b><c:out value="${problem[0]}" /></b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date&nbsp;&nbsp;<c:out value="${problem[7]}" />  </h6>  
							</div>
							<div class="comment-content">
								<c:out value="${problem[5]}" />
							</div>
						</div>
				</div> <!-- Respuestas de los comentarios -->
				
			</li>
			</c:forEach> 
		</ul>
	</div>
</div>	
      <div class="comments-container">
					
						<h4>Solution:</h4>
						
						<form method="post" onsubmit="return (verifyuser());"
							action="insert.htm">
							<input class="form-control" type="text" name="subject"
								id="subject" placeholder="Subject" required=""></br> <input
								type="hidden" id="userId" name="userId"
								value="<%=session.getAttribute("userId")%>">
								<input
								type="hidden" id="usertype4" name="usertype"
								value="<%=session.getAttribute("userType")%>">
							<textarea class="form-control" name="description"
								id="discription" placeholder="description" required=""></textarea>
							<button type="submit" class="btn btn-primary submit mb-4">Post
								Your Problem</button>
						</form>
					</div>
		<script type="text/javascript">			
		function verifyuser() {
			debugger;
			var uid = document.getElementById("userId").value;
			var utype= document.getElementById("usertype4").value;
			
			if (uid != "null") {
				if(utype==1){	
					alert('Your  query is posted successfully');
					return true;
				}
				alert('Only farmer is allowed to ask queries');
				return false;
			} else {
				alert('You must have signin for the Post your Query');
				return false;
			}
			if(utype==1)
				{
				alert('Only farmer can post their problem');
				}
			else{
				alert('your problem posted successfully')
			}
		}
    </script>				



