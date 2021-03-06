<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
	<jsp:include page="subPages/styleIncludes.jsp"></jsp:include>
	<link rel="stylesheet" href="css/eventStyle.css">
  </head>
<body>
<header>
	<jsp:include page="subPages/header.jsp"></jsp:include>
</header>
<div class="body">


<div class="card-container">
  <div class="card u-clearfix">
    <div class="card-body">
      <h2 class="card-title">${event.title}</h2>
      <span class="card-description subtle">${event.hook}</span>
      <div class="card-read">   </div>
      <div class="card-read:after">${event.description }</div>
      <br>
      <br>
      <div class="upperContent">
	<p>City: ${event.location.city}</p>
	<br>
	<p>Date: ${event.eventDate}</p>
	<br>
	<p>Time: ${event.eventTime}</p>
	<br>
	<c:if test="${!empty sessionScope.loggedInUser}">
	<h4>RSVP</h4>
	<br>
	<c:choose>
	<c:when test="${notAttending == null}">
	<form class="rsvpButton" action="attend.do" method="POST">
	<button class="attend w3-green" type="submit">Attend</button>
	<input type="hidden" value="${event.id}" name="eventId">
	</form>
	</c:when>
	<c:otherwise>
	<c:if test="${notAttending.creator == false}">
	<form class="rsvpButton" action="unattend.do" method="POST">
	<button class="unattend w3-red" type="submit">Unattend</button>
	<input type="hidden" value="${event.id}" name="eventId">
	</form>
	</c:if>
	</c:otherwise>
	</c:choose>
	
</c:if>
</div>
    </div>
    <img src="${event.imgUrl }" alt="" class="card-media" />
    
    <c:if test="${!empty sessionScope.loggedInUser }">
    <br><br><br>
  <h4>Let's Discuss:</h4>
<form role="form" action="createEventComment.do" method="POST">
  <div class="form-group">
    <textarea class="form-control" rows="3" name="comment" required></textarea>
  </div>
  <input type="hidden" value="${event.id}" name="eventId">
  <button type="submit" class="btn btn-success">Submit</button>
</form>
<br><br>

<p><span class="badge">${commentList.size()}</span> Posts:</p><br>

<div class="row">

<c:forEach var="comment" items="${commentList}">
  <div class="col-sm-2 text-center">
    <img src="${comment.user.userImgUrl}" class="img-circle" height="65" width="65" alt="Avatar">
  </div>
  <div class="col-sm-10">
    <h4><a href="gotoUser.do?userId=${comment.user.id}">${comment.user.username}</a> <small>${comment.createDate}</small></h4>
    <p>${comment.content}</p>
    <br>
  </div>
  </c:forEach>
  </div>
  </c:if>
  
  </div>
  <div class="card-shadow"></div>
</div>


</div>
</body>
</html>
