package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.TvSeries;
import com.goodreads.goodreads.repository.TvSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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

    @Override
    public List<TvSeries> getLast4TvSeries() {

        List<TvSeries> tvSeriesList = new ArrayList<>();
        List<TvSeries> last4TvSeries = tvSeriesRepository.getLast4TvSeries();

        if(last4TvSeries.size() >= 4){
            for(int i = 0; i < 4; i++){
                tvSeriesList.add(last4TvSeries.get(i));

            }
            return tvSeriesList;
        }
        return last4TvSeries;
    }
}
