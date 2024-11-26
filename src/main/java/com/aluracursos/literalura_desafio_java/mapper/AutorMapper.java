package com.aluracursos.literalura_desafio_java.mapper;

import com.aluracursos.literalura_desafio_java.dto.AutorDto;
import com.aluracursos.literalura_desafio_java.model.Autor;

public class AutorMapper {

    public static Autor toEntity(AutorDto dto) {
        if (dto == null) return null;

        Autor autor = new Autor();
        autor.setNombre(dto.nombre());
        autor.setFechaNacimiento(dto.fechaNacimiento());
        autor.setFechaFallecimiento(dto.fechaFallecimiento());

        return autor;
    }

    public static AutorDto toDto(Autor autor) {
        if (autor == null) return null;

        return new AutorDto(
                autor.getNombre(),
                autor.getFechaNacimiento(),
                autor.getFechaFallecimiento()
        );
    }
}
