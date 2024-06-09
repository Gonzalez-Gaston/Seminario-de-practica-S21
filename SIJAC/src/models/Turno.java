package models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Turno {
    private int id;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private Abogado abogado;

    public Turno(int id, LocalDateTime fechaHora, Cliente cliente, Abogado abogado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.cliente = cliente;
        this.abogado = abogado;
    }

    // Getters y Setters
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

    public void mostrarInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Turno ID: " + id + ", Fecha y Hora: " + fechaHora.format(formatter));
        cliente.mostrarInfo();
        abogado.mostrarInfo();
    }
}
