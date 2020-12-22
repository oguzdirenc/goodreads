package com.goodreads.goodreads.repository;
import com.goodreads.goodreads.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query("SELECT x FROM Movie x order by x.movieId desc")
    List<Movie> getLast4Movie();

    @Query("SELECT x from Movie x order by x.imdb")
    List<Movie> top5Movie();
}
