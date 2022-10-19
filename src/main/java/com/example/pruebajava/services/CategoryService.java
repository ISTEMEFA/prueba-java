package com.example.pruebajava.services;

import com.example.pruebajava.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.example.pruebajava.repositories.CategoryRepositories;

import java.util.List;


@Service
public class CategoryService {


    @Autowired
    CategoryRepositories cr;

    public List <Category> findAll() {

    return  cr.findAll();
    }
/*
    public List<Category> findallCategorias(String film) {
   return cr.findallCategorias(film);
    }

    */

}

