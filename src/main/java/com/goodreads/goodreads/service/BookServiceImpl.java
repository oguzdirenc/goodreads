package com.goodreads.goodreads.service;

import com.goodreads.goodreads.command.BookCommand;
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
public class BookServiceImpl implements BookService {


    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final PublisherRepository publisherRepository;
    private final TypeRepository typeRepository;

    @Override
    public List<Book> findAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    @Override
    public List<Book> getLast4Book() {
        List<Book> bookList =new ArrayList<>();
        List<Book> last4Book = bookRepository.getLast4Book();
        if (last4Book.size()>=4){
            for(int i=0;i<4;i++){
                bookList.add(last4Book.get(i));

            }
            return bookList;
        }


        return last4Book;
    }

    @Override
    public List<Book> top5Book() {
        List<Book> bookList = new ArrayList<>();
        List<Book> top5Book = bookRepository.top5Book();
        if(top5Book.size() >=5){
            for(int i=0;i<5;i++){
                bookList.add(top5Book.get(i));
            }
            return bookList;
        }
        return top5Book;
    }

    public Book findById(Long id) {

        Optional<Book> book = bookRepository.findById(id);

        Book book1 = bookRepository.getOne(1L);
        Book book2;

        if(book.isEmpty() ==true){
            return book1;
        }
        book2 =book.get();
        return book2;
    }

    public void saveBook(BookCommand bookCommand,MultipartFile multipartFile) throws IOException {

        Book book =new Book();

        book.setBookName(bookCommand.getBookName());
        book.setBookPage(bookCommand.getBookPage());
        book.setBookPoint(bookCommand.getBookPoint());
        book.setBookUpdateDate(LocalDate.now());

        List<String> authorNames = authorRepository.getTypeNames();
        if(authorNames.contains(bookCommand.getAuthorName())){

            book.getAuthorSet().add(authorRepository.findByAuthorName(bookCommand.getAuthorName()));

        }else {

            Author author = new Author();
            author.setAuthorName(bookCommand.getAuthorName());
            authorRepository.save(author);
            book.getAuthorSet().add(author);
        }



        List<String> typeNames = typeRepository.getTypeNames();
        if(typeNames.contains(bookCommand.getType())){

            book.getTypeSet().add(typeRepository.findByTypeName(bookCommand.getType()));

        }else {

            Type type = new Type();
            type.setTypeName(bookCommand.getType());
            typeRepository.save(type);
            book.getTypeSet().add(type);
        }

        List<String> publisherNames = publisherRepository.getPublisherNames();
        if(publisherNames.contains(bookCommand.getPublisherName())){

            book.getPublisherSet().add(publisherRepository.findByPublisherName(bookCommand.getPublisherName()));

        }else {

            Publisher publisher = new Publisher();
            publisher.setPublisherName(bookCommand.getPublisherName());
            publisherRepository.save(publisher);
            book.getPublisherSet().add(publisher);
        }



        bookCommand.setImage(multipartFile);
        String imageString = Base64.getEncoder().encodeToString(bookCommand.getImage().getBytes());
        book.setThumbnail(imageString);

        bookRepository.save(book);




        Comment comment = new Comment();
        comment.setDescription(bookCommand.getCommentDescription());
        comment.setBook(book);
        commentRepository.save(comment);

    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
