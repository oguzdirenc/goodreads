package com.goodreads.goodreads.bootstrap;

import com.goodreads.goodreads.domain.*;
import com.goodreads.goodreads.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Set;


@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final ActorRepository actorRepository;
    private final TvSeriesRepository tvSeriesRepository;
    private final DirectorRepository directorRepository;

    InputStream i1 = DataLoader.class.getResourceAsStream("/books/sineklerintanrisi.jpg");


    @Override
    public void run(String... args) throws Exception {
        if(movieRepository.count()==0){
            loadData();
        }

    }

    public void loadData() throws IOException {

        byte[] byteImg = i1.readAllBytes();
        String stringImg = Base64.getEncoder().encodeToString(byteImg);

        Director director1 = new Director();
        director1.setDirectorName("Nolan");
        directorRepository.save(director1);

        Director director2 = new Director();
        director2.setDirectorName("Alfonso Gomez-Rejon");
        directorRepository.save(director2);

        Director director3 = new Director();
        director3.setDirectorName("Oguz Direnc Dinc");
        directorRepository.save(director3);

        Actor actor1 =new Actor();
        actor1.setActorName("Bryan Cranston");
        actorRepository.save(actor1);

        Movie movie1 = new Movie();
        movie1.setImdb(9.8);
        movie1.getDirectorSet().add(director1);
        movie1.getActorSet().add(actor1);
        movie1.setMovieName("TENET");

        movieRepository.save(movie1);

        Comment comment1 = new Comment();
        comment1.setDescription("Bok gibi film");
        comment1.setMovie(movie1);
        commentRepository.save(comment1);



        TvSeries tvSeries1 = new TvSeries();
        tvSeries1.setTvSeriesName("Breaking Bad");
        tvSeries1.setImdb(9.8);
        tvSeries1.setOver(true);
        tvSeries1.setTvSeriesSeason(9);
        tvSeries1.getTvSeriesDirectorSet().add(director1);
        tvSeries1.getTvSeriesActorSet().add(actor1);

        tvSeriesRepository.save(tvSeries1);

        Actor actor2 =new Actor();
        actor2.setActorName("Bryan Crston");

        actorRepository.save(actor2);

        TvSeries tvSeries2 = new TvSeries();
        tvSeries2.setTvSeriesName("Brea222ing Bad");
        tvSeries2.setImdb(9.4);
        tvSeries2.setOver(true);
        tvSeries2.setTvSeriesSeason(9);
        tvSeries2.getTvSeriesDirectorSet().add(director2);
        tvSeries2.getTvSeriesActorSet().add(actor2);

        tvSeriesRepository.save(tvSeries2);

        Actor actor3 =new Actor();
        actor3.setActorName("Cranston");

        actorRepository.save(actor3);

        TvSeries tvSeries3 = new TvSeries();
        tvSeries3.setTvSeriesName("Bad");
        tvSeries3.setImdb(9.5);
        tvSeries3.setOver(true);
        tvSeries3.setTvSeriesSeason(9);
        tvSeries3.getTvSeriesDirectorSet().add(director3);
        tvSeries3.getTvSeriesActorSet().add(actor3);

        tvSeriesRepository.save(tvSeries3);

        Actor actor4 =new Actor();
        actor4.setActorName("Bryanston");

        actorRepository.save(actor4);

        TvSeries tvSeries4 = new TvSeries();
        tvSeries4.setTvSeriesName("Breaking");
        tvSeries4.setImdb(9.1);
        tvSeries4.setOver(true);
        tvSeries4.setTvSeriesSeason(9);
        tvSeries4.getTvSeriesDirectorSet().add(director1);
        tvSeries4.getTvSeriesActorSet().add(actor4);

        tvSeriesRepository.save(tvSeries4);

        Actor actor5 =new Actor();
        actor5.setActorName("Bryan Cranstonerger");

        actorRepository.save(actor5);

        TvSeries tvSeries5 = new TvSeries();
        tvSeries5.setTvSeriesName("Brwefeaking Bad");
        tvSeries5.setImdb(9.9);
        tvSeries5.setOver(true);
        tvSeries5.setTvSeriesSeason(9);
        tvSeries5.getTvSeriesDirectorSet().add(director2);
        tvSeries5.getTvSeriesActorSet().add(actor5);

        tvSeriesRepository.save(tvSeries5);

        Author author1 = new Author();
        author1.setAuthorName("William Golding");
        authorRepository.save(author1);

        Author author2 = new Author();
        author2.setAuthorName("Jules Verne");
        authorRepository.save(author2);

        Author author3 = new Author();
        author3.setAuthorName("Oscar Wilde");
        authorRepository.save(author3);

        Author author4 = new Author();
        author4.setAuthorName("Benjamin Graham");
        authorRepository.save(author4);

        Author author5 = new Author();
        author5.setAuthorName("Arthur C. Clarke");
        authorRepository.save(author5);

        Author author6 = new Author();
        author6.setAuthorName("H. G. Wells");
        authorRepository.save(author6);

        Author author7 = new Author();
        author7.setAuthorName("Ray Bradbury");
        authorRepository.save(author7);

        Book book1 = new Book();
        book1.setBookName("Sineklerin Tanrısı");
        book1.setBookPage(260);
        book1.getAuthorSet().add(author1);
        book1.setBookPoint(9.9);

        bookRepository.save(book1);



        Movie movie2 = new Movie();
        movie2.getDirectorSet().add(director1);
        movie2.setImdb(7.3);
        movie1.getActorSet().add(actor1);
        movie2.setMovieName("TENET");

        movieRepository.save(movie2);

        Movie movie3 = new Movie();
        movie3.getDirectorSet().add(director3);
        movie3.setImdb(8.5);
        movie3.getActorSet().add(actor3);
        movie3.setMovieName("TENET");

        movieRepository.save(movie3);

        Movie movie4 = new Movie();
        movie4.getDirectorSet().add(director2);
        movie4.setImdb(9.9);
        movie4.getActorSet().add(actor5);
        movie4.getActorSet().add(actor2);
        movie4.setMovieName("TENEEEEEE");

        movieRepository.save(movie4);

        Movie movie5 = new Movie();
        movie5.getDirectorSet().add(director3);
        movie5.setImdb(8.9);
        movie5.getActorSet().add(actor3);
        movie5.setMovieName("TENTET");

        movieRepository.save(movie5);



        Comment comment2 = new Comment();
        comment2.setDescription("Daha kötüsü yok");
        comment2.setMovie(movie1);
        commentRepository.save(comment2);

        Book book2 = new Book();
        book2.setBookName("Sineklerjhgin Tanrısı");
        book2.setBookPage(260);
        book2.getAuthorSet().add(author1);
        book2.setBookPoint(8.6);

        bookRepository.save(book2);

        Book book3 = new Book();
        book3.setBookName("Sinekleporin Tanrısı");
        book3.setBookPage(260);
        book3.getAuthorSet().add(author1);
        book3.setBookPoint(7.4);
        book3.setThumbnail(stringImg);

        bookRepository.save(book3);

        Book book4 = new Book();
        book4.setBookName("Sineklerin Tanrhhısı");
        book4.setBookPage(260);
        book4.getAuthorSet().add(author1);
        book4.setBookPoint(9.9);

        bookRepository.save(book4);

        Book book5 = new Book();
        book5.setBookName("Sineklerin Tanrısiiiiiiiiı");
        book5.setBookPage(260);
        book5.getAuthorSet().add(author3);
        book5.setBookPoint(3.2);
        book5.setThumbnail(stringImg);

        bookRepository.save(book5);
        i1.close();

        Comment comment3 = new Comment();
        comment3.setDescription("Bok gibiasf film");
        comment3.setBook(book1);

        commentRepository.save(comment3);

        Comment comment4 = new Comment();
        comment4.setDescription("Bok gibi dsafilm");
        comment4.setBook(book2);
        commentRepository.save(comment4);

        Comment comment5 = new Comment();
        comment5.setDescription("Bok gibi film");
        comment5.setBook(book3);
        commentRepository.save(comment5);


    }
}
