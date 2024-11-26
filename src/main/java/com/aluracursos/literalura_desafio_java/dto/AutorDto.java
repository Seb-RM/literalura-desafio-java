package com.aluracursos.literalura_desafio_java.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AutorDto(
        @JsonProperty("name") String nombre,
        @JsonProperty("birth_year") Integer fechaNacimiento,
        @JsonProperty("death_year") Integer fechaFallecimiento
) {}

