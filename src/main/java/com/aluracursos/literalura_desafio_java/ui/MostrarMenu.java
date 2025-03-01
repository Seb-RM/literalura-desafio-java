package com.aluracursos.literalura_desafio_java.ui;

import com.aluracursos.literalura_desafio_java.controller.LibroController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MostrarMenu {

    private final MenuHandler menuHandler;
    private final LibroController libroController;
    private static final Logger logger = LoggerFactory.getLogger(MostrarMenu.class);
    private boolean buscando = false;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[0;33m";
    public static final String ANSI_CYAN = "\u001B[0;36m";

    final String RESET_FONDO = "\033[0m";
    final String FONDO_WHITE = "\033[107m";
    final String FONDO_RED = "\033[41m";

    public MostrarMenu(MenuHandler menuHandler, LibroController libroController) {
        this.menuHandler = menuHandler;
        this.libroController = libroController;
    }

    public void mostrarMenu() {
        boolean salir = false;

            while (!salir) {

                mostrarOpcionesMenu();

                try {
                    int opcion = menuHandler.solicitarOpcion();

                    switch (opcion) {
                        case 1 -> manejarBusqueda();
                        case 2 -> manejarListarTodosLosAutores();
                        case 3 -> manejarListarTodosLosLibros();
                        case 4 -> manejarFiltrarLibrosPorIdioma();
                        case 5 -> manejarListarAutoresVivos();
                        case 6 -> {
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
        System.out.println("1️⃣ Buscar libros por título o autor");
        System.out.println("2️⃣ Listar todos los autores buscados");
        System.out.println("3️⃣ Listar todos los libros buscados");
        System.out.println("4️⃣ Filtrar libros buscados por idioma");
        System.out.println("5️⃣ Listar autores vivos en un año deternimado");
        System.out.println("6️⃣ Salir");
        System.out.println(ANSI_CYAN + "---------------------------------------" + ANSI_RESET);
    }

    private void manejarBusqueda() {
        if (buscando) {
            menuHandler.mostrarMensaje("⚠️ Ya se está procesando una búsqueda. Por favor, espere.");
            return;
        }
        buscando = true;
        String query = menuHandler.solicitarQuery();
        logger.info("Buscando libros con la consulta: " + query);
        String resultado = libroController.buscarLibros(query);
        menuHandler.mostrarMensaje("\nResultado: " + resultado);
        buscando = false;
    }

    private void manejarListarTodosLosLibros() {
        menuHandler.mostrarMensaje(libroController.listarTodosLosLibros());
    }

    private void manejarListarTodosLosAutores() {
        menuHandler.mostrarMensaje(libroController.listarTodosLosAutores());
    }

    private void manejarFiltrarLibrosPorIdioma() {
        String idioma = menuHandler.solicitarIdioma();
        menuHandler.mostrarMensaje(libroController.filtrarLibrosPorIdioma(idioma));
    }

    private void manejarListarAutoresVivos() {
        int anio = menuHandler.solicitarAnio();
        String resultado = libroController.listarAutoresVivos(anio);
        menuHandler.mostrarMensaje(resultado);
    }


    private void mostrarMensajeDespedida() {
        System.out.println(ANSI_GREEN + "\n=======================================");
        System.out.println(FONDO_WHITE + "     ¡Gracias por usar el sistema!     " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "=======================================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "\nCerrando la aplicación..." + ANSI_RESET);
    }

}
