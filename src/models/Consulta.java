package models;

import java.time.LocalDateTime;

/**
 * Clase Consulta que extiende Turno y representa un turno de consulta
 */
public class Consulta extends Turno {

    // Constructor
    public Consulta(int id, LocalDateTime fechaHora, Cliente cliente, Abogado abogado) {
        super(id, fechaHora, cliente, abogado);
    }

    @Override
    public String toString() {
        return "Tipo de Turno: Consulta\n" + super.toString();
    }
}
