<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="dash-toolbar">
	<a href="#!" class="menu-toggle"> <i class="fas fa-bars"></i>
	</a> <a href="#!" class="searchbox-toggle"> <i class="fas fa-search"></i>
	</a>
	<div class="tools">
		<div class="dropdown tools-item">
			<a href="#" class="" id="dropdownMenu1" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> <i
				class="fas fa-user"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right"
				aria-labelledby="dropdownMenu1">
				<a class="dropdown-item" href="<c:url value = "/admin/profile"/>">Profile</a> <a
					class="dropdown-item" href="<c:url value = "/logout"/>">Logout</a>
			</div>
		</div>
	</div>
</header>