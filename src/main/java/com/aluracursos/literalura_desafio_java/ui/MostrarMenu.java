package com.aluracursos.literalura_desafio_java.ui;

import com.aluracursos.literalura_desafio_java.service.LibroService;

import java.util.Scanner;

public class MostrarMenu {

    private final MenuHandler menuHandler = new MenuHandler();
    private final LibroService libroService = new LibroService();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[0;33m";
    public static final String ANSI_CYAN = "\u001B[0;36m";

    final String RESET_FONDO = "\033[0m";
    final String FONDO_WHITE = "\033[107m";
    final String FONDO_RED = "\033[41m";

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

            while (!salir) {
                System.out.println(ANSI_GREEN + "\n=======================================");
                System.out.println(FONDO_WHITE+" \uD83D\uDCDA Bienvenido al sistema de consulta: " + RESET_FONDO);
                System.out.println(ANSI_GREEN + "=======================================" + ANSI_RESET);
                System.out.println("Seleccione una opción del menú:");
                System.out.println(ANSI_CYAN + "---------------------------------------" + ANSI_RESET);
                System.out.println("1\uFE0F⃣ Buscar libros por título");
                System.out.println("2\uFE0F⃣ Mostrar los libros más populares");
                System.out.println("3\uFE0F⃣ Buscar libros por autor");
                System.out.println("4\uFE0F⃣ Salir");
                System.out.println(ANSI_CYAN + "---------------------------------------" + ANSI_RESET);

                try {
                    int opcion = menuHandler.solicitarOpcion();

                    switch (opcion) {
                        case 1 -> {
                            String titulo = menuHandler.solicitarTitulo();
                            menuHandler.mostrarMensaje("Resultados: " + libroService.buscarLibrosPorTitulo(titulo));
                        }
                        case 2 -> menuHandler.mostrarMensaje("Populares: " + libroService.mostrarLibrosPopulares());
                        case 3 -> {
                            String autor = menuHandler.solicitarAutor();
                            menuHandler.mostrarMensaje("Resultados: " + libroService.buscarLibrosPorAutor(autor));
                        }
                        case 4 -> {
                            System.out.println(ANSI_GREEN + "\n=======================================");
                            menuHandler.mostrarMensaje(FONDO_WHITE +"     ¡Gracias por usar el sistema!     " +ANSI_RESET);
                            System.out.println(ANSI_GREEN+ "=======================================" + ANSI_RESET);
                            System.out.println(ANSI_YELLOW + "\nCerrando la aplicación...");
                            menuHandler.cerrarScanner();
                            salir = true;

                        }
                        default -> menuHandler.mostrarMensaje ("⚠\uFE0F Opción no válida. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
                }
        }
            scanner.close();
    }
}
