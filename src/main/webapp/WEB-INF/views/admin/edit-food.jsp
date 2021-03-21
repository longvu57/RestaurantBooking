<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Update the food?</h1>
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-icon">
                                        <i class="fas fa-chart-bar"></i>
                                    </div>
                                    <div class="easion-card-title">Update food information, please!</div>
                                </div>
                                <div class="card-body ">
                                    <form:form action="edit?id=${menu.getId()}" method= 'POST' modelAttribute="menu">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="v">Food Name</label>
                                                <form:input type="text" path="foodName" class="form-control" id="name" placeholder="Enter name of the food" required="true" value="${menu.getFoodName()}"/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="price">Food Price</label>
                                                <form:input type="text" path="foodPrice" class="form-control" id="price" placeholder="Enter the food price" required="true" value="${menu.getFoodPrice()}"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Food Description</label>
                                            <form:input type="text" path = "foodDescription" class="form-control" id="description" placeholder="Give the food a description" required="true" value="${menu.getFoodDescription()}"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="subtitle">Subtitle</label>
                                            <form:input type="text" path="subtitle" class="form-control" id="subtitle" placeholder="Enter the subtitle for each food" required="true" value="${food.getSubtitle()}"/>
                                        </div>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="image">Image</label>
                                                <form:input type="file" path="imageUrl" class="form-control" id="image" required="true" value="${menu.getImageUrl()}"/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="foodType">Food Type</label>
                                                <form:select id="foodType" class="form-control" path="foodType" required="true" value="${menu.getFoodType()}">
                                                    <option value="0">Breakfast</option>
                                                    <option value="1">Launch</option>
                                                    <option value="2">Dinner</option>                                                    
                                                </form:select>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">UPDATE!</button>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>