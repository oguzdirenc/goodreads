package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Book;
import com.goodreads.goodreads.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }
}
