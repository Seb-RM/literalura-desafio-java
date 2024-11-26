package com.aluracursos.literalura_desafio_java.mapper;

import com.aluracursos.literalura_desafio_java.dto.AutorDto;
import com.aluracursos.literalura_desafio_java.dto.LibroDto;
import com.aluracursos.literalura_desafio_java.model.Libro;

import java.util.List;

public class LibroMapper {

    public static Libro toEntity(LibroDto dto) {
        if (dto == null) return null;

        Libro libro = new Libro();
        libro.setId(dto.id());
        libro.setTitulo(dto.titulo());
        libro.setTematicas(dto.tematicas());
        libro.setIdiomas(dto.idiomas());
        libro.setNumeroDescargas(dto.numeroDescargas());

        // Extrae el primer autor de la lista, si existe.
        if (dto.autores() != null && !dto.autores().isEmpty()) {
            libro.setAutor(AutorMapper.toEntity(dto.autores().get(0)));  // Usa solo el primer autor.
        } else {
            libro.setAutor(null); // Si no hay autores, se establece como null.
        }

        return libro;
    }

    public static LibroDto toDTO(Libro libro) {
        if (libro == null) return null;

        // Convierte el autor único de la entidad a una lista para el DTO.
        List<AutorDto> autores = libro.getAutor() != null
                ? List.of(AutorMapper.toDto(libro.getAutor()))
                : List.of();

        return new LibroDto(
                libro.getId(),
                libro.getTitulo(),
                autores, // Devuelve una lista de autores para el DTO.
                libro.getTematicas(),
                libro.getIdiomas(),
                libro.getNumeroDescargas()
        );
    }
}