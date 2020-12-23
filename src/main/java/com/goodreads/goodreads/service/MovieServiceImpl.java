package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Book;
import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            for(int i=0;i<4 ;i++){
                movieList.add(last4Movie.get(i));
            }
            return movieList;
        }

        return last4Movie;
    }

    @Override
    public List<Movie> top5Movie() {

        List<Movie> topMovieList =new ArrayList<>();
        List<Movie> top5Movie = movieRepository.top5Movie();

        if (top5Movie.size() >=5){
            for (int i=0;i<5;i++){
                topMovieList.add(top5Movie.get(i));
            }
            return topMovieList;
        }

        return top5Movie;
    }

    @Override
    public Movie findById(Long id) {

        Optional<Movie> movie = movieRepository.findById(id);

        Movie movie1 =movieRepository.getOne(1l);

        if(movie.isEmpty()==true){
            return movie1;
        }
        Movie movie2 = movie.get();
        return movie2;
    }


}
