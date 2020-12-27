package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.command.MovieCommand;
import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.service.DirectorService;
import com.goodreads.goodreads.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    private final DirectorService directorService;

    @RequestMapping("/movies")
    public String getMovies(Model model){
    model.addAttribute("Movies",movieService.findAllMovies());
    model.addAttribute("Director",directorService.getDirectorOrderByName());
    model.addAttribute("Top5List",movieService.top5Movie());

    return "/movie/movies";
    }


    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("movie",movieService.findById(Long.valueOf(id)));
        return "/movie/show";
    }

    @RequestMapping("/addMovie")
    public String addMovie(Model model){

        model.addAttribute("movieCommand",new MovieCommand());

        return "/movie/addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute MovieCommand movieCommand,
                           @RequestParam("file")MultipartFile multipartFile) throws IOException {

        movieService.saveMovie(movieCommand,multipartFile);

        return "redirect:/index";
    }


}
