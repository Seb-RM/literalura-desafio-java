package com.aluracursos.literalura_desafio_java;


import com.aluracursos.literalura_desafio_java.ui.MostrarMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LiteraluraConsola implements CommandLineRunner {

    private final ApplicationContext applicationContext;
    private final MostrarMenu mostrarMenu;

    @Autowired
    public LiteraluraConsola(ApplicationContext applicationContext,MostrarMenu mostrarMenu) {
        this.applicationContext = applicationContext;
        this.mostrarMenu = mostrarMenu;
    }

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(LiteraluraConsola.class, args)));
    }

    @Override
    public void run(String... args) {
        mostrarMenu.mostrarMenu();
    }
}
