package com.aluracursos.literalura_desafio_java.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ElementCollection
    @CollectionTable(name = "libro_tematicas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "tematica")
    private List<String> tematicas = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "libro_idiomas", joinColumns = @JoinColumn(name = "libro_id"))
    @Column(name = "idioma")
    private List<String> idiomas = new ArrayList<>();

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
                Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, autor);
    }
}
