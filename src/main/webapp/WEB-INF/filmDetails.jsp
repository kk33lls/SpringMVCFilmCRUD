<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Site</title>
</head>
<body>

	<c:choose>
	<c:when test="${not empty error }">
	<h1>${error}</h1>
	</c:when>
    <c:when test="${! empty film}">
	<h1>${film.title}</h1>
    <p>${film.description}</p>
    
    <form action="getFilm.do" method="GET">
    <h3>Cast:</h3>
    <c:forEach var="actor" items="${actors}">
    <p>${actor.firstName}. ${actor.lastName}</p>
    </c:forEach>
    </form>
    
    <h4>Release year: ${film.releaseYear}</h4>
    <h4>Rental duration: ${film.rentalDuration}</h4>
    <h4>Rental rate: ${film.rentalRate}</h4>
    <h4>Film length: ${film.length}minutes</h4>
    <h4>Replacement cost: $ ${film.replacementCost}</h4>
    <h4>Rating: ${film.rating}</h4>
    <h4>Special features: ${film.specialFeatures}</h4><br><br>
    
    <p>Would you like to remove this film?</p>
	<form action="deleteFilm.do" method="GET">
	<input type="hidden" name="filmId" value="${film.id}">
	<input type="submit" value="Yes" name="Yes"></input>
	<input type="submit" value="No" name="No"></input>
	</form><br><br>
	<p>Would you like to update this film?</p>
	<form action="updateFilm.do" method="GET">
	<input type="hidden" name="filmId" value="${film.id}">
	<input type="submit" value="Update" name="Update"></input>
	</form>
    </c:when>
    
    
    
    <c:otherwise>
      <p>No film found</p>
    </c:otherwise>
  </c:choose>
	
	 
	
</body>
</html>