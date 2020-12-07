package com.goodreads.goodreads.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TvSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tvSeriesId;
    private String tvSeriesName;
    private int tvSeriesSeason;
    private boolean isOver;
    private double imdb;



}
