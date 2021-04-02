<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Your Users</h1>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-table"></i>
                                    </div>
                                    <div class="easion-card-title">List of users</div>
                                </div>
                                <c:if test="${message!=null}">
                                    	<div class="alert alert-success" role="alert">${message}</div>
                                    </c:if>
                                <div class="card-body ">
                                    <table class="table table-hover table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">Id</th>
                                                <th scope="col">Username</th>
                                                <th scope="col">Phone</th>
                                                <th scope="col">Email</th>
                                                <th scope="col">Role</th>
                                                <th scope="col">Send email</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="user" items="${users}">
                                        	<tr>
                                                <td>${user.id}</td>
                                                <td>${user.username}</td>
                                                <td>${user.phone}</td>
                                                <td>${user.email}</td>
                                                <td>${user.role}</td>
                                                <c:if test="${user.enabled == 1}">
                                                	<td>Active</td>
                                                </c:if>
                                                <c:if test="${user.enabled == 0}">
                                                	<td>Disabled</td>
                                                </c:if>
                                                <td>
                                                	<form method="POST" action="send-advertisement">
                                                		<input name="email" type="text" hidden="true" value="${user.email}"/>
    													<button type="submit" class="btn btn-warning">Send recruitment</button>
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