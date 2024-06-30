package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase ConexionDB para gestionar la conexión con la base de datos MySQL
 */
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String DB_NAME = "sijac_db";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    /**
     * Método para obtener la conexión con la base de datos específica
     * @return conexión a la base de datos sijac_db
     * @throws SQLException si ocurre un error al conectar
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + "/" + DB_NAME, USER, PASSWORD);
    }

    /**
     * Método para crear la base de datos y las tablas necesarias si no existen
     */
    public static void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            // Crear la base de datos si no existe
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(createDatabaseSQL);

            // Usar la base de datos
            String useDatabaseSQL = "USE " + DB_NAME;
            stmt.executeUpdate(useDatabaseSQL);

            // Crear las tablas si no existen
            String createUsuariosTableSQL = "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "nombre VARCHAR(50) NOT NULL, "
                    + "apellido VARCHAR(50) NOT NULL, "
                    + "email VARCHAR(50) NOT NULL, "
                    + "telefono VARCHAR(15), "
                    + "especialidad VARCHAR(50), "
                    + "tipo VARCHAR(10) NOT NULL)";
            stmt.executeUpdate(createUsuariosTableSQL);

            String createTurnosTableSQL = "CREATE TABLE IF NOT EXISTS turnos ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "fechaHora DATETIME NOT NULL, "
                    + "cliente_id INT NOT NULL, "
                    + "abogado_id INT NOT NULL, "
                    + "descripcionProblema TEXT, "
                    + "tipo VARCHAR(10) NOT NULL, "
                    + "FOREIGN KEY (cliente_id) REFERENCES usuarios(id), "
                    + "FOREIGN KEY (abogado_id) REFERENCES usuarios(id))";
            stmt.executeUpdate(createTurnosTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al inicializar la base de datos", e);
        }
    }
}
