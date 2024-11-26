package com.aluracursos.literalura_desafio_java.repository;

import com.aluracursos.literalura_desafio_java.model.Autor;
import com.aluracursos.literalura_desafio_java.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    // Buscar libros por título exacto, ignorando mayúsculas/minúsculas
    Optional<Libro> findByTituloIgnoreCase(String titulo);

    // Metodo para buscar libros por título (ignorando mayúsculas y minúsculas)
    List<Libro> findByTituloIgnoreCaseContaining(String titulo);

    // Metodo para buscar libros por autor
    List<Libro> findByAutor_NombreIgnoreCaseContaining(String autorNombre);

    // Metodo para buscar libros por temática
    List<Libro> findByTematicasContaining(String tematica);

    // Metodo para buscar libros por idioma
    List<Libro> findByIdiomasContaining(String idioma);

}
