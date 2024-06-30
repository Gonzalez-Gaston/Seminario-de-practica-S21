package models;

/**
 * Clase Abogado que extiende Usuario y representa a un abogado con un atributo adicional especialidad
 */
public class Abogado extends Usuario {
    private String especialidad;

    // Constructor
    public Abogado(int id, String nombre, String apellido, String email, String especialidad) {
        super(id, nombre, apellido, email);
        this.especialidad = especialidad;
    }

    // Métodos getter y setter
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return super.toString() + " - Especialidad: " + especialidad;
    }
}
