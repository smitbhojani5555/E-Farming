<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ol class="breadcrumb">
	<li class="breadcrumb-item"><a href="home.htm">Home</a></li>
	<li class="breadcrumb-item active">Product</li>
</ol>
<div class="banner-bottom-w3layouts py-lg-5 py-3">
	<div class="container">
		<div class="inner-sec-w3ls-agileits py-lg-5 py-3">
			<h3 class="tittle text-center mb-lg-5 mb-3">OUR PRODUCTS</h3>
			<ul class="grid cs-style-5 row">
				<c:forEach var="product" items="${productList}">
					<c:set var="productid" scope="application" value="${product[0]}" />

					<li>
						<div class="blog-des blogger">
							<dd>
								<img src="productimage.htm?productid=${productid}" alt=""
									height="200px" width="200px">
							</dd>
							<dt>
								 <b><c:out value="${product[1]}" /></b>
							</dt>
							<b>Contntent:</b>
							<c:out value="${product[5]}" />
							</br> <b>Price:</b>&#x20B9;&nbsp;&nbsp;
							<c:out value="${product[3]}" />
							</br>
							<div class="log-in mt-md-3 mt-2">
								<a class="hover-2 btn text-uppercase"
									href="productredirect.htm?productid=${productid}">Read More</a>
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>