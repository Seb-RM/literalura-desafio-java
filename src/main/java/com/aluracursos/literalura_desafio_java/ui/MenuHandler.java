package com.aluracursos.literalura_desafio_java.ui;

import java.util.Scanner;

public class MenuHandler {

    private final Scanner scanner = new Scanner(System.in);

    public int solicitarOpcion() {
        System.out.print("\nSeleccione una opción: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un número válido.");
            return -1;
        }
    }

    public String solicitarTitulo() {
        System.out.print("\nIngrese el título del libro: ");
        return scanner.nextLine();
    }

    public String solicitarAutor() {
        System.out.print("\nIngrese el nombre del autor: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
