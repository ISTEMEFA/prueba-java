package com.example.pruebajava.models;

public class Parametros {

    private String Categoria;
    private String Titulo;

    public Parametros() {
    }


    public Parametros(String categoria, String titulo) {
        Categoria = categoria;
        Titulo = titulo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
}
