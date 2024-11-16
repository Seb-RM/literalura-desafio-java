package com.aluracursos.literalura_desafio_java.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntornoVarService{

    private final Dotenv dotenv;

    @Autowired
    public EntornoVarService(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    public void conectarBaseDatos() {
        String dbUrl = dotenv.get("DB_URL");
        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
    }
}