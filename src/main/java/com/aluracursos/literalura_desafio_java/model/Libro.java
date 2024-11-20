package com.aluracursos.literalura_desafio_java.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

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

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
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

    public void setAutoresJson(List<Autor> autoresJson) {
        this.autores = autoresJson; // Campo temporal por si es necesario
        this.autor = (autoresJson != null && !autoresJson.isEmpty()) ? autoresJson.get(0) : null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n📖 Título: ").append(titulo).append('\n');
        sb.append("👨‍💼 Autor: ");
        if (autor != null) {
            sb.append(autor).append('\n');
        } else {
            sb.append("Autor desconocido.\n");
        }
        sb.append("📚 Temáticas:\n");
        tematicas.forEach(tematica -> sb.append("    - ").append(tematica).append('\n'));
        sb.append("🌍 Idiomas:\n");
        if (idiomas.isEmpty()) {
            sb.append("    No se especificaron idiomas.\n");
        } else {
            idiomas.forEach(idioma -> sb.append("    - ").append(idioma).append('\n'));
        }
        sb.append("🔢 Número de Descargas: ").append(numeroDescargas).append('\n');
        return sb.toString();
    }

}
