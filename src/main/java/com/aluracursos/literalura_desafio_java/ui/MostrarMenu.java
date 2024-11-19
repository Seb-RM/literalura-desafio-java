package com.aluracursos.literalura_desafio_java.ui;

import com.aluracursos.literalura_desafio_java.service.LibroService;

import java.util.Scanner;

public class MostrarMenu {
    private final MenuHandler menuHandler = new MenuHandler();
    private final LibroService libroService = new LibroService();

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

            while (!salir) {
            System.out.println("\nBienvenido al sistema de consulta:");
            System.out.println("1. Buscar libros por título");
            System.out.println("2. Mostrar los libros más populares");
            System.out.println("3. Buscar libros por autor");
            System.out.println("4. Salir");

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
                        menuHandler.mostrarMensaje("¡Gracias por usar el sistema!");
                        menuHandler.cerrarScanner();
                        salir = true;
                    }
                    default -> menuHandler.mostrarMensaje("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número. Intente de nuevo.");
            }
        }
            scanner.close();
    }
}
