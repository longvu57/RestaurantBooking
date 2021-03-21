<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<section id="banner">
	<div class="bg-color">
		<header id="header">
			<div class="container">
				<div id="mySidenav" class="sidenav">
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
					<a href="<c:url value="/"/>">About</a> 
					<a href="<c:url value="/menu"/>">Menu</a> 
					<a href="<c:url value="/booking"/>">Book a table</a>
					<a href="<c:url value="/cart"/>">Cart</a>
					
					<security:authorize access="!isAuthenticated()">
						<a href="<c:url value="/login"/>">Login</a>
						<a href="<c:url value="/register"/>">Register</a>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<a href="<c:url value="/logout"/>">Log out</a>
					</security:authorize>


				</div>
				<span onclick="openNav()" class="pull-right menu-icon">☰</span>
			</div>
		</header>
		<div class="container">
			<div class="row">
				<div class="inner text-center">
					<h1 class="logo-name">Hanu Food</h1>
					<h2>Enjoy fresh time with students around HANU !</h2>
				</div>
			</div>
		</div>
	</div>
</section>