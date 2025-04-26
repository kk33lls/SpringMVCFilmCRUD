package com.skilldistillery.film.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;
@Component
public class FilmDAOJDBCImpl implements FilmDAO {

	@Override
	public Film findFilmById(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actor findActorById(int actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> findFilmByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film addFilm(Film newFilm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film updateFilm(Film updatingFilm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFilm(Film filmToDelete) {
		// TODO Auto-generated method stub

	}

}
