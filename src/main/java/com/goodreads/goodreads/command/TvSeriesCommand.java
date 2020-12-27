package com.goodreads.goodreads.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TvSeriesCommand {


    private Long tvSeriesId;
    private String tvSeriesName;
    private int tvSeriesSeason;
    private Boolean isOver;
    private double imdb;
    private LocalDate tvSeriesUpdateDate;
    private MultipartFile image;

    private String actorName;
    private String directorName;
    private String commentDescription;
    private String type;



}
