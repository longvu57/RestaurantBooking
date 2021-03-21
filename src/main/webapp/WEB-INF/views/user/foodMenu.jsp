<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<section id="menu-list" class="section-padding">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center marb-35">
					<h1 class="header-h">Food menu</h1>
					<p class="header-p">Hanu Food all served food based on
						breakfast, lunch and dinner.</p>
				</div>

				<div class="col-md-12  text-center" id="menu-flters">
					<ul>
						<li><a class="filter active" data-filter=".menu-restaurant">Show
								All</a></li>
						<li><a class="filter" data-filter=".breakfast">Breakfast</a></li>
						<li><a class="filter" data-filter=".lunch">Lunch</a></li>
						<li><a class="filter" data-filter=".dinner">Dinner</a></li>
					</ul>
				</div>

				<div id="menu-wrapper">

					<c:forEach var="menu" items="${menu}">
						<c:if test="${menu.foodType == 0}">
							<div class="breakfast menu-restaurant">
								<span class="clearfix"> <a class="menu-title" href="food?id=${menu.id}"
									data-meal-img="assets/img/restaurant/rib.jpg"><c:out
											value="${menu.foodName}" /></a> <span
									style="left: 166px; right: 44px;" class="menu-line"></span> <span
									class="menu-price"><c:out value="${menu.foodPrice}" />K</span>
								</span><span class="menu-subtitle">${menu.subtitle}</span>
							</div>
						</c:if>

						<c:if test="${menu.foodType == 1}">
							<div class="lunch menu-restaurant">
								<span class="clearfix"> <a class="menu-title" href="food?id=${menu.id}"
									data-meal-img="assets/img/restaurant/rib.jpg"><c:out
											value="${menu.foodName}" /></a> <span
									style="left: 166px; right: 44px;" class="menu-line"></span> <span
									class="menu-price"><c:out value="${menu.foodPrice}" />K</span>
								</span> <span class="menu-subtitle">${menu.subtitle}</span>
							</div>
						</c:if>

						<c:if test="${menu.foodType == 2}">
							<div class="dinner menu-restaurant">
								<span class="clearfix"> <a class="menu-title" href="food?id=${menu.id}"
									data-meal-img="assets/img/restaurant/rib.jpg"><c:out
											value="${menu.foodName}" /> </a> <span
									style="left: 166px; right: 44px;" class="menu-line"></span> <span
									class="menu-price"><c:out value="${menu.foodPrice}" />K</span>
								</span> <span class="menu-subtitle">${menu.subtitle}</span>
							</div>
						</c:if>

					</c:forEach>
				</div>
			</div>
		</div>
	</section>
</body>
