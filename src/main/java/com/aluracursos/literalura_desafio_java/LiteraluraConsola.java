package com.aluracursos.literalura_desafio_java;


import com.aluracursos.literalura_desafio_java.ui.MostrarMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.aluracursos.literalura_desafio_java.repository")
public class LiteraluraConsola implements CommandLineRunner {

    private final ApplicationContext applicationContext;
    private final MostrarMenu mostrarMenu;
    private static final Logger logger = LoggerFactory.getLogger(LiteraluraConsola.class);

    @Autowired
    public LiteraluraConsola(ApplicationContext applicationContext, MostrarMenu mostrarMenu) {
        this.applicationContext = applicationContext;
        this.mostrarMenu = mostrarMenu;
    }

    public static void main(String[] args) {
        logger.info("Iniciando la aplicación...");

        logger.info("Propiedades de base de datos configuradas.");
        System.exit(SpringApplication.exit(SpringApplication.run(LiteraluraConsola.class, args)));
    }

    @Override
    public void run(String... args) {
        try {
            mostrarMenu.mostrarMenu();
        } catch (Exception e) {
            logger.error("Error al ejecutar el menú: ", e);
        }
    }
}
