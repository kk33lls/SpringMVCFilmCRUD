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

	<h1>Welcome to Film Site</h1>
	<h3>Search Film By Id</h3>
	<form action="getFilm.do" method="GET">
	<input type="text" name="filmId" placeholder="Enter a Film ID"/>
	<input type="submit" value="Submit"></input>
	</form> 
	
	<h3>Add Film</h3>
	<form action="addFilm.do" method="POST">
	<input type="text" name="filmTitle" placeholder="Enter film title"/>
	<input type="submit" value="Submit"></input>
	</form>
	
</body>
</html>