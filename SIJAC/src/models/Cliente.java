package models;

public class Cliente extends Usuario {
    private String telefono;

    public Cliente(int id, String nombre, String apellido, String email, String telefono) {
        super(id, nombre, apellido, email);
        this.telefono = telefono;
    }

    // Getters y Setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Cliente: " + getNombre() + " " + getApellido() + ", Email: " + getEmail() + ", Teléfono: " + telefono);
    }
}
