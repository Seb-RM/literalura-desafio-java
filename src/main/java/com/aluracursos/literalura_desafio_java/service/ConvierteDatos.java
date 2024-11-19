package com.aluracursos.literalura_desafio_java.service;

import com.aluracursos.literalura_desafio_java.model.RespuestaApi;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public RespuestaApi convertJsonToApiResponse(String json) {
        try {
            return objectMapper.readValue(json, RespuestaApi.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir JSON a ApiResponse", e);
        }
    }
}
