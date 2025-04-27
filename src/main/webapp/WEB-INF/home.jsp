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
	
	<h3>Search Film By Keyword</h3>
	<form action="getByKeyword.do" method="GET">
	<input type="text" name="filmKeyword" placeholder="Enter a Keyword"/>
	<input type="submit" value="Submit"></input>
	</form>  
	
	<h3>Add Film</h3>
	<form action="addFilm.do" method="POST">
	<p>Title
	<input type="text" name="title" placeholder="Film Title"/><br>
	Description
	<input type="text" name="description" placeholder="Film Description"/><br>
	Release Year
	<input type="text" name="releaseYear" placeholder="Film Release year"/><br>
	Language Id
	<input type="text" name="languageId" placeholder="Film Language ID"/><br>
	Language Name
	<input type="text" name="languageName" placeholder="Film Language Name"/><br>
	Rental Duration
	<input type="text" name="rentalDuration" placeholder="Film Rental Duration"/><br>
	Rental Rate
	<input type="text" name="rentalRate" placeholder="Film Rental Rate"/><br>
	Length
	<input type="text" name="length" placeholder="Film Length"/><br>
	Replacement Cost
	<input type="text" name="replacementCost" placeholder="Film Replacement Cost"/><br>
	Rating
	<input type="text" name="rating" placeholder="Film Rating"/><br>
	Special Features
	<input type="text" name="specialFeatures" placeholder="Special Features"/><br>

	<input type="submit" value="Submit"></input>
	</form>
	
	
</body>
</html>