package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Author;
import com.goodreads.goodreads.repository.AuthorRepository;
import com.goodreads.goodreads.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthorsByName() {
        List<Author> authorListByName = authorRepository.getAuthorsByName();
        return authorListByName;
    }
}
