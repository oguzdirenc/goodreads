package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.domain.TvSeries;
import com.goodreads.goodreads.service.DirectorService;
import com.goodreads.goodreads.service.TvSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TvSeriesController {

    private final TvSeriesService tvSeriesService;
    private final DirectorService directorService;

    @RequestMapping({"/tvSeries/tvSeries","/tvSeries"})
    public String getTvSeries(Model model){

        model.addAttribute("TvSeries",tvSeriesService.findAllTvSeries());
        model.addAttribute("Director",directorService.getDirectorOrderByName());
        model.addAttribute("Top5List",tvSeriesService.getTop5TvSeries());

        return "tvSeries/tvSeries";
    }
}
