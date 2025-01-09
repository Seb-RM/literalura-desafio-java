package com.aluracursos.literalura_desafio_java.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    @Column(name = "idioma")
    private String idioma;

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

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
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
            sb.append("\n🌍 Idioma:");
            if (idioma == null || idioma.isEmpty()) {
                sb.append(" No se especificó idioma.\n");
            } else {
                sb.append(idioma).append(" - ").append('\n');
            }
        sb.append("🔢 Número de Descargas: ").append(numeroDescargas);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id == libro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
