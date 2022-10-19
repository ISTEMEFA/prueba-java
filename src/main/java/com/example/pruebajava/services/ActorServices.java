package com.example.pruebajava.services;


import com.example.pruebajava.models.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pruebajava.repositories.ActorRepository;

import java.util.List;

@Service
public class ActorServices {

    @Autowired
    ActorRepository ac;

    public List<Actor> findAll(){

       return ac.findAll();
    }
}
