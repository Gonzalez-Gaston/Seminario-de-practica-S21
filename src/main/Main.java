package main;

import database.ConexionDB;
import services.GestionTurnos;
import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Clase principal para ejecutar el sistema de gestión de turnos
 */
public class Main {
    public static void main(String[] args) {
        // Inicializar la base de datos
        ConexionDB.initializeDatabase();

        Scanner scanner = new Scanner(System.in);
        GestionTurnos gestionTurnos = new GestionTurnos();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Solicitar turno");
            System.out.println("2. Mostrar turnos");
            System.out.println("3. Eliminar turno");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    System.out.print("Ingrese apellido del cliente: ");
                    String apellidoCliente = scanner.nextLine();
                    System.out.print("Ingrese email del cliente: ");
                    String emailCliente = scanner.nextLine();
                    System.out.print("Ingrese teléfono del cliente: ");
                    String telefonoCliente = scanner.nextLine();

                    Cliente cliente = new Cliente(0, nombreCliente, apellidoCliente, emailCliente, telefonoCliente);

                    System.out.print("Ingrese nombre del abogado: ");
                    String nombreAbogado = scanner.nextLine();
                    System.out.print("Ingrese apellido del abogado: ");
                    String apellidoAbogado = scanner.nextLine();
                    System.out.print("Ingrese email del abogado: ");
                    String emailAbogado = scanner.nextLine();
                    System.out.print("Ingrese especialidad del abogado: ");
                    String especialidadAbogado = scanner.nextLine();

                    Abogado abogado = new Abogado(0, nombreAbogado, apellidoAbogado, emailAbogado, especialidadAbogado);

                    System.out.print("Ingrese fecha y hora del turno (dd-MM-yyyy HH:mm): ");
                    String fechaHoraString = scanner.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                    LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraString, formatter);

                    System.out.println("Seleccione el tipo de turno:");
                    System.out.println("1. Consulta");
                    System.out.println("2. Mediación");
                    int tipoTurno = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    Turno turno;
                    if (tipoTurno == 1) {
                        turno = new Consulta(0, fechaHora, cliente, abogado);
                    } else {
                        System.out.print("Ingrese descripción del problema: ");
                        String descripcionProblema = scanner.nextLine();
                        turno = new Mediacion(0, fechaHora, cliente, abogado, descripcionProblema);
                    }

                    gestionTurnos.agregarTurno(turno);
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
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }
}
