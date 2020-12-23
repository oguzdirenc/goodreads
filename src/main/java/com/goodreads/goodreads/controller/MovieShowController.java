package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MovieShowController {

    private final MovieService movieService;

    @RequestMapping("/movie/show/{id}")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("movie",movieService.findById(Long.valueOf(id)));
        return "/movie/show";
    }
}
