package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.Actor;
import com.goodreads.goodreads.domain.TvSeries;
import com.goodreads.goodreads.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {

    @Query("select distinct x.actorName from Actor x")
    List<String> getActorNames();

    Actor findByActorName(String name);

}
