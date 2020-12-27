package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.command.MovieCommand;
import com.goodreads.goodreads.command.TvSeriesCommand;
import com.goodreads.goodreads.domain.TvSeries;
import com.goodreads.goodreads.service.DirectorService;
import com.goodreads.goodreads.service.TvSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.model.IModel;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tvSeries")
public class TvSeriesController {

    private final TvSeriesService tvSeriesService;
    private final DirectorService directorService;

    @RequestMapping("")
    public String getTvSeries(Model model){

        model.addAttribute("TvSeries",tvSeriesService.findAllTvSeries());
        model.addAttribute("Director",directorService.getDirectorOrderByName());
        model.addAttribute("Top5List",tvSeriesService.getTop5TvSeries());

        return "tvSeries/tvSeries";
    }

    @RequestMapping("/show/{id}")
    public String showTvSeries(@PathVariable String id, Model model){

        model.addAttribute("tvSeries",tvSeriesService.findById(Long.valueOf(id)));

        return "/tvSeries/show";
    }

    @RequestMapping("/addTvSeries")
    public String addTvSeries(Model model){

        model.addAttribute("tvSeriesCommand",new TvSeriesCommand());

        return "/tvSeries/addTvSeries";

    }

    @PostMapping("/addTvSeries")
    public String saveTvSeries(@ModelAttribute TvSeriesCommand tvSeriesCommand,
                               @RequestParam("file") MultipartFile multipartFile) throws IOException {


        tvSeriesService.saveTvSeries(tvSeriesCommand, multipartFile);


        return "redirect:/index";

    }
}
