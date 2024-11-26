package com.aluracursos.literalura_desafio_java.repository;

import com.aluracursos.literalura_desafio_java.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Metodo para buscar un autor por nombre exacto (ignora mayúsculas/minúsculas)
    Optional<Autor> findByNombreIgnoreCase(String nombre);

    // Metodo para buscar autores nacidos en un rango de años
    List<Autor> findByFechaNacimientoBetween(Integer inicio, Integer fin);

    // Metodo para buscar autores por año de nacimiento
    List<Autor> findByFechaNacimiento(Integer fechaNacimiento);

    // Metodo para buscar autores por año de fallecimiento
    List<Autor> findByFechaFallecimiento(Integer fechaFallecimiento);
}
