<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<body>
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h1 class="header-h">Login</h1>
				</div>

			</div>
			<div class="row msg-row">
				<div class="col-md-4 col-sm-4"></div>
				<div class="col-md-8 col-sm-8">
					<form:form action="login" method="post" role="form"
						modelAttribute="user">
						<div class="col-md-8 col-sm-8 contact-form pad-form">
							<c:if test="${error != null}">
								<div class="alert alert-danger" role="alert">Incorrect
									username or password!</div>
							</c:if>

							<c:if test="${success != null}">
								<div class="alert alert-success" role="alert">Register
									successfully!</div>
							</c:if>
							<div class="form-group">
								<form:input type="text"
									class="form-control label-floating is-empty" path="username"
									id="name" placeholder="Username" data-rule="name"
									data-msg="Please enter a valid name" />
								<div class="validation"></div>
							</div>
						</div>
						<div class="col-md- col-sm-8 contact-form">
							<div class="form-group">
								<form:input type="password"
									class="form-control label-floating is-empty" path="password"
									id="password" placeholder="Password" data-rule="required"
									data-msg="This field is required" />
								<div class="validation"></div>
							</div>
						</div>
						<div class="col-md-12 btnpad">
						<nav class="nav">
							<p>Don't have an account? <span><a class="nav-link active" href="register">Register</a></span></p>
						</nav>
							<div class="contacts-btn-pad">
								<input type="submit" class="contacts-btn" value="Login" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</section>
</body>
