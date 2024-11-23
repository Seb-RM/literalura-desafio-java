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
        return libro != null ? libro.toString() : "\n❌ No se encontró el libro con título: " + query;
    }

    public String listarTodosLosLibros() {
        List<Libro> libros = libroService.listarTodosLosLibros();
        if (libros.isEmpty()) {
            return "\n❌ No hay libros disponibles en el catálogo.";
        }
        return "\nListado de todos los libros buscados: " +
                libros.stream()
                        .map(Libro::toString)
                        .collect(Collectors.joining("\n"));
    }

    public String filtrarLibrosPorIdioma(String idioma) {
        List<Libro> librosPorIdioma = libroService.filtrarLibrosPorIdioma(idioma);
        if (librosPorIdioma.isEmpty()) {
            return "\n❌ No se encontraron libros en el idioma: " + idioma;
        }
        return "\nLibros disponibles en " + idioma + ": " +
                librosPorIdioma.stream()
                        .map(Libro::toString)
                        .collect(Collectors.joining("\n"));
    }

    public String listarTodosLosAutores() {
        Set<Autor> autores = libroService.listarAutoresBuscados();
        if (autores.isEmpty()) {
            return "\n❌ No se encontraron autores buscados.";
        }
        return "\n👨‍💼 Lista de autores buscados: " +
                autores.stream()
                        .map(Autor::toString)
                        .collect(Collectors.joining("\n"));
    }

    public String listarAutoresVivos(int anio) {
        List<Autor> autoresVivos = libroService.listarAutoresVivos(anio);

        if (autoresVivos.isEmpty()) {
            return  "⚠️ No se encontraron autores vivos en el año " + anio;
        }

        StringBuilder resultado = new StringBuilder("\n📜 Autores vivos en el año " + anio + ":\n");
        autoresVivos.forEach(autor -> resultado.append(autor).append("\n"));
        return resultado.toString();

    }

}
