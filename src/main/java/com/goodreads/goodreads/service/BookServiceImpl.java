package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Book;
import com.goodreads.goodreads.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
}
