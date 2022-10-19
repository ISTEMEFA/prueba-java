package com.example.pruebajava.models;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "film_category")
public class FilmCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long film_id;
    private Long category_id;
    private Date last_update;

    @OneToMany(mappedBy = "nombrefilms", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Films> nombresCategorias;

    public FilmCategory() {
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
