package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.Author;
import com.goodreads.goodreads.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {

    @Query("select distinct x.publisherName from Publisher x")
    List<String> getPublisherNames();

    Publisher findByPublisherName(String name);
}
