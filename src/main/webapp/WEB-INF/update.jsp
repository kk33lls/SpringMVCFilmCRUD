<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film</title>
</head>
<body>
<h3>Update Film</h3>
<form action="updatedFilm.do" method="POST">
	<p>Title
	<input type="text" name="title" value="${film.title}" placeholder="Film Title"/><br>
	Description
	<input type="text" name="description" value="${film.description}" placeholder="Film Description"/><br>
	Release Year
	<input type="text" name="releaseYear" value="${film.releaseYear}" placeholder="Film Release year"/><br>
	Language Id
	<input type="text" name="languageId" value="${film.languageId}" placeholder="Film Language ID"/><br>
	Language Name
	<input type="text" name="languageName" value="${film.languageName}" placeholder="Film Language Name"/><br>
	Rental Duration
	<input type="text" name="rentalDuration" value="${film.Duration}" placeholder="Film Rental Duration"/><br>
	Rental Rate
	<input type="text" name="rentalRate" value="${film.rentalRate}" placeholder="Film Rental Rate"/><br>
	Length
	<input type="text" name="length" value="${film.length}" placeholder="Film Length"/><br>
	Replacement Cost
	<input type="text" name="replacementCost" value="${film.replacementCost}" placeholder="Film Replacement Cost"/><br>
	Rating
	<input type="text" name="rating" value="${film.rating}" placeholder="Film Rating"/><br>
	Special Features
	<input type="text" name="specialFeatures" value="${film.specialFeatures}" placeholder="Special Features"/><br>
	<input type="submit" value="Submit"></input>
	</form>

</body>
</html>