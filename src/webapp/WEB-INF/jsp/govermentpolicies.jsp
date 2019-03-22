<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- /breadcrumb -->
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="home.htm">Home</a></li>
	<li class="breadcrumb-item active">Goverment Policies</li>
</ol>
<!-- //breadcrumb -->
<section class="banner-bottom-w3layouts py-lg-5 py-md-5 py-3">
	<div class="container">
		<div class="inner-sec-w3ls-agileits py-lg-5 py-3">

			<div class="row">
				<!--left-->
				<c:forEach var="product" items="${govermentpolicesList}">
					<div class="about-in blog-grid-info text-left">
						<div class="card img">
							<div class="card-body img">


								<div class="blog-des blogger">

									<span class="entry-date"><c:out value="${product[6]}" /></span></br>

									<h3>
										<c:out value="${product[2]}" />
									</h3>
									</br> <b>Description&nbsp;:</b>
									<p>
										<c:out value="${product[1]}" />
									</p>
									</br> </br> </br> </br>


								</div>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>

			<!--//left-->
		</div>

	</div>
	</div>
</section>

