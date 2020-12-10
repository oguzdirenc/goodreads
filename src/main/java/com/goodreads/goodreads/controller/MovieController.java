package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @RequestMapping({"/movies","/movie/movies"})
    public String getMovies(Model model){
    model.addAttribute("Movies",movieService.findAllMovies());
    for(Movie m:movieService.getLast4Movie()){
        System.out.println(m.getMovieName());
    }
    return "/movie/movies";
    }
}
