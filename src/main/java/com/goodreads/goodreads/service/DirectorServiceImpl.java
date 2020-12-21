package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Director;
import com.goodreads.goodreads.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;

    @Override
    public List<Director> getDirectorOrderByName() {
        List<Director> directorOrderByName = directorRepository.getDirectorByName();
        return directorOrderByName;
    }
}
