package com.aluracursos.literalura_desafio_java.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDto(
        @JsonProperty("id") int id,
        @JsonProperty("title") String titulo,
        @JsonProperty("authors") List<AutorDto> autores,
        @JsonProperty("subjects") List<String> tematicas,
        @JsonProperty("languages") List<String> idiomas,
        @JsonProperty("download_count") int numeroDescargas
) {
}
