package com.example.pruebajava.models;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String name;
    private Date last_update;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> nombres;


   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Films filmsName;*/

  /*  @OneToMany(mappedBy = "nombrefilms")
    private Collection<Films> films;

    public Collection<Films> getFilms() {
        return films;
    }

    public void setFilms(Collection<Films> films) {
        this.films = films;
    }  */



    //@OneToMany(mappedBy = "Categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Category> categoryList;

    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                ", last_update=" + last_update +
                '}';
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }


}
