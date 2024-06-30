package models;

/**
 * Clase Cliente que extiende Usuario y representa a un cliente con un atributo adicional teléfono
 */
public class Cliente extends Usuario {
    private String telefono;

    // Constructor
    public Cliente(int id, String nombre, String apellido, String email, String telefono) {
        super(id, nombre, apellido, email);
        this.telefono = telefono;
    }

    // Métodos getter y setter
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tel: " + telefono;
    }
}
