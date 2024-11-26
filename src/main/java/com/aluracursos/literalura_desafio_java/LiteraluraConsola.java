package com.aluracursos.literalura_desafio_java;


import com.aluracursos.literalura_desafio_java.ui.MostrarMenu;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.aluracursos.literalura_desafio_java.repository")
public class LiteraluraConsola implements CommandLineRunner {

    private final ApplicationContext applicationContext;
    private final MostrarMenu mostrarMenu;

    @Autowired
    public LiteraluraConsola(ApplicationContext applicationContext,MostrarMenu mostrarMenu) {
        this.applicationContext = applicationContext;
        this.mostrarMenu = mostrarMenu;
    }
    @Autowired
    private Environment env;
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        System.exit(SpringApplication.exit(SpringApplication.run(LiteraluraConsola.class, args)));
    }

    @Override
    public void run(String... args) {
        mostrarMenu.mostrarMenu();
    }
}
