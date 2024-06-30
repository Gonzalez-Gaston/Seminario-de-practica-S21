package models;

import java.time.LocalDateTime;

/**
 * Clase Mediacion que extiende Turno y representa un turno de mediación con un atributo adicional descripción del problema
 */
public class Mediacion extends Turno {
    private String descripcionProblema;

    // Constructor
    public Mediacion(int id, LocalDateTime fechaHora, Cliente cliente, Abogado abogado, String descripcionProblema) {
        super(id, fechaHora, cliente, abogado);
        this.descripcionProblema = descripcionProblema;
    }

    // Métodos getter y setter
    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    @Override
    public String toString() {
        return "Tipo de Turno: Mediación\n" + super.toString() + "\nDescripción del Problema: " + descripcionProblema;
    }
}
