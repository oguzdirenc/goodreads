package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<Movie> getLast4Movie() {

        List<Movie> movieList = new ArrayList<>();
        List<Movie> last4Movie = movieRepository.getLast4Movie();

        if (last4Movie.size() >=4){
            for(int i=0;i<=4 ;i++){
                movieList.add(last4Movie.get(i));
            }
            return movieList;
        }

        return last4Movie;
    }


}
