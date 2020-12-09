package com.goodreads.goodreads.bootstrap;

import com.goodreads.goodreads.domain.*;
import com.goodreads.goodreads.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ActorRepository actorRepository;
    private final TvSeriesRepository tvSeriesRepository;

    @Override
    public void run(String... args) throws Exception {
        if(movieRepository.count()==0){
            loadData();
        }

    }

    public void loadData(){

        Actor actor1 =new Actor();
        actor1.setActorName("Bryan Cranston");

        actorRepository.save(actor1);

        TvSeries tvSeries1 = new TvSeries();
        tvSeries1.setTvSeriesName("Breaking Bad");
        tvSeries1.setImdb(9.8);
        tvSeries1.setOver(true);
        tvSeries1.setTvSeriesSeason(9);
        tvSeries1.getTvSeriesActorSet().add(actor1);

        tvSeriesRepository.save(tvSeries1);

        Author author1 = new Author();
        author1.setAuthorName("William Golding");

        authorRepository.save(author1);

        Book book1 = new Book();
        book1.setBookName("Sineklerin Tanrısı");
        book1.setBookPage(260);
        book1.getAuthorSet().add(author1);

        bookRepository.save(book1);

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
