package com.goodreads.goodreads.service;

import com.goodreads.goodreads.command.MovieCommand;
import com.goodreads.goodreads.domain.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    List<Movie> findAllMovies();
    List<Movie> getLast4Movie();
    List<Movie> top5Movie();
    Movie findById(Long aLong);
    void saveMovie(MovieCommand movieCommand, MultipartFile multipartFile) throws IOException;
    void deleteById(Long id);
}
