package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.TvSeries;
import com.goodreads.goodreads.repository.TvSeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<TvSeries> getTop5TvSeries() {

        List<TvSeries> topTvSeriesList = new ArrayList<>();
        List<TvSeries> top5TvSeries =tvSeriesRepository.getTop5TvSeries();

        if(top5TvSeries.size()>=5){
            for (int i=0;i<5;i++){
                topTvSeriesList.add(top5TvSeries.get(i));
            }
            return topTvSeriesList;
        }

        return top5TvSeries;
    }

    @Override
    public TvSeries findById(Long id) {

        Optional<TvSeries> tvSeries = tvSeriesRepository.findById(id);

        TvSeries tvSeries1 = tvSeriesRepository.getOne(1L);

        if(tvSeries.isEmpty()==true){
            return tvSeries1;
        }

        TvSeries tvSeries2 = tvSeries.get();
        return tvSeries2;
    }
}
