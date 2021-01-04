package com.goodreads.goodreads.repository;

import com.goodreads.goodreads.domain.Comment;
import com.goodreads.goodreads.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
