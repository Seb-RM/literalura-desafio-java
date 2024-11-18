package com.aluracursos.literalura_desafio_java.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Libro {

    private int id;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("authors")
    private List<Autor> autores;
    @JsonProperty("subjects")
    private List<String> tematicas;
    @JsonProperty("languages")
    private List<String> idiomas;
    @JsonProperty("download_count")
    private List<String> numeroDescargas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public List<String> getTematicas() {
        return tematicas;
    }

    public void setTematicas(List<String> tematicas) {
        this.tematicas = tematicas;
    }

    public List<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<String> idiomas) {
        this.idiomas = idiomas;
    }

    public List<String> getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(List<String> numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }
}
