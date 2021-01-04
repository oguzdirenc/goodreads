package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.command.MovieCommand;
import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.service.DirectorService;
import com.goodreads.goodreads.service.MovieService;
import com.goodreads.goodreads.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;
    private final DirectorService directorService;
    private final TypeService typeService;

    @RequestMapping("/movies")
    public String getMovies(Model model){
    model.addAttribute("Movies",movieService.findAllMovies());
    model.addAttribute("Director",directorService.getDirectorOrderByName());
    model.addAttribute("Top5List",movieService.top5Movie());
    model.addAttribute("Type",typeService.getAllTypes());

    return "/movie/movies";
    }


    @RequestMapping("/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("movie",movieService.findById(Long.valueOf(id)));
        return "movie/show";
    }

    @RequestMapping("/addMovie")
    public String addMovie(Model model){

        model.addAttribute("movieCommand",new MovieCommand());

        return "/movie/addMovie";
    }

    @PostMapping("/addMovie")
    public String addMovie(@Valid @ModelAttribute MovieCommand movieCommand,
                           BindingResult bindingResult,
                           Model model,
                           @RequestParam("file")MultipartFile multipartFile) throws IOException {

        if(bindingResult.hasErrors()){


            List<String> errors = new ArrayList<>();

            for (Object object : bindingResult.getFieldErrors()){
                FieldError fieldError = (FieldError)object;
                errors.add(fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",errors);

            return "movie/addMovie";
        }else {

            movieService.saveMovie(movieCommand,multipartFile);

            return "redirect:/index";

        }
    }


    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id, Model model){

        movieService.deleteById(Long.valueOf(id));

        return "redirect:/index";
    }


}
