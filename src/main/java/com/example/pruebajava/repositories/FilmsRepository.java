package com.example.pruebajava.repositories;

import com.example.pruebajava.models.Films;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmsRepository extends JpaRepository< Films,Long> {




}
