package com.aluracursos.literalura_desafio_java.service;

import java.util.List;

public class LibroService {

    public List<String> buscarLibrosPorTitulo(String titulo) {
        // Aquí implementas la lógica para buscar libros (puede ser llamada a la API o lógica simulada)
        return List.of("Libro 1", "Libro 2"); // Ejemplo de datos simulados
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
