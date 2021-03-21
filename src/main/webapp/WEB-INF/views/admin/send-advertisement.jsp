<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<main class="dash-content">
                <div class="container-fluid">
                    <h1 class="dash-title">Wanna send something to the customer?</h1>
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="card easion-card">
                                <div class="card-header">
                                    <div class="easion-card-title">Enter email split by comma ","!</div>
                                </div>
                                <div class="card-body ">
                                    <form:form action="send-advertisement" method="POST" modelAttribute="content">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label for="email">Email</label>
                                                <form:input path="email" type="email" class="form-control" id="email" placeholder="Enter emails of your customers!"/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="price">Subject</label>
                                                <form:input path="subject" type="text" class="form-control" id="price" placeholder="Enter the header of the email!"/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="subtitle">Content</label>
                                            <form:input path = "content" type="text" class="form-control" id="subtitle" placeholder="Enter your content"/>
                                        </div>
                                        <button type="submit" class="btn btn-primary">Send!</button>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>