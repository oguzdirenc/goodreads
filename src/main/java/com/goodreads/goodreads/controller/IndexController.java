package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.service.BookService;
import com.goodreads.goodreads.service.MovieService;
import com.goodreads.goodreads.service.TvSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final BookService bookService;
    private final MovieService movieService;
    private final TvSeriesService tvSeriesService;

    @RequestMapping({"/index"})
    public String getBook(Model model){
        model.addAttribute("Books",bookService.getLast4Book());
        model.addAttribute("Movies",movieService.getLast4Movie());
        model.addAttribute("TvSeries",tvSeriesService.getLast4TvSeries());
        return "/index";
    }


}
