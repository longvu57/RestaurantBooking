<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
	<section id="/" class="section-padding">
    <div class="container">
      <div class="row">
        <div class="col-md-12 text-center marb-35">
          <h1 class="header-h">About Hanu Food</h1>
          <p class="header-p">Hanu Food is a restaurant only for students in Hanoi University. We have many discounts for students as well as academic staff in the University.</p>
        </div>
        <div class="col-md-1"></div>
        <div class="col-md-10">
          <div class="col-md-6 col-sm-6">
            <div class="about-info">
              <h2 class="heading">For the best of students life.</h2>
              <p>We’re here to serve you the best food around, whenever you’re looking for a great restaurant in Nam Tu Liem, Hanoi.</p>
              <div class="details-list">
                <ul>
                  <li><i class="fa fa-check"></i>Our diner serves breakfast all day</li>
                  <li><i class="fa fa-check"></i>Wholesome and flavorful dining options for lunch and dinner</li>
                  <li><i class="fa fa-check"></i>Food are healthy and fresh from time to time</li>
                  <li><i class="fa fa-check"></i>Whenever you are, we're readly to deliver food to you</li>
                </ul>
              </div>
            </div>
          </div>
          <div class="col-md-6 col-sm-6">
            <img src="<c:url value="/assets/user/img/res01.jpg"/>" alt="" class="img-responsive">
          </div>
        </div>
        <div class="col-md-1"></div>
      </div>
    </div>
  </section>
</body>