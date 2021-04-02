<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Order details</h1>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-table"></i>
                                    </div>
                                    <div class="easion-card-title">${username}'s items</div>
                                </div>
                                <div class="card-body ">
                                    <table class="table table-hover table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Product name</th>
                                                <th scope="col">Unit price</th>
                                                <th scope="col">Quantity</th>                                                
                                                <th scope="col">Total Price</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:set var="total" value="0"/>
                                        <c:forEach var="item" items="${content}">
                                        	<tr>
                                                <th scope="row">1</th>
                                                <td scope="row">${item.getFoodName()}</td>
                                                <td scope="row">${item.getFoodPrice()}</td>
                                                <td scope="row">${item.getQuantity()}</td>
                                                <td scope="row">${item.getSubTotal()}</td>
                                                <c:set var="total" value="${total+item.getSubTotal()}"/>
                                            </tr>
                                        </c:forEach>                                        	
                                        </tbody>
                                        <thead>
                                            <tr>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                                <th scope="col"></th>
                                                <th scope="col">Total: ${total}K</th>
                                            </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>