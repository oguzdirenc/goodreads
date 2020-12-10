package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.TvSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvSeriesRepository extends JpaRepository<TvSeries,Long> {

    @Query("select x from TvSeries x order by x.tvSeriesId desc")
    List<TvSeries> getLast4TvSeries();
}
