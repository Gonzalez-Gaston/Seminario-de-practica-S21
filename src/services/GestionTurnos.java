package services;

import database.ConexionDB;
import models.*;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestionTurnos para gestionar la lógica de los turnos, incluyendo agregar, mostrar y eliminar turnos
 */
public class GestionTurnos {
    /**
     * Método para agregar un turno a la base de datos
     * @param turno el turno a agregar
     */
    public void agregarTurno(Turno turno) {
        try (Connection conn = ConexionDB.getConnection()) {
            // Insertar cliente
            String insertClienteSQL = "INSERT INTO usuarios (nombre, apellido, email, telefono, tipo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement psCliente = conn.prepareStatement(insertClienteSQL, Statement.RETURN_GENERATED_KEYS)) {
                psCliente.setString(1, turno.getCliente().getNombre());
                psCliente.setString(2, turno.getCliente().getApellido());
                psCliente.setString(3, turno.getCliente().getEmail());
                psCliente.setString(4, turno.getCliente().getTelefono());
                psCliente.setString(5, "Cliente");
                psCliente.executeUpdate();

                // Obtener el ID generado para el cliente
                try (ResultSet rsCliente = psCliente.getGeneratedKeys()) {
                    if (rsCliente.next()) {
                        turno.getCliente().setId(rsCliente.getInt(1));
                    }
                }
            }

            // Insertar abogado
            String insertAbogadoSQL = "INSERT INTO usuarios (nombre, apellido, email, especialidad, tipo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement psAbogado = conn.prepareStatement(insertAbogadoSQL, Statement.RETURN_GENERATED_KEYS)) {
                psAbogado.setString(1, turno.getAbogado().getNombre());
                psAbogado.setString(2, turno.getAbogado().getApellido());
                psAbogado.setString(3, turno.getAbogado().getEmail());
                psAbogado.setString(4, turno.getAbogado().getEspecialidad());
                psAbogado.setString(5, "Abogado");
                psAbogado.executeUpdate();

                // Obtener el ID generado para el abogado
                try (ResultSet rsAbogado = psAbogado.getGeneratedKeys()) {
                    if (rsAbogado.next()) {
                        turno.getAbogado().setId(rsAbogado.getInt(1));
                    }
                }
            }

            // Insertar turno
            String insertTurnoSQL = "INSERT INTO turnos (fechaHora, cliente_id, abogado_id, descripcionProblema, tipo) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement psTurno = conn.prepareStatement(insertTurnoSQL)) {
                psTurno.setTimestamp(1, Timestamp.valueOf(turno.getFechaHora()));
                psTurno.setInt(2, turno.getCliente().getId());
                psTurno.setInt(3, turno.getAbogado().getId());
                psTurno.setString(4, turno instanceof Mediacion ? ((Mediacion) turno).getDescripcionProblema() : null);
                psTurno.setString(5, turno instanceof Consulta ? "Consulta" : "Mediacion");
                psTurno.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al agregar el turno", e);
        }
    }

    /**
     * Método para mostrar todos los turnos desde la base de datos
     */
    public void mostrarTurnos() {
        List<Turno> turnos = new ArrayList<>();
        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT t.id, t.fechaHora, t.tipo, t.descripcionProblema, "
                     + "c.id AS clienteId, c.nombre AS clienteNombre, c.apellido AS clienteApellido, c.email AS clienteEmail, c.telefono AS clienteTelefono, "
                     + "a.id AS abogadoId, a.nombre AS abogadoNombre, a.apellido AS abogadoApellido, a.email AS abogadoEmail, a.especialidad AS abogadoEspecialidad "
                     + "FROM turnos t "
                     + "JOIN usuarios c ON t.cliente_id = c.id "
                     + "JOIN usuarios a ON t.abogado_id = a.id")) {

            while (rs.next()) {
                int turnoId = rs.getInt("id");
                LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();
                String tipo = rs.getString("tipo");

                int clienteId = rs.getInt("clienteId");
                String clienteNombre = rs.getString("clienteNombre");
                String clienteApellido = rs.getString("clienteApellido");
                String clienteEmail = rs.getString("clienteEmail");
                String clienteTelefono = rs.getString("clienteTelefono");
                Cliente cliente = new Cliente(clienteId, clienteNombre, clienteApellido, clienteEmail, clienteTelefono);

                int abogadoId = rs.getInt("abogadoId");
                String abogadoNombre = rs.getString("abogadoNombre");
                String abogadoApellido = rs.getString("abogadoApellido");
                String abogadoEmail = rs.getString("abogadoEmail");
                String abogadoEspecialidad = rs.getString("abogadoEspecialidad");
                Abogado abogado = new Abogado(abogadoId, abogadoNombre, abogadoApellido, abogadoEmail, abogadoEspecialidad);

                Turno turno;
                if ("Consulta".equals(tipo)) {
                    turno = new Consulta(turnoId, fechaHora, cliente, abogado);
                } else {
                    String descripcionProblema = rs.getString("descripcionProblema");
                    turno = new Mediacion(turnoId, fechaHora, cliente, abogado, descripcionProblema);
                }

                turnos.add(turno);
            }

            turnos.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al mostrar los turnos", e);
        }
    }

    /**
     * Método para eliminar un turno de la base de datos
     * @param id el ID del turno a eliminar
     */
    public void eliminarTurno(int id) {
        try (Connection conn = ConexionDB.getConnection()) {
            String deleteTurnoSQL = "DELETE FROM turnos WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(deleteTurnoSQL)) {
                ps.setInt(1, id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 0) {
                    System.out.println("No se encontró un turno con el ID especificado.");
                } else {
                    System.out.println("Turno eliminado con éxito.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el turno", e);
        }
    }
}
