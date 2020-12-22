package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.service.DirectorService;
import com.goodreads.goodreads.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final DirectorService directorService;

    @RequestMapping({"/movies","/movie/movies"})
    public String getMovies(Model model){
    model.addAttribute("Movies",movieService.findAllMovies());
    model.addAttribute("Director",directorService.getDirectorOrderByName());
    model.addAttribute("Top5List",movieService.top5Movie());

    return "/movie/movies";
    }
}
