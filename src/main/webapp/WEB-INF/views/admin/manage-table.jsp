<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="dash-content">
	<div class="container-fluid">
		<h1 class="dash-title">Your tables</h1>
		<div class="row dash-row">

			<c:forEach var="seat" items="${seats}">
				<c:if test="${seat.getStatus() == 0}">
					<div class="col-xl-4">
						<div class="stats stats-primary">
							<h3 class="stats-title">${seat.getSeatName()}</h3>
							<div class="stats-content">
								<div class="stats-data">
									<div class="stats-number">Empty</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${seat.getStatus() == 1}">
					<div class="col-xl-4">
						<div class="stats stats-success">
							<h3 class="stats-title">${seat.getSeatName()}</h3>
							<div class="stats-content">
								<a href="<c:url value="accept-table?id=${seat.getId()}"/>" type="button" class="btn btn-primary">
									<i class="fas fa-check"></i>
								</a>
								<a href="<c:url value="finish-table?id=${seat.getId()}"/>" type="button" class="btn btn-danger">
									<i class="fas fa-times"></i>
								</a>
								<div class="stats-data">
									<div class="stats-number">Booked</div>
									<div class="stats-change">
										<span class="stats-percentage">${seat.getUsers().get(0).getUsername()}</span>
										<i class="fas fa-arrows-alt-h"></i>
										<span class="stats-percentage">${seat.getUsers().get(0).getPhone()}</span>
									</div>
									<div class="stats-change">
										<span class="stats-percentage">${seat.getDate()}</span>
										<i class="fas fa-arrows-alt-h"></i>
										<span class="stats-percentage">${seat.getTime()}</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${seat.getStatus() == 2}">
					<div class="col-xl-4">
						<div class="stats stats-warning">
							<h3 class="stats-title">${seat.getSeatName()}</h3>
							<div class="stats-content">
								<a href="<c:url value="finish-table?id=${seat.getId()}"/>" type="button" class="btn btn-danger">
									<i class="fas fa-times"></i>
								</a>
								<div class="stats-data">
									<div class="stats-number">Using</div>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>

		</div>
	</div>
</main>