package com.example.pruebajava.services;

import com.example.pruebajava.models.FilmCategory;
import com.example.pruebajava.repositories.FilmCategoryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmCategoryService {

    @Autowired
    FilmCategoryRepositories fr;


    public List<FilmCategory> findFilmCategoryById(Integer idCategoria) {

        return fr.findByFilmCateogoryId(idCategoria);
    }

    public List<FilmCategory> findAll() {

        return fr.findAll();
    }

    public FilmCategory findbyId(Long film_Id) {

        return fr.findById(film_Id).get();
    }

    public FilmCategory findbyIdAndCategory(Integer idCategoria, Long film_Id) {

        return fr.findbyIdAndCategory(idCategoria,film_Id);
    }

}
