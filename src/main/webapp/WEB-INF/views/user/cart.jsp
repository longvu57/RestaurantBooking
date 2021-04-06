<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<body>
	<section id="about" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center marb-35">
				<c:if test="${message != null}">
					<h1 class="header-h">${message}</h1>
				</c:if>
				<c:if test="${message == null}">
					<h1 class="header-h">Here are what you have ordered</h1>
					<p class="header-p">
						Process the order and enjoy it!
					</p>
				</c:if>
				</div>
				<c:forEach var="item" items="${sessionScope.cart}">
					<div class="col-md-12" style="padding-bottom: 60px;">
						<div class="item active left">
							<div class="col-md-3 col-sm-3"></div>
							<div class="col-md-3 col-sm-3 details-text">
								<div class="content-holder">
									<h3>${item.value.menu.getFoodName()}</h3>
									<address>
										<strong>Price: ${item.value.menu.getFoodPrice()}</strong> 
										<span class="badge badge-secondary"> K</span> 
										<br> <br> 
										<strong>Quantity: ${item.value.getQuantity()}</strong>
										<span class="badge badge-secondary"></span> 
										<br><br> 
										<strong>Sub total: ${item.value.menu.getFoodPrice() * item.value.getQuantity()}</strong> 
										<span class="badge badge-secondary">K</span>
									</address>
								</div>
							</div>
							<div class="col-md-3 col-sm-3">
								<img src="<c:url value="${item.value.menu.getImageUrl()}"/>" class="img-responsive">
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
                  		<c:if test="${totalPrice > 0}">
                  			<p>Enjoy and wait for the coming food!</p>
                  			<address>
							<strong>Total Price: </strong> 
							<span class="badge badge-secondary">${totalPrice}K</span> 
							<br> <br> 
							<strong>Address: </strong>
							<span class="badge badge-secondary">132,Luong The Vinh, Thanh Xuan, Hanoi</span> 
							<br><br> 
							<strong>Phone Number: </strong> 
							<span class="badge badge-secondary">${user.getPhone()}</span>
							</address>
							<form:form action="placeOrder" method="POST">
								<button type="submit" class="btn btn-imfo btn-read-more">Place order!</button>
							</form:form>
                  		</c:if>  
                  		<c:if test="${totalPrice == null}">
                  			<p>Your order is now empty, grab some foods!</p>
                  		</c:if>                	
                        </div>
				</div>
			</div>
			<div class="col-md-3 col-sm-3"></div>
			</div>			
		</div>
	</section>
</body>
