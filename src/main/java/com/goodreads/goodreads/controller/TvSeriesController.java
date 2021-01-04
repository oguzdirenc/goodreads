package com.goodreads.goodreads.controller;

import com.goodreads.goodreads.command.MovieCommand;
import com.goodreads.goodreads.command.TvSeriesCommand;
import com.goodreads.goodreads.domain.TvSeries;
import com.goodreads.goodreads.service.DirectorService;
import com.goodreads.goodreads.service.TvSeriesService;
import com.goodreads.goodreads.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.model.IModel;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tvSeries")
public class TvSeriesController {

    private final TvSeriesService tvSeriesService;
    private final DirectorService directorService;
    private final TypeService typeService;

    @RequestMapping("")
    public String getTvSeries(Model model) {

        model.addAttribute("TvSeries", tvSeriesService.findAllTvSeries());
        model.addAttribute("Director", directorService.getDirectorOrderByName());
        model.addAttribute("Top5List", tvSeriesService.getTop5TvSeries());
        model.addAttribute("Type",typeService.getAllTypes());

        return "tvSeries/tvSeries";
    }

    @RequestMapping("/show/{id}")
    public String showTvSeries(@PathVariable String id, Model model) {

        model.addAttribute("tvSeries", tvSeriesService.findById(Long.valueOf(id)));

        return "/tvSeries/show";
    }

    @RequestMapping("/addTvSeries")
    public String addTvSeries(Model model) {



        model.addAttribute("tvSeriesCommand", new TvSeriesCommand());

        return "/tvSeries/addTvSeries";

    }

    @PostMapping("/addTvSeries")
    public String saveTvSeries(@Valid @ModelAttribute TvSeriesCommand tvSeriesCommand,
                               BindingResult bindingResult,
                               Model model,
                               @RequestParam("file") MultipartFile multipartFile) throws IOException {

        if(bindingResult.hasErrors()){

            List<String> errors = new ArrayList<>();

            for (Object object : bindingResult.getFieldErrors()){
                FieldError fieldError = (FieldError)object;
                errors.add(fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",errors);

            return "tvSeries/addTvSeries";
        }else {

            tvSeriesService.saveTvSeries(tvSeriesCommand, multipartFile);


            return "redirect:/index";

        }



    }

    @RequestMapping("/delete/{id}")
    public String deleteTvSeries(@PathVariable String id) {

        tvSeriesService.deleteById(Long.valueOf(id));

        return "redirect:/index";
    }
}
