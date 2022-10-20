package com.example.pruebajava.services;

import com.example.pruebajava.models.Films;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.example.pruebajava.repositories.FilmsRepository;

import java.util.List;


@Service
public class FilmsService {

    @Autowired
    FilmsRepository fr;


    public List<Films> findAll(){

        return fr.findAll();
    }
    public List<Films> findFilmBytitle(String filmUpper) {

        return fr.findBytitle(filmUpper);
    }

    }

