package models;

public class Abogado extends Usuario {
    private String especialidad;

    public Abogado(int id, String nombre, String apellido, String email, String especialidad) {
        super(id, nombre, apellido, email);
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Abogado: " + getNombre() + " " + getApellido() + ", Email: " + getEmail() + ", Especialidad: " + especialidad);
    }
}
