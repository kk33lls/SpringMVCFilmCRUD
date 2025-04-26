package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;



@Controller
public class FilmController {
	@Autowired
	private FilmDAO filmDAO;
	
	@RequestMapping(path= {"home.do", "/"})
	private String goHome(Model model) {
		return "home";
	}
	@RequestMapping(path="getFilm.do", method=RequestMethod.GET)
	public ModelAndView getFilmId(@RequestParam("filmId") int filmId){
		Film foundFilm = filmDAO.findFilmById(filmId);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("filmDetails");
		mv.addObject("film", foundFilm);
		return mv;
	}
}

