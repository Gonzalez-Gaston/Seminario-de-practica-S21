package main;

import models.*;
import services.GestionTurnos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestionTurnos gestionTurnos = new GestionTurnos();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        boolean exit = false;

        while (!exit) {
            System.out.println("Sistema de Gestión de Turnos - Consultora SIJAC");
            System.out.println("1. Solicitar Turno");
            System.out.println("2. Mostrar Turnos");
            System.out.println("3. Eliminar Turno");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    gestionTurnos.agregarTurno();
                    break;

                case 2:
                    gestionTurnos.mostrarTurnos();
                    break;

                case 3:
                    System.out.print("Ingrese ID del turno a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestionTurnos.eliminarTurno(idEliminar);
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        gestionTurnos.closeScanner();
        scanner.close();
    }
}
