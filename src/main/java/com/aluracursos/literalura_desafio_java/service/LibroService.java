package com.aluracursos.literalura_desafio_java.service;

import com.aluracursos.literalura_desafio_java.client.LibroApiClient;
import com.aluracursos.literalura_desafio_java.mapper.LibroMapper;
import com.aluracursos.literalura_desafio_java.model.Autor;
import com.aluracursos.literalura_desafio_java.model.Libro;
import com.aluracursos.literalura_desafio_java.model.RespuestaApi;
import com.aluracursos.literalura_desafio_java.repository.AutorRepository;
import com.aluracursos.literalura_desafio_java.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LibroService {

    private final LibroApiClient apiClient;
    private final ConvierteDatos convierteDatos;
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final LibroMapper libroMapper;

    public LibroService(LibroApiClient apiClient, ConvierteDatos convierteDatos,
                        LibroRepository libroRepository, AutorRepository autorRepository,
                        LibroMapper libroMapper) {
        this.apiClient = apiClient;
        this.convierteDatos = convierteDatos;
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.libroMapper = libroMapper;
    }

    public Libro buscarLibros(String query) {
        String queryParams = "?search=" + query.replace(" ", "+");
        String jsonResponse = apiClient.getLibros(queryParams);

        RespuestaApi respuestaApi = convierteDatos.convertJsonToApiResponse(jsonResponse);

        if (respuestaApi.getResults().isEmpty()) {
            System.out.println("⚠️ No se encontraron resultados para: " + query);
            return null;
        }

        Libro libro = libroMapper.toEntity(respuestaApi.getResults().get(0));


        Libro libroExistente = libroRepository.findByTituloIgnoreCase(libro.getTitulo())
                .orElse(null);

        if (libroExistente != null) {
            return libroExistente;
        }

        if (libro.getAutor() != null) {
            Autor autor = libro.getAutor();
            Autor autorExistente = autorRepository.findByNombreIgnoreCase(autor.getNombre())
                    .orElseGet(() -> autorRepository.save(autor));
            libro.setAutor(autorExistente);
        }

        return libroRepository.save(libro);
    }

    public List<Libro> listarTodosLosLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> filtrarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdiomasContaining(idioma);
    }

    public List<Autor> listarAutoresBuscados() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivos(int anio) {
        return autorRepository.findByFechaNacimientoBeforeAndFechaFallecimientoAfter(anio, anio);
    }
}


