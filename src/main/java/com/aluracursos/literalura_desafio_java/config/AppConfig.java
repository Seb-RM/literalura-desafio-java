package com.aluracursos.literalura_desafio_java.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Dotenv dotenv() {
        return Dotenv.configure()
                .ignoreIfMissing()
                .load();
    }
}

