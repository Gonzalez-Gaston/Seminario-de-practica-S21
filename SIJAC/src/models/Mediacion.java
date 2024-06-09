package models;

import java.time.LocalDateTime;

public class Mediacion extends Turno {
    private String descripcion;

    public Mediacion(int id, LocalDateTime fechaHora, Cliente cliente, Abogado abogado, String descripcion) {
        super(id, fechaHora, cliente, abogado);
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: Mediación, Descripción: " + descripcion);
    }
}
