<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- end of main image slider container -->

<!-- banner-bottom-w3layouts -->
<div class="banner-bottom-w3layouts py-lg-5 py-3">
	<div class="container">
		<div class="inner-sec-w3ls-agileits py-lg-5 py-3">
			<h4 class="sub-tittle text-uppercase text-center">WHAT WE DO</h4>
			<h3 class="tittle text-center mb-lg-5 mb-3">OUR RECENT EVENTS</h3>
			<ul class="grid cs-style-5 row">
				<c:forEach var="product" items="${eventList}">
					<c:set var="eventid" scope="application" value="${product[0]}" />
					<li class="grid-info-img">
					<a href="eventredirect.htm?id=${eventid}">
						<figure>
							<div class="card-body img">
								<img src="eventimage.htm?eventid=${eventid}" alt="" class="img-fluid" height="400px" width="400px">
								<figcaption>
									<b>subject:</b>
									<c:out value="${product[1]}" /> </br>place:<c:out
											value="${product[3]}" />
									
									<input type="hidden" id="userId" name="userId" value="<%=session.getAttribute("userId")%>">
									</figcaption>
							</div>
						</figure>
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
<!--// banner-bottom-w3layouts -->
<!-- /bottom-last -->
<section class="bottom-last">
	<div class="bottom-bg py-5 bs-slider-overlay text-left">
		<div class="container">
			<h3 class="tittle text-left">WHAT WE OFFER</h3>
			<p class="text-white mb-4">
				we provide the farmer to the guidance by the experts.and give the
				solution to the farmer on their farming related questions through
				experts.and also give the knowledge about the products of fertilizer
				and also.organizes forums for the farmers by the experts and company
				also. <a class="hover-2 btn text-uppercase" href="about.htm">Read
					More</a>
		</div>
	</div>

	</div>
</section>
</br>
</section>

