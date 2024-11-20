package com.aluracursos.literalura_desafio_java.service;

import com.aluracursos.literalura_desafio_java.client.LibroApiClient;
import com.aluracursos.literalura_desafio_java.model.Autor;
import com.aluracursos.literalura_desafio_java.model.Libro;
import com.aluracursos.literalura_desafio_java.model.RespuestaApi;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LibroService {

    private final LibroApiClient apiClient;
    private final ConvierteDatos convierteDatos;
    private final List<Libro> catalogoLibros = new ArrayList<>();
    private final Set<Autor> autoresBuscados = new HashSet<>();

    public LibroService(LibroApiClient apiClient, ConvierteDatos convierteDatos) {
        this.apiClient = apiClient;
        this.convierteDatos = convierteDatos;
    }

    public Libro buscarLibros(String query) {
        String queryParams = "?search=" + query.replace(" ", "+");
        String jsonResponse = apiClient.getLibros(queryParams);

        RespuestaApi respuestaApi = convierteDatos.convertJsonToApiResponse(jsonResponse);

        if (respuestaApi.getResults().isEmpty()) {
            System.out.println("⚠️ No se encontraron resultados para: " + query);
            return null;
        }

        Libro libro = respuestaApi.getResults().get(0);

        boolean libroExistente = catalogoLibros.stream()
                .anyMatch(l -> l.getTitulo().equals(libro.getTitulo()));

        if (!libroExistente) {
            catalogoLibros.add(libro);
        }
        if (!libro.getIdiomas().isEmpty()) {
            libro.setIdiomas(List.of(libro.getIdiomas().get(0)));
        }

        if (libro.getAutores() != null && !libro.getAutores().isEmpty()) {
            Autor primerAutor = libro.getAutores().get(0);
            if (!autoresBuscados.contains(primerAutor)) {
                autoresBuscados.add(primerAutor);
            }
        }
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

    public Set<Autor> listarAutoresBuscados() {
        return autoresBuscados;
    }

}
