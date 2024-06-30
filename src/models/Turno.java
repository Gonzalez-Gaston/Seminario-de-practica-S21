package models;

import java.time.LocalDateTime;

/**
 * Clase Turno que representa un turno genérico
 */
public class Turno {
    protected int id;
    protected LocalDateTime fechaHora;
    protected Cliente cliente;
    protected Abogado abogado;

    // Constructor
    public Turno(int id, LocalDateTime fechaHora, Cliente cliente, Abogado abogado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.abogado = abogado;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Abogado getAbogado() {
        return abogado;
    }

    public void setAbogado(Abogado abogado) {
        this.abogado = abogado;
    }

    @Override
    public String toString() {
        return "Turno ID: " + id + "\nFecha y Hora: " + fechaHora + "\nCliente: " + cliente + "\nAbogado: " + abogado;
    }
}
