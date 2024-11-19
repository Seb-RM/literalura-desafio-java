package com.aluracursos.literalura_desafio_java;


import com.aluracursos.literalura_desafio_java.ui.MostrarMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraConsola implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraDesafioJavaApplication.class, args);
    }

    @Override
    public void run(String... args) {
        MostrarMenu consola = new MostrarMenu();
        consola.mostrarMenu();
    }

}
