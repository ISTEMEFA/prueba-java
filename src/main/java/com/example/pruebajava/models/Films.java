package com.example.pruebajava.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "film")
public class Films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long film_id;

    private String title;
    private float length;
    private String rating;
    private float rental_rate;
    private float rental_duration;
    private double number;

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="film_category", joinColumns=@JoinColumn(name="film_id"),
            inverseJoinColumns=@JoinColumn(name="category_id"))
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /*    @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "film_id")
        private Category nombrefilms;
    */
    /*@OneToMany(mappedBy = "filmsName", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> nombresCategorias;*/
    public Films() {

    }

    public Long getFilm_id() {
        return film_id;
    }

    public Films(Long film_id, String title, float length, String rating, float rental_rate, float rental_duration, double number) {
        this.film_id = film_id;
        this.title = title;
        this.length = length;
        this.rating = rating;
        this.rental_rate = rental_rate;
        this.rental_duration = rental_duration;
        this.number = number;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public float getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(float rental_rate) {
        this.rental_rate = rental_rate;
    }

    public float getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(float rental_duration) {
        this.rental_duration = rental_duration;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }
}