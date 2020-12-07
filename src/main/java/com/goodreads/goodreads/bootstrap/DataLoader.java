package com.goodreads.goodreads.bootstrap;

import com.goodreads.goodreads.domain.Comment;
import com.goodreads.goodreads.domain.Movie;
import com.goodreads.goodreads.repository.CommentRepository;
import com.goodreads.goodreads.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.attoparser.trace.MarkupTraceEvent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }


    public void loadData(){

        Movie movie1 = new Movie();
        movie1.setDirector("Onurcan Kurt");
        movie1.setImdb(1l);
        movie1.setMovieName("TENET");

        movieRepository.save(movie1);

        Comment comment1 = new Comment();
        comment1.setDescription("Bok gibi film");
        comment1.setMovie(movie1);
        commentRepository.save(comment1);

        Comment comment2 = new Comment();
        comment2.setDescription("Daha kötüsü yok");
        comment2.setMovie(movie1);
        commentRepository.save(comment2);
    }
}
