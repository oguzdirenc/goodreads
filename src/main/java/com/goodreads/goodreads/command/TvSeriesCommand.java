package com.goodreads.goodreads.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TvSeriesCommand {


    private Long tvSeriesId;
    private String tvSeriesName;
    private int tvSeriesSeason;
    private boolean isOver;
    private double imdb;
    private LocalDate tvSeriesUpdateDate;

    private String actorName;
    private String directorName;
    private String commentDescription;
    private String type;



}
