<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    
"http://www.w3.org/TR/html4/loose.dtd">

<!--
	Author: W3layouts
	Author URL: http://w3layouts.com
	License: Creative Commons Attribution 3.0 Unported
	License URL: http://creativecommons.org/licenses/by/3.0/
-->

<html lang="zxx">

<head>
<title>EFarming website</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords"
	content="Arable a Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
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
<link rel="stylesheet" href="./resources/theme/web/css/owl.theme.css"
	type="text/css" media="all">
<link rel="stylesheet" href="./resources/theme/web/css/owl.carousel.css"
	type="text/css" media="screen" property="" />
<link href="./resources/theme/web/css/minimal-slider.css"
	rel='stylesheet' type='text/css' />
<link href="./resources/theme/web/css/fontawesome-all.css"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=BenchNine:300,400,700"
	rel="stylesheet">
	 <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>



	<tiles:insertAttribute name="adminheader" />
	<tiles:insertAttribute name="body" />
	

	<!-- js -->
	<script src="./resources/theme/web/js/jquery-2.2.3.min.js"></script>
	<script src="./resources/theme/web/js/minimal-slider.js"></script>
	<script src="./resources/theme/web/js/toucheffects.js"></script>
	<script src="./resources/theme/web/js/modernizr.custom.js"></script>
	<!-- carousel -->
	<script src="./resources/theme/web/js/owl.carousel.js"></script>
	<script src="./resources/theme/web/js/ConvertImage.js"></script>
	<script>
		$(document).ready(function() {
			$('.owl-carousel').owlCarousel({
				loop : true,
				margin : 10,
				responsiveClass : true,
				responsive : {
					0 : {
						items : 1,
						nav : true
					},
					600 : {
						items : 1,
						nav : false
					},
					900 : {
						items : 1,
						nav : false
					},
					1000 : {
						items : 2,
						nav : true,
						loop : false,
						margin : 20
					}
				}
			})
		})
	</script>
	<!-- //carousel -->
	<script>
		$(document).ready(function() {
			$(".dropdown").hover(function() {
				$('.dropdown-menu', this).stop(true, true).slideDown("fast");
				$(this).toggleClass('open');
			}, function() {
				$('.dropdown-menu', this).stop(true, true).slideUp("fast");
				$(this).toggleClass('open');
			});
		});
	</script>
	<!-- //dropdown nav -->
	<!-- stats -->
	<script src="./resources/theme/web/js/jquery.waypoints.min.js"></script>
	<script src="./resources/theme/web/js/jquery.countup.js"></script>

	<script>
		$('.counter').countUp();
	</script>
	<!-- //stats -->
	<!-- password-script -->

	<!-- //password-script -->

	<!--/ start-smoth-scrolling -->
	<script src="./resources/theme/web/js/move-top.js"></script>
	<script src="./resources/theme/web/js/easing.js"></script>
	<script>
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 900);
			});
		});
	</script>


	<script>
		$(document).ready(function() {
			/*
									var defaults = {
										  containerID: 'toTop', // fading element id
										containerHoverID: 'toTopHover', // fading element hover id
										scrollSpeed: 1200,
										easingType: 'linear' 
									 };
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
		
	</script>

	<!--// end-smoth-scrolling -->
	<!-- /js -->
	<script src="./resources/theme/web/js/bootstrap.js"></script>
	<!-- //js -->
	<!--/Login-->

</body>
</html>