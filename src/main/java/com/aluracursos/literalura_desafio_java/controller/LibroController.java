package com.aluracursos.literalura_desafio_java.controller;

import com.aluracursos.literalura_desafio_java.model.Autor;
import com.aluracursos.literalura_desafio_java.model.Libro;
import com.aluracursos.literalura_desafio_java.service.LibroService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    public String buscarLibros(String query) {
        Libro libro = libroService.buscarLibros(query);
        return libro != null ? libro.toString() : "No se encontró el libro con título: " + query;
    }

    public String listarTodosLosLibros() {
        List<Libro> libros = libroService.listarTodosLosLibros();
        if (libros.isEmpty()) {
            return "❌ No hay libros disponibles en el catálogo.";
        }
        return "Listado de todos los libros:\n" +
                libros.stream()
                        .map(Libro::toString)
                        .collect(Collectors.joining("\n"));
    }

    public String filtrarLibrosPorIdioma(String idioma) {
        List<Libro> librosPorIdioma = libroService.filtrarLibrosPorIdioma(idioma);
        if (librosPorIdioma.isEmpty()) {
            return "❌ No se encontraron libros en el idioma: " + idioma;
        }
        return "Libros disponibles en " + idioma + ":\n" +
                librosPorIdioma.stream()
                        .map(Libro::toString)
                        .collect(Collectors.joining("\n"));
    }

    public String listarTodosLosAutores() {
        Set<Autor> autores = libroService.listarAutoresBuscados();
        if (autores.isEmpty()) {
            return "❌ No se encontraron autores buscados.";
        }
        return "👨‍💼 Lista de autores buscados:\n" +
                autores.stream()
                        .map(Autor::toString)
                        .collect(Collectors.joining("\n"));
    }

}
