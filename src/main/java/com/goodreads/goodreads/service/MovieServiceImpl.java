package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        return movieList;
    }
}
