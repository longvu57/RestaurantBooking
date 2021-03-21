<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<section id="about" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center marb-35">
					<h1 class="header-h">Here are what you have ordered</h1>
					<p class="header-p">
						Process the order and enjoy it!
					</p>
				</div>
				<c:set var="total" value="0" />
				<c:forEach var="item" items="${sessionScope.cart}">
					<c:set var="total"
						value="${total + item.menu.foodPrice*item.quantity}" />
					<div class="col-md-12" style="padding-bottom: 60px;">
						<div class="item active left">
							<div class="col-md-3 col-sm-3"></div>
							<div class="col-md-3 col-sm-3 details-text">
								<div class="content-holder">
									<h2>${item.menu.foodName}</h2>
									<address>
										<strong>Price: </strong> 
										<span class="badge badge-secondary">${item.menu.foodPrice} K</span> 
										<br> <br> 
										<strong>Quantity: </strong>
										<span class="badge badge-secondary">${item.quantity}</span> 
										<br><br> 
										<strong>Sub total: </strong> 
										<span class="badge badge-secondary">${item.quantity*item.menu.foodPrice} K</span>
									</address>
								</div>
							</div>
							<div class="col-md-3 col-sm-3">
								<img src="<c:url value="/assets/user/img/${item.menu.imageUrl}"/>" class="img-responsive">
							</div>
							
							<div class="col-md-3 col-sm-3"></div>
						</div>
					</div>
				</c:forEach>
				<div class="col-md-12 text-center marb-35">
					<div class="col-md-3 col-sm-3"></div>
					<div class="col-md-6 col-sm-6 details-text">
						<div class="content-holder">
                  		<h2>Your order</h2>
                  		<c:if test="${total != 0}">
                  		<p>Enjoy and wait for the coming food!</p>                  		
                  			<address>
							<strong>Total Price: </strong> 
							<span class="badge badge-secondary">${total}K</span> 
							<br> <br> 
							<strong>Address: </strong>
							<span class="badge badge-secondary">132,Luong The Vinh, Thanh Xuan, Hanoi</span> 
							<br><br> 
							<strong>Phone Number: </strong> 
							<span class="badge badge-secondary">0978975865</span>
							</address>
							<button type="button" class="btn btn-imfo btn-read-more">Place order!</button>
                  		</c:if>
                  		
                  		<c:if test="${total == 0}">
                  			<address>
							<strong>Your cart is now empty!</strong>
							</address>                  			
                  		</c:if>
                  		
                        </div>
					
				</div>
			</div>
			<div class="col-md-3 col-sm-3"></div>
			</div>			
		</div>
	</section>
</body>
