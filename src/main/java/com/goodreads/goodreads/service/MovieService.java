package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAllMovies();
}
