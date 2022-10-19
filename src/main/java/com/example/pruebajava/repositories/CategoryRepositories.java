package com.example.pruebajava.repositories;

import com.example.pruebajava.models.Category;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepositories extends JpaRepository<Category,Long> {

 /*   @Query(value= "select name" +
            "from film,category = ?1",
            nativeQuery = true)
    List<Category> findallCategorias(String film);
*/
}
