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

        Actor actor2 =new Actor();
        actor2.setActorName("Bryan Crston");

        actorRepository.save(actor2);

        TvSeries tvSeries2 = new TvSeries();
        tvSeries2.setTvSeriesName("Brea222ing Bad");
        tvSeries2.setImdb(9.8);
        tvSeries2.setOver(true);
        tvSeries2.setTvSeriesSeason(9);
        tvSeries2.getTvSeriesActorSet().add(actor2);

        tvSeriesRepository.save(tvSeries2);

        Actor actor3 =new Actor();
        actor3.setActorName("Cranston");

        actorRepository.save(actor3);

        TvSeries tvSeries3 = new TvSeries();
        tvSeries3.setTvSeriesName("Bad");
        tvSeries3.setImdb(9.8);
        tvSeries3.setOver(true);
        tvSeries3.setTvSeriesSeason(9);
        tvSeries3.getTvSeriesActorSet().add(actor3);

        tvSeriesRepository.save(tvSeries3);

        Actor actor4 =new Actor();
        actor4.setActorName("Bryanston");

        actorRepository.save(actor4);

        TvSeries tvSeries4 = new TvSeries();
        tvSeries4.setTvSeriesName("Breaking");
        tvSeries4.setImdb(9.8);
        tvSeries4.setOver(true);
        tvSeries4.setTvSeriesSeason(9);
        tvSeries4.getTvSeriesActorSet().add(actor4);

        tvSeriesRepository.save(tvSeries4);

        Actor actor5 =new Actor();
        actor5.setActorName("Bryan Cranstonerger");

        actorRepository.save(actor5);

        TvSeries tvSeries5 = new TvSeries();
        tvSeries5.setTvSeriesName("Brwefeaking Bad");
        tvSeries5.setImdb(9.8);
        tvSeries5.setOver(true);
        tvSeries5.setTvSeriesSeason(9);
        tvSeries5.getTvSeriesActorSet().add(actor5);

        tvSeriesRepository.save(tvSeries5);

        Author author1 = new Author();
        author1.setAuthorName("William Golding");

        authorRepository.save(author1);

        Book book1 = new Book();
        book1.setBookName("Sineklerin Tanrısı");
        book1.setBookPage(260);
        book1.getAuthorSet().add(author1);
        book1.setBookPoint(9.9);

        bookRepository.save(book1);

        Movie movie1 = new Movie();
        movie1.setDirector("Onurcan Kurt");
        movie1.setImdb(1l);
        movie1.setMovieName("TENET");

        movieRepository.save(movie1);

        Movie movie2 = new Movie();
        movie2.setDirector("Onurcan ");
        movie2.setImdb(1l);
        movie2.setMovieName("TENET");

        movieRepository.save(movie2);

        Movie movie3 = new Movie();
        movie3.setDirector("Kurt");
        movie3.setImdb(1l);
        movie3.setMovieName("TENET");

        movieRepository.save(movie3);

        Movie movie4 = new Movie();
        movie4.setDirector("Onurcan Kurt");
        movie4.setImdb(1l);
        movie4.setMovieName("TENEEEEEE");

        movieRepository.save(movie4);

        Movie movie5 = new Movie();
        movie5.setDirector("Onurcan Kurt");
        movie5.setImdb(1l);
        movie5.setMovieName("TENTET");

        movieRepository.save(movie5);

        Comment comment1 = new Comment();
        comment1.setDescription("Bok gibi film");
        comment1.setMovie(movie1);
        commentRepository.save(comment1);

        Comment comment2 = new Comment();
        comment2.setDescription("Daha kötüsü yok");
        comment2.setMovie(movie1);
        commentRepository.save(comment2);

        Book book2 = new Book();
        book2.setBookName("Sineklerin Tanrısı");
        book2.setBookPage(260);
        book2.getAuthorSet().add(author1);
        book2.setBookPoint(8.6);

        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setBookName("Sineklerin Tanrısı");
        book3.setBookPage(260);
        book3.getAuthorSet().add(author1);
        book3.setBookPoint(7.4);

        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setBookName("Sineklerin Tanrısı");
        book4.setBookPage(260);
        book4.getAuthorSet().add(author1);
        book4.setBookPoint(9.9);

        bookRepository.save(book4);

        Book book5 = new Book();
        book5.setBookName("Sineklerin Tanrısı");
        book5.setBookPage(260);
        book5.getAuthorSet().add(author1);
        book5.setBookPoint(3.2);

        bookRepository.save(book5);
    }
}
