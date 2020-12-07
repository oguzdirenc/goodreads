package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.TvSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvSeriesRepository extends JpaRepository<TvSeries,Long> {
}
