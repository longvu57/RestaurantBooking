<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Hanu Food</title>
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
  <meta name="keywords" content="free website templates, free bootstrap themes, free template, free bootstrap, free website template">

  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Satisfy|Bree+Serif|Candal|PT+Sans">
  <link rel="stylesheet" type="text/css" href="<c:url value="/assets/user/css/font-awesome.min.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/assets/user/css/bootstrap.min.css"/>"> 
  <link rel="stylesheet" type="text/css" href="<c:url value="/assets/user/css/style.css"/>">
</head>

<body>

	<%@include file="/WEB-INF/views/layouts/user/header.jsp"%>
	<decorator:body />
	<%@include file="/WEB-INF/views/layouts/user/footer.jsp"%>

  <script src="<c:url value="/assets/user/js/jquery.min.js"/>"></script>
  <script src="<c:url value="/assets/user/js/jquery.easing.min.js"/>"></script>
  <script src="<c:url value="/assets/user/js/bootstrap.min.js"/>"></script>
  <script src="<c:url value="/assets/user/js/custom.js"/>"></script>
  <script src="<c:url value="/assets/user/contactform/contactform.js"/>"></script>

</body>

</html>
