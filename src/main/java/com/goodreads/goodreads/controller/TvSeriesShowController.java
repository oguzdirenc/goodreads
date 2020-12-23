package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.service.TvSeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TvSeriesShowController {

    private final TvSeriesService tvSeriesService;

    @RequestMapping("/tvSeries/show/{id}")
    public String showTvSeries(@PathVariable String id, Model model){

        model.addAttribute("tvSeries",tvSeriesService.findById(Long.valueOf(id)));

        return "/tvSeries/show";
    }

}
