package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT x from Book x order by x.bookId desc ")
    List<Book> getLast4Book();

    @Query("SELECT x from Book x order by x.bookPoint")
    List<Book> top5Book();
}