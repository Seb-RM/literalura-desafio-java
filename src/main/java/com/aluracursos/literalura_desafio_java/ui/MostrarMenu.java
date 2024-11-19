package com.aluracursos.literalura_desafio_java.ui;

import com.aluracursos.literalura_desafio_java.service.LibroService;
import org.springframework.stereotype.Component;

@Component
public class MostrarMenu {

    private final MenuHandler menuHandler;
    private final LibroService libroService;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[0;33m";
    public static final String ANSI_CYAN = "\u001B[0;36m";

    final String RESET_FONDO = "\033[0m";
    final String FONDO_WHITE = "\033[107m";
    final String FONDO_RED = "\033[41m";

    public MostrarMenu(MenuHandler menuHandler, LibroService libroService) {
        this.menuHandler = menuHandler;
        this.libroService = libroService;
    }

    public void mostrarMenu() {
        boolean salir = false;

            while (!salir) {

                mostrarOpcionesMenu();

                try {
                    int opcion = menuHandler.solicitarOpcion();

                    switch (opcion) {
                        case 1 -> manejarBusquedaPorTitulo();
                        case 2 -> manejarLibrosPopulares();
                        case 3 -> manejarBusquedaPorAutor();
                        case 4 -> {
                            menuHandler.cerrarScanner();
                            mostrarMensajeDespedida();
                            salir = true;
                        }
                        default -> menuHandler.mostrarMensaje ("⚠\uFE0F Opción no válida. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                }
        }
    }

    private void mostrarOpcionesMenu() {
        System.out.println(ANSI_GREEN + "\n=======================================");
        System.out.println(FONDO_WHITE + " 📚 Bienvenido al sistema de consulta: " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "=======================================" + ANSI_RESET);
        System.out.println("Seleccione una opción del menú:");
        System.out.println(ANSI_CYAN + "---------------------------------------" + ANSI_RESET);
        System.out.println("1️⃣ Buscar libros por título");
        System.out.println("2️⃣ Mostrar los libros más populares");
        System.out.println("3️⃣ Buscar libros por autor");
        System.out.println("4️⃣ Salir");
        System.out.println(ANSI_CYAN + "---------------------------------------" + ANSI_RESET);
    }

    private void manejarBusquedaPorTitulo() {
        String titulo = menuHandler.solicitarTitulo();
        menuHandler.mostrarMensaje("\nResultados: " + libroService.buscarLibrosPorTitulo(titulo));
    }

    private void manejarLibrosPopulares() {
        menuHandler.mostrarMensaje("\nPopulares: " + libroService.mostrarLibrosPopulares());
    }

    private void manejarBusquedaPorAutor() {
        String autor = menuHandler.solicitarAutor();
        menuHandler.mostrarMensaje("\nResultados: " + libroService.buscarLibrosPorAutor(autor));
    }

    private void mostrarMensajeDespedida() {
        System.out.println(ANSI_GREEN + "\n=======================================");
        System.out.println(FONDO_WHITE + "     ¡Gracias por usar el sistema!     " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "=======================================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\nCerrando la aplicación..." + ANSI_RESET);
    }

}
