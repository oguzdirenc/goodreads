package com.goodreads.goodreads.service;

import com.goodreads.goodreads.command.TvSeriesCommand;
import com.goodreads.goodreads.domain.TvSeries;

import java.util.List;

public interface TvSeriesService {
    List<TvSeries> findAllTvSeries();
    List<TvSeries> getLast4TvSeries();
    List<TvSeries> getTop5TvSeries();
    TvSeries findById(Long aLong);
    void saveTvSeries(TvSeriesCommand tvSeriesCommand);
}
