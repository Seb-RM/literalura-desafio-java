package com.aluracursos.literalura_desafio_java.ui;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MenuHandler {

    private final Scanner scanner;

    public MenuHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int solicitarOpcion() {
        int opcion;
        do {
            System.out.print("\nSeleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= 6) {
                    return opcion;
                } else {
                    System.out.println("⚠️ Opción fuera de rango. Por favor, ingrese un número entre 1 y 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Por favor, ingrese un número.");
                opcion = -1;
            }
        } while (true);

    }

    public String solicitarQuery() {
        System.out.print("\nIngrese el título del libro o el autor: ");
        return leerEntrada();
    }

    public String solicitarIdioma() {
        System.out.print("\nIngrese el idioma deseado: ");
        return leerEntrada();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        if (scanner != null) {
            scanner.close();
            System.out.println("🛑 Recurso de entrada cerrado.");
        }
    }

    private String leerEntrada() {
        String entrada = scanner.nextLine();
        if (entrada.isBlank()) {
            System.out.println("⚠️ Debe ingresar una respuesta. Intente nuevamente.");
            return leerEntrada();
        }
        return entrada.trim();
    }
}
