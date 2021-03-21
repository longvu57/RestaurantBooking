<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Wanna up to date?</h1>
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-title">Update your profile!</div>
                                </div>
                                <div class="card-body ">
                                    <form>
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="v">Username</label>
                                                <input type="text" class="form-control" id="name" placeholder="Enter name of username">
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="price">Password</label>
                                                <input type="text" class="form-control" id="price" placeholder="Enter the password">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="description">Phone</label>
                                            <input type="text" class="form-control" id="description" placeholder="Give us the phone number">
                                        </div>
                                        <div class="form-group">
                                            <label for="subtitle">Email</label>
                                            <input type="text" class="form-control" id="subtitle" placeholder="Enter your email">
                                        </div>
                                        <button type="submit" class="btn btn-primary">Update!</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>