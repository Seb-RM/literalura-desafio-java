package com.aluracursos.literalura_desafio_java.service;

import com.aluracursos.literalura_desafio_java.model.RespuestaApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConvierteDatos {
    private static final Logger logger = LoggerFactory.getLogger(ConvierteDatos.class);

    private final ObjectMapper objectMapper;

    public ConvierteDatos(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public RespuestaApi convertJsonToApiResponse(String json) {
        logger.info("Iniciando conversión de JSON a RespuestaApi. JSON recibido: {}", json);
        try {
            RespuestaApi respuesta = objectMapper.readValue(json, RespuestaApi.class);
            logger.info("Conversión exitosa. Objeto RespuestaApi: {}", respuesta);
            return respuesta;
        } catch (Exception e) {
            logger.error("Error al convertir JSON a RespuestaApi", e);
            throw new RuntimeException("Error al convertir JSON a ApiResponse", e);
        }
    }
}
