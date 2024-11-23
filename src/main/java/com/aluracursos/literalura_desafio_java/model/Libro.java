package com.aluracursos.literalura_desafio_java.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {

    private int id;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("authors")
    private List<Autor> autores;
    private Autor autor;
    @JsonProperty("subjects")
    private List<String> tematicas;
    @JsonProperty("languages")
    private List<String> idiomas;
    @JsonProperty("download_count")
    private int numeroDescargas;

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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
        this.idiomas = idiomas != null ? idiomas : new ArrayList<>();
    }

    public int getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(int numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public List<Autor> getAutores(){
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
        this.autor = (autores != null && !autores.isEmpty()) ? autores.get(0) : null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n📖 Título: ").append(titulo).append('\n');
        sb.append("👨‍💼 Autor: ");
        if (autor != null) {
            sb.append(autor);
        } else {
            sb.append("Autor desconocido.\n");
        }
        sb.append("\n📚 Temáticas:\n");
        tematicas.forEach(tematica -> sb.append("    - ").append(tematica).append('\n'));
        sb.append("🌍 Idiomas:\n");
        if (idiomas.isEmpty()) {
            sb.append("    No se especificaron idiomas.\n");
        } else {
            idiomas.forEach(idioma -> sb.append("    - ").append(idioma).append('\n'));
        }
        sb.append("🔢 Número de Descargas: ").append(numeroDescargas);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo) &&
                Objects.equals(autores, libro.autores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autores);
    }
}
