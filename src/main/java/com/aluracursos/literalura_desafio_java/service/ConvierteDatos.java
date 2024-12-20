package com.aluracursos.literalura_desafio_java.service;

import com.aluracursos.literalura_desafio_java.model.RespuestaApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ConvierteDatos {

    private final ObjectMapper objectMapper;

    public ConvierteDatos(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public RespuestaApi convertJsonToApiResponse(String json) {
        try {
            return objectMapper.readValue(json, RespuestaApi.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir JSON a ApiResponse", e);
        }
    }
}
