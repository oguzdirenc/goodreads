package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAllBooks();
    List<Book> getLast4Book();
}
