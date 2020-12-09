package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.service.TvSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TvSeriesController {

    private final TvSeriesService tvSeriesService;

    @RequestMapping({"/tvSeries/tvSeries","/tvSeries"})
    public String getTvSeries(Model model){
        model.addAttribute("TvSeries",tvSeriesService.findAllTvSeries());
        return "tvSeries/tvSeries";
    }
}
