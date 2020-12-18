package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAuthorsByName();
}
