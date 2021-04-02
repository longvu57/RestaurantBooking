<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Orders</h1>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-table"></i>
                                    </div>
                                    <div class="easion-card-title">Customer's orders</div>
                                </div>
                                <div class="card-body ">
                                    <table class="table table-hover table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Address</th>
                                                <th scope="col">Status</th>
                                                <th scope="col">Content</th>
                                                <th scope="col">Total</th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="order" items="${orders}">
                                        	<tr>
                                                <th scope="row">${order.getId()}</th>
                                                <td scope="row">${order.getUserName()}</td>
                                                <td scope="row">${order.getPhone()}</td>
                                                <td scope="row">${order.getAddress()}</td>
                                                <td scope="row">
                                                	<c:if test="${order.getStatus()==0}">Rejected</c:if>
                                                	<c:if test="${order.getStatus()==1}">Accepted</c:if>
                                                	<c:if test="${order.getStatus()==2}">Shipped</c:if>
                                                	<c:if test="${order.getStatus()==3}">Waiting for process</c:if>
                                                </td>
                                                <td scope="row"><a class="page-link" href="<c:url value="/admin/order-details?id=${order.getId()}"/>">Order details</a></td>
                                                <td scope="row">${order.getTotalMoney()}K</td>
                                                <td>
                                                	<form method="POST" action="reject-order">
                                                		<input name="id" type="number" hidden="true" value="${order.getId()}"/>
    													<button type="submit" class="btn btn-danger">REJECT</button>
													</form>
                                                </td>
                                                <td>
                                                	<form method="POST" action="accept-order">
                                                		<input name="id" type="number" hidden="true" value="${order.getId()}}"/>
    													<button type="submit" class="btn btn-primary">ACCEPT</button>
													</form>
                                                </td>
                                                <td>
                                                	<form method="POST" action="ship-order">
                                                		<input name="id" type="number" hidden="true" value="${order.getId()}"/>
    													<button type="submit" class="btn btn-warning">SHIP</button>
													</form>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>