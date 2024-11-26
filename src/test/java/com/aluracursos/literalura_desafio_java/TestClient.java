package com.aluracursos.literalura_desafio_java;

import com.aluracursos.literalura_desafio_java.client.LibroApiClient;
import com.aluracursos.literalura_desafio_java.model.RespuestaApi;
import com.aluracursos.literalura_desafio_java.service.ConvierteDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestClient {
    public static void main(String[] args) throws JsonProcessingException {
        LibroApiClient client = new LibroApiClient();
        //ConvierteDatos conversor = new ConvierteDatos();

        String queryParams = "";
        // String response = client.getLibros(queryParams);
        String jsonResponse = client.getLibros(queryParams);

//        RespuestaApi respuestaApi = conversor.convertJsonToApiResponse(jsonResponse);
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(respuestaApi);
//
        System.out.println("Respuesta de la API:");
        // System.out.println(response);
        // System.out.println(jsonString);
//        System.out.println(respuestaApi);
    }

}
