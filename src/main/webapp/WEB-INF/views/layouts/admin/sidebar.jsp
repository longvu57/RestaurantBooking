<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="dash-nav dash-nav-dark">
            <header>
                <a href="<c:url value="/admin"/>" class="easion-logo">
                <i class="fas fa-store"></i><span>HanuFood</span></a>
            </header>
            <nav class="dash-nav-list">
                <a href="<c:url value="/admin"/>" class="dash-nav-item">
                    <i class="fas fa-clipboard-list"></i> Manage Menu </a>
                <a href="<c:url value="/admin/manage-table"/>" class="dash-nav-item">
                    <i class="fas fa-chair"></i> Manage Table </a>
                <a href="<c:url value="/admin/manage-order"/>" class="dash-nav-item">
                    <i class="fas fa-money-check"></i> Manage Order </a>
                <a href="<c:url value="/admin/send-advertisement"/>" class="dash-nav-item">
                    <i class="far fa-envelope"></i> Send advertisement </a>
                
            </nav>
        </div>