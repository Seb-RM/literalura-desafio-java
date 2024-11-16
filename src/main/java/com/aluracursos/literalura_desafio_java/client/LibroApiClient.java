package com.aluracursos.literalura_desafio_java.client;


import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

@Component
public class LibroApiClient {

    private static final Dotenv dotenv = Dotenv.configure().load();
    private static final String API_URL = dotenv.get("API_URL");
    private static final HttpClient client = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();;
    private static final Logger logger = Logger.getLogger(LibroApiClient.class.getName());


    public String getLibros(String queryParams) {
        try {

            if (API_URL == null || API_URL.isEmpty()) {
                throw new IllegalStateException("La variable de entorno API_URL no está configurada.");
            }

            URI uri = URI.create(API_URL + queryParams);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Accept", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            HttpHeaders headers = response.headers();
            String body = response.body();

            logger.info("Código de estado: " + statusCode);
            logger.info("Encabezados: " + headers);
            logger.info("Cuerpo de la respuesta: " + body);

            if (statusCode == 200) {
                return body;
            } else {
                throw new RuntimeException("Error al obtener los libros: " + statusCode);
            }
        } catch (Exception e) {
            logger.severe("Error al realizar la solicitud: " + e.getMessage());
            throw new RuntimeException("Error al realizar la solicitud a la API de libros.", e);
        }
    }
}
