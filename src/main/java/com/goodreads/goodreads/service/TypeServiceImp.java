package com.goodreads.goodreads.service;

import com.goodreads.goodreads.domain.Type;
import com.goodreads.goodreads.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypeServiceImp implements TypeService {

    private final TypeRepository typeRepository;

    public List<Type> getAllTypes(){
        return typeRepository.findAll();
    }
}
