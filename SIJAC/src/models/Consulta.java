package models;

import java.time.LocalDateTime;

public class Consulta extends Turno {
    public Consulta(int id, LocalDateTime fechaHora, Cliente cliente, Abogado abogado) {
        super(id, fechaHora, cliente, abogado);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Tipo: Consulta Legal");
    }
}
