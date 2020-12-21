package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Director;

import java.util.List;

public interface DirectorService {
    List<Director> getDirectorOrderByName();
}
