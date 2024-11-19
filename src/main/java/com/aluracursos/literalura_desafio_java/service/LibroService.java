package com.aluracursos.literalura_desafio_java.service;

import com.aluracursos.literalura_desafio_java.client.LibroApiClient;
import com.aluracursos.literalura_desafio_java.model.Libro;
import com.aluracursos.literalura_desafio_java.model.RespuestaApi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final LibroApiClient apiClient;
    private final ConvierteDatos convierteDatos;
    private final List<Libro> catalogoLibros = new ArrayList<>();

    public LibroService(LibroApiClient apiClient, ConvierteDatos convierteDatos) {
        this.apiClient = apiClient;
        this.convierteDatos = convierteDatos;
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        String queryParams = "?search=" + titulo.replace(" ", "+");
        String jsonResponse = apiClient.getLibros(queryParams);

        RespuestaApi respuestaApi = convierteDatos.convertJsonToApiResponse(jsonResponse);

        if (respuestaApi.getResults().isEmpty()) {
            System.out.println("⚠️ No se encontró ningún libro con ese título.");
            return null;
        }
        Libro libro = respuestaApi.getResults().get(0);

        if (!libro.getIdiomas().isEmpty()) {
            libro.setIdiomas(List.of(libro.getIdiomas().get(0)));
        }

        catalogoLibros.add(libro);
        return libro;
    }

    public List<Libro> listarTodosLosLibros() {
        return new ArrayList<>(catalogoLibros);
    }

    public List<Libro> filtrarLibrosPorIdioma(String idioma) {
        return catalogoLibros.stream()
                .filter(libro -> !libro.getIdiomas().isEmpty() && libro.getIdiomas().get(0).equalsIgnoreCase(idioma))
                .collect(Collectors.toList());
    }


    public List<String> mostrarLibrosPopulares() {
        // Lógica para obtener libros populares
        return List.of("Libro Popular 1", "Libro Popular 2");
    }

    public List<String> buscarLibrosPorAutor(String autor) {
        // Lógica para buscar libros por autor
        return List.of("Libro del Autor 1", "Libro del Autor 2");
    }
}
