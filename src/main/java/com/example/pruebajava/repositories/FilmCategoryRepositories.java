package com.example.pruebajava.repositories;

import com.example.pruebajava.models.Category;
import com.example.pruebajava.models.FilmCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmCategoryRepositories extends JpaRepository<FilmCategory,Long> {

    @Query(value="SELECT film_id,category_id FROM film_category WHERE category_id=?1", nativeQuery=true)
     List<FilmCategory> findByFilmCateogoryId(Integer idCategoria);

    @Query(value="SELECT film_id,category_id FROM film_category WHERE category_id=?1 AND film_id=?2", nativeQuery=true)
    FilmCategory findbyIdAndCategory(Integer idCategoria, Long film_Id);


}
