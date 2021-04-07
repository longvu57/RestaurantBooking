<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">More Food?</h1>
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-chart-bar"></i>
                                    </div>
                                    <div class="easion-card-title">Add new food information, please!</div>
                                </div>
                                <c:if test="${error!=null}">
                                    	<div class="alert alert-danger" role="alert">${error}</div>
                                    </c:if>
                                    
                                    <c:if test="${success!=null}">
                                    	<div class="alert alert-success" role="alert">${success}</div>
                                    </c:if>
                                <div class="card-body ">
                                    <form action="admin/add-food" method= 'POST' enctype="multipart/form-data">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="v">Food Name</label>
                                                <input type="text" name="foodName" class="form-control" id="name" placeholder="Enter name of the food" required/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="price">Food Price</label>
                                                <input type="text" name="foodPrice" class="form-control" id="price" placeholder="Enter the food price" required/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Food Description</label>
                                            <input type="text" name = "foodDescription" class="form-control" id="description" placeholder="Give the food a description" required/>
                                        </div>
                                        <div class="form-group">
                                            <label for="subtitle">Subtitle</label>
                                            <input type="text" name="subtitle" class="form-control" id="subtitle" placeholder="Enter the subtitle for each food" required/>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="image">Image</label>
                                                <input type="file" name="imageUrl" class="form-control" id="image" required/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="foodType">Food Type</label>
                                                <select id="foodType" class="form-control" name="foodType" required>
                                                    <option value="0">Breakfast</option>
                                                    <option value="1">Launch</option>
                                                    <option value="2">Dinner</option>                                                    
                                                </select>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Add Now!</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container-fluid">
                    <h1 class="dash-title">Your Menu</h1>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-table"></i>
                                    </div>
                                    <div class="easion-card-title">List of foods</div>
                                </div>
                                <c:if test="${message!=null}">
                                    	<div class="alert alert-success" role="alert">${message}</div>
                                    </c:if>
                                <div class="card-body ">
                                    <table class="table table-hover table-in-card">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Name</th>
                                                <th scope="col">Price</th>
                                                <th scope="col">Description</th>
                                                <th scope="col">Subtitle</th>
                                                <th scope="col">Type</th>
                                                <th scope="col">Image</th>
                                                <th scope="col">Remove</th>
                                                <th scope="col">Edit</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="food" items="${foods}">
                                        	<tr>
                                                <th scope="row">${food.id}</th>
                                                <td>${food.foodName}</td>
                                                <td>${food.foodPrice}</td>
                                                <td>${food.foodDescription}</td>
                                                <td>${food.subtitle}</td>
                                                <c:if test="${food.foodType == 0}">
                                                <td>Breakfast</td>
                                                </c:if>
                                                <c:if test="${food.foodType == 1}">
                                                <td>Lunch</td>
                                                </c:if>
                                                <c:if test="${food.foodType == 2}">
                                                <td>Dinner</td>
                                                </c:if>
                                                <td><img src="<c:url value="${food.imageUrl}"/>" class="img-fluid img-thumbnail"></td>
                                                <td><a href="<c:url value="admin/remove?foodId=${food.id}"/>" class="btn btn-danger" role="button">REMOVE</a></td>
                                                <td><a href="<c:url value="admin/edit?foodId=${food.id}"/>" class="btn btn-primary" role="button">EDIT</a></td>
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