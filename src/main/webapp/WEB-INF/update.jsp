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