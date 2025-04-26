package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
@Component
public class FilmDAOJDBCImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;

		try {
			// connect to database
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT language.name, film.* FROM film JOIN language "
					+ "ON language_id = language.id WHERE film.id = ? ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, filmId);
			// execute query
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				film = new Film();
				film.setId(result.getInt("id"));
				film.setTitle(result.getString("title"));
				film.setDescription(result.getString("description"));
				film.setReleaseYear(result.getInt("release_year"));
				film.setLanguageId(result.getInt("language_id"));
				film.setLanguage(result.getString("name"));
				film.setRentalDuration(result.getInt("rental_duration"));
				film.setRentalRate(result.getInt("rental_rate"));
				film.setLength(result.getInt("length"));
				film.setReplacementCost(result.getDouble("replacement_cost"));
				film.setRating(result.getString("rating"));
				film.setSpecialFeatures(result.getString("special_features"));

			}
			result.close();
			conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;

	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		List<Film> filmList = new ArrayList<>();

		try {
			// connect to database
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT language.name, film.* FROM film JOIN language "
					+ "ON language_id = language.id WHERE film.title LIKE ? OR film.description LIKE ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "%" + keyword + "%");
			statement.setString(2, "%" + keyword + "%");
			// execute querySELECT * FROM film WHERE title = %?%
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				
				int id = result.getInt("id");
				String title = result.getString("title");
				String description = result.getString("description");
				int releaseYear = result.getInt("release_year");
				int languageId = result.getInt("language_id");
				String language = result.getString("name");
				int rentalDuration = result.getInt("rental_duration");
				int rentalRate = result.getInt("rental_rate");
				int length = result.getInt("length");
				double replacementCost = result.getDouble("replacement_cost");
				String rating = result.getString("rating");
				String specialFeatures = result.getString("special_features");
				
				Film filmListItem = new Film(id, title, description, releaseYear, languageId, language, rentalDuration, rentalRate, length, replacementCost, rating, specialFeatures);
				filmList.add(filmListItem);
			}
			result.close();
			conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return filmList;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);

			String sql = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, actorId);

			ResultSet result = statement.executeQuery();
			if (result.next()) {
				actor = new Actor();
				actor.setId(result.getInt("id"));
				actor.setFirstName(result.getString("first_name"));
				actor.setLastName(result.getString("last_name"));
			}
			result.close();
			statement.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorsList = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor JOIN film_actor "
					+ "ON actor.id = film_actor.actor_id WHERE film_id = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, filmId);

			ResultSet result = statement.executeQuery();

			while (result.next()) {

				int actorId = result.getInt(1);
				String firstName = result.getString(2);
				String lastName = result.getString(3);

				Actor actorListItem = new Actor(actorId, firstName, lastName);
				actorsList.add(actorListItem);
			}
			result.close();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actorsList;
	}


	@Override
	public Film addFilm(Film newFilm) {
//		Film film = null;
		
		try {
			// Connect to database
			Connection conn = DriverManager.getConnection(URL, user, pass);
			//start transaction
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO film (id, title, description, release_year, language_id, "
					+ "rental_duration, rental_rate, length, repalcement_cost, rating, special_features)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, newFilm.getTitle());
			statement.setString(2, newFilm.getDescription());
			statement.setInt(3, newFilm.getReleaseYear());
			statement.setInt(4, newFilm.getLanguageId());
			statement.setInt(5, newFilm.getRentalDuration());
			statement.setDouble(6, newFilm.getRentalRate());
			statement.setInt(7, newFilm.getLength());
			statement.setDouble(8, newFilm.getReplacementCost());
			statement.setString(9, newFilm.getRating());
			statement.setString(10, newFilm.getSpecialFeatures());
			
			int updateCount = statement.executeUpdate();
			System.out.println(updateCount + " actor record created.");

			if (updateCount == 1) {
				ResultSet keys = statement.getGeneratedKeys();
				int filmId = keys.getInt(1);
				newFilm.setId(filmId);
				keys.close();
			}
			
			conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return newFilm;
	}

	@Override
	public Film updateFilm(Film upddatingFilm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFilm(Film deletingFilm) {
		// TODO Auto-generated method stub
		
	}

}
