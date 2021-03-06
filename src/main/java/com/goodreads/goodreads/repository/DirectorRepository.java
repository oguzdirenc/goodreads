package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.Author;
import com.goodreads.goodreads.domain.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Long> {

    @Query("select distinct x.directorName from Director x")
    List<String> getDirectorNames();

    Director findByDirectorName(String name);

    @Query("select x FROM Director x order by x.directorName")
    List<Director> getDirectorByName();
}
