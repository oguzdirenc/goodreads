package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.TvSeries;

import java.util.List;

public interface TvSeriesService {
    List<TvSeries> findAllTvSeries();
    List<TvSeries> getLast4TvSeries();
}
