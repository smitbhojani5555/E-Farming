<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style type="text/css">
.row-inner {
	margin-right: 50px;
	margin-left: 250px;
}
</style>
<!-- end of main image slider container -->

<!-- /breadcrumb -->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="home.htm">Home</a></li>
	<li class="breadcrumb-item active">simgle product page</li>
</ol>
<!-- //breadcrumb -->
<section class="banner-bottom-w3layouts py-lg-5 py-md-5 py-3">
	<div class="container">
		<div class="inner-sec-w3ls-agileits py-lg-5 py-3">
			<div class="row-inner">
				<!--left-->
				<div class="blog-des blogger">
					<c:forEach var="productimage" items="${singleproductList}">
						<c:set var="productid" scope="application"
							value="${productimage[0]}" />
						<div class="blog-grid-top">
							<div class="b-grid-top">
								<div class="blog_info_left_grid">
									<h3>
										<u><c:out value="${productimage[1]}" /></u>
									</h3>
									<div align="center">
										<img src="singleproductimage.htm?id=${productid}"
											class="img-fluid" alt="">
									</div>
									<table>
										<tr>
											<td><b>Price&nbsp;&nbsp;:&nbsp;&nbsp;</b>
											<td>
										<td>&#x20B9;&nbsp;&nbsp;<c:out value="${productimage[3]}" />
											<td></tr>
										<tr>
											<td><b>Content&nbsp;&nbsp;:&nbsp;&nbsp;</b>
											<td>
											<td><c:out value="${productimage[5]}" />
											<td>
										</tr>
									</table></br>
									<b>Description&nbsp;:</b>&nbsp;&nbsp;
									<p>
										<c:out value="${productimage[2]}" />
									</p>
								</div>
							</div>
					</c:forEach>
				</div>
			</div>
		</div>
</section>