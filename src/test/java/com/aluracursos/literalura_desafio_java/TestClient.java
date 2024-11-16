package com.aluracursos.literalura_desafio_java;

import com.aluracursos.literalura_desafio_java.client.LibroApiClient;

public class TestClient {
    public static void main(String[] args) {
        LibroApiClient client = new LibroApiClient();
        String queryParams = "";
        String response = client.getLibros(queryParams);

        System.out.println("Respuesta de la API:");
        System.out.println(response);
    }

}
