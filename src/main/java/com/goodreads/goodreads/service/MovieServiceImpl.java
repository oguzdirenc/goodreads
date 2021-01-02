package com.goodreads.goodreads.service;

import com.goodreads.goodreads.command.MovieCommand;
import com.goodreads.goodreads.domain.*;
import com.goodreads.goodreads.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;
    private final TypeRepository typeRepository;
    private final DirectorRepository directorRepository;
    private final ActorRepository actorRepository;

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

    @Override
    public void saveMovie(MovieCommand movieCommand, MultipartFile multipartFile) throws IOException {

        Movie movie = new Movie();

        movie.setMovieName(movieCommand.getMovieName());
        movie.setImdb(movieCommand.getImdb());
        movie.setMovieUpdateDate(LocalDate.now());


        Director director = new Director();
        director.setDirectorName(movieCommand.getDirectorName());
        directorRepository.save(director);
        movie.getDirectorSet().add(director);

        Actor actor = new Actor();
        actor.setActorName(movieCommand.getActorName());
        actorRepository.save(actor);
        movie.getActorSet().add(actor);

        movieCommand.setImage(multipartFile);
        String stringImage = Base64.getEncoder().encodeToString(movieCommand.getImage().getBytes());
        movie.setThumbnail(stringImage);

        movieRepository.save(movie);

        Type type = new Type();
        type.setTypeName(movieCommand.getType());
        type.setMovie(movie);
        typeRepository.save(type);


        Comment comment = new Comment();
        comment.setDescription(movieCommand.getCommentDescription());
        comment.setMovie(movie);
        commentRepository.save(comment);

    }

    @Override
    public void deleteById(Long id) {
        movieRepository.deleteById(id);
    }


}
