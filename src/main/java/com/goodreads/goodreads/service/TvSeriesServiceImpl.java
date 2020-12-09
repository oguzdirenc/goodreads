package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.TvSeries;
import com.goodreads.goodreads.repository.TvSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TvSeriesServiceImpl implements TvSeriesService {

    private final TvSeriesRepository tvSeriesRepository;

    @Override
    public List<TvSeries> findAllTvSeries() {
        List<TvSeries> tvSeriesList = tvSeriesRepository.findAll();
        return tvSeriesList;
    }
}
