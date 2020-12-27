package com.goodreads.goodreads.service;

import com.goodreads.goodreads.command.BookCommand;
import com.goodreads.goodreads.domain.Book;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    List<Book> getLast4Book();
    List<Book> top5Book();
    Book findById(Long aLong);
    void saveBook(BookCommand bookCommand,MultipartFile multipartFile) throws IOException;
}
