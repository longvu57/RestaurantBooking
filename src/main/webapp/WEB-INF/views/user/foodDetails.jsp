<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<section id="about" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center marb-35">
					<h1 class="header-h">Delicious Journey</h1>
				</div>
				<div class="col-md-12" style="padding-bottom: 60px;">
					<div class="item active left">
						<div class="col-md-6 col-sm-6 left-images">
							<img src="<c:url value="/assets/user/img/${menu.imageUrl}"/>"
								class="img-responsive">
						</div>
						<div class="col-md-6 col-sm-6 details-text">
							<div class="content-holder">
								<h2>${menu.foodName}</h2>
								<p>${menu.foodDescription}</p>
								<address>
									<strong>Price: </strong> ${menu.foodPrice} K <br> <strong>Type:
									</strong>
									<c:if test="${menu.foodType == 0}">
                              	Breakfast
                              </c:if>
									<c:if test="${menu.foodType == 1}">
                              	Lunch
                              </c:if>
									<c:if test="${menu.foodType == 2}">
                              	Dinner
                              </c:if>
								</address>
								<a class="btn btn-imfo btn-read-more" href="buy?id=${menu.id}">Buy
									now !</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
