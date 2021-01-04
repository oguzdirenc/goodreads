package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.Author;
import com.goodreads.goodreads.domain.Type;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    @Query("select distinct x.authorName from Author x")
    List<String> getTypeNames();

    Author findByAuthorName(String name);

    @Query("select x from Author x order by x.authorName")
    List<Author> getAuthorsByName();
}
