package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type,Long> {
    @Query("select distinct x.typeName from Type x")
    List<String> getTypeNames();

    Type findByTypeName(String name);

    @Query("select x from Type x order by x.typeName")
    List<Type> getTypesByName();

}

