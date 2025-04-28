package com.skilldistillery.film.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	@Autowired
	private FilmDAO filmDAO;

	@RequestMapping(path = { "home.do", "/" })
	private String goHome(Model model) {
		return "home";
	}

	@RequestMapping(path = "getFilm.do", method = RequestMethod.GET)
	public ModelAndView getFilmId(@RequestParam("filmId") int filmId) {
		Film foundFilm = filmDAO.findFilmById(filmId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("filmDetails");
		mv.addObject("film", foundFilm);
		
		List<Actor> foundActors = new ArrayList<>();
		foundActors = filmDAO.findActorsByFilmId(filmId);
		mv.addObject("actors", foundActors);
//			for (Actor actors : foundActor) {
//				mv.addObject("actor", actors);
//			}
		return mv;
	}

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView getAddFilm(Film filmToAdd) {
		Film createFilm = filmDAO.addFilm(filmToAdd);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("filmDetails");
		mv.addObject("film", filmToAdd);
		if (createFilm == null) {
			mv.addObject("Error", "Unable to add Film");
		}
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", method = RequestMethod.GET)
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId) {
		Film filmToDelete = new Film();
		filmToDelete.setId(filmId);
		filmDAO.deleteFilm(filmToDelete);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(path = "updateFilm.do", method = RequestMethod.GET)
	public ModelAndView updateFilm(@RequestParam("filmId") int filmToUpdate) {
		Film updateFilm = filmDAO.findFilmById(filmToUpdate);
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", updateFilm);
		mv.setViewName("update");
		return mv;
	}

	@RequestMapping(path = "updatedFilm.do", method = RequestMethod.POST)
	public ModelAndView updatingFilm(Film updatedFilm) {
		Film createFilm = filmDAO.updateFilm(updatedFilm);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("film", updatedFilm);
		if (createFilm == null) {
			mv.addObject("Error", "Unable to add Film");
		}
		return mv;
	}

	@RequestMapping(path = "getByKeyword.do", method = RequestMethod.GET)
	public ModelAndView searchFilmByKeyWord(@RequestParam("filmKeyword") String keyword) {
		List<Film> foundKeyword = new ArrayList<>();
//		Film films = new Film();
		ModelAndView mv = new ModelAndView();
		foundKeyword = filmDAO.findFilmByKeyword(keyword);

		if (foundKeyword == null) {
			mv.addObject("Error", "Unable to find film");
		} else {
				mv.addObject("film", foundKeyword);
			}
		mv.setViewName("keywordFilmDetails");
		return mv;
	}
//	@RequestMapping(path = "findActor.do", method = RequestMethod.GET)
//	public ModelAndView searchFilmByKeyWord(int filmId) {
//		List<Actor> foundActor = new ArrayList<>();
//		ModelAndView mv = new ModelAndView();
//		foundActor = filmDAO.findActorsByFilmId(filmId);
//		
//			for (Actor actors : foundActor) {
//				mv.addObject("actor", actors);
//			}
//		mv.setViewName("filmDetails");
//		return mv;
//	}
}
