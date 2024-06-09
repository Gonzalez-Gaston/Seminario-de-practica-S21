package services;

import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionTurnos {
    private List<Turno> turnos;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public GestionTurnos() {
        turnos = new ArrayList<>();
        scanner = new Scanner(System.in);
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    }

    public void agregarTurno() {
        System.out.println("Seleccione el tipo de turno:");
        System.out.println("1. Consulta Legal");
        System.out.println("2. Mediación");

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Ingrese nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese apellido del cliente: ");
        String apellidoCliente = scanner.nextLine();
        System.out.print("Ingrese email del cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Ingrese teléfono del cliente: ");
        String telefonoCliente = scanner.nextLine();

        Cliente cliente = new Cliente(generarId(), nombreCliente, apellidoCliente, emailCliente, telefonoCliente);

        System.out.print("Ingrese nombre del abogado: ");
        String nombreAbogado = scanner.nextLine();
        System.out.print("Ingrese apellido del abogado: ");
        String apellidoAbogado = scanner.nextLine();
        System.out.print("Ingrese email del abogado: ");
        String emailAbogado = scanner.nextLine();
        System.out.print("Ingrese especialidad del abogado: ");
        String especialidadAbogado = scanner.nextLine();

        Abogado abogado = new Abogado(generarId(), nombreAbogado, apellidoAbogado, emailAbogado, especialidadAbogado);

        System.out.print("Ingrese fecha y hora del turno (dd-MM-yyyy HH:mm): ");
        String fechaHoraString = scanner.nextLine();
        LocalDateTime fechaHora = LocalDateTime.parse(fechaHoraString, formatter);

        switch (opcion) {
            case 1:
                Turno consulta = new Consulta(generarId(), fechaHora, cliente, abogado);
                agregarTurno(consulta);
                break;
            case 2:
                System.out.print("Ingrese la descripción de la mediación: ");
                String descripcion = scanner.nextLine();
                Turno mediacion = new Mediacion(generarId(), fechaHora, cliente, abogado, descripcion);
                agregarTurno(mediacion);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void agregarTurno(Turno turno) {
        turnos.add(turno);
        System.out.println("Turno agregado.");
    }

    public void mostrarTurnos() {
        if (turnos.isEmpty()) {
            System.out.println("No hay turnos programados.");
        } else {
            for (Turno turno : turnos) {
                turno.mostrarInfo();
                System.out.println();
            }
        }
    }

    public void eliminarTurno(int id) {
        turnos.removeIf(turno -> turno.getId() == id);
        System.out.println("Turno eliminado.");
    }

    private int generarId() {
        // Genera un id único basado en el tamaño de la lista de turnos
        return turnos.size() + 1;
    }

    public void closeScanner() {
        scanner.close();
    }
}
