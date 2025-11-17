package BaseDatos;

/*
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexiones {

    //Conectarse a la BDD
    public Connection con;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.cj.jdbc.Driver"; //cj
        String url = "jdbc:mysql://localhost:3306/sistemaSanJose";
        Class.forName(driver);
        return DriverManager.getConnection(url, "root", "");
    }

    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
        con = getConnection();
        return con;
    }

    public void CerrarConexion() throws SQLException {
        con.close();
    }

     private void crearTablas() {
        Connection con = null;
        Statement stmt = null;
        try {
            con = AbrirConexion();
            stmt = con.createStatement();

            // 1. Tabla Usuario (Tabla Principal)
            String sqlUsuario = "CREATE TABLE IF NOT EXISTS Usuario (" +
                                "idUsuario TEXT PRIMARY KEY," +
                                "nombre TEXT NOT NULL," +
                                "correo TEXT UNIQUE NOT NULL," +
                                "contrasenaHash TEXT NOT NULL," +
                                "rol INTEGER NOT NULL" + // TIPO INT para el codigo de rol
                                ");";
            stmt.execute(sqlUsuario);
            
            // 2. Tabla Doctor (Referencia a Usuario)
            String sqlDoctor = "CREATE TABLE IF NOT EXISTS Doctor (" +
                               "idUsuario TEXT PRIMARY KEY," +
                               "especialidad TEXT NOT NULL," + 
                               "FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE" +
                               ");";
            stmt.execute(sqlDoctor);
            
            // 3. Tabla Paciente (Referencia a Usuario)
            String sqlPaciente = "CREATE TABLE IF NOT EXISTS Paciente (" +
                                 "idUsuario TEXT PRIMARY KEY," +
                                 "FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario) ON DELETE CASCADE" +
                                 ");";
            stmt.execute(sqlPaciente);

            // 4. Tabla Cita (Ahora usa Doctor y Paciente para las FK, según el error reportado)
            String sqlCita = "CREATE TABLE IF NOT EXISTS Cita (" +
                             "idCita TEXT PRIMARY KEY," +
                             "idDoctor TEXT NOT NULL," +
                             "idPaciente TEXT NOT NULL," +
                             "fechaHora TEXT NOT NULL," +
                             "motivo TEXT NOT NULL," +
                             "estado TEXT NOT NULL," +
                             // Las FK deben apuntar a las tablas específicas de rol
                             "FOREIGN KEY(idDoctor) REFERENCES Doctor(idUsuario) ON DELETE CASCADE," +
                             "FOREIGN KEY(idPaciente) REFERENCES Paciente(idUsuario) ON DELETE CASCADE" +
                             ");";
            stmt.execute(sqlCita);
            
            System.out.println("Tablas de Usuario, Doctor, Paciente y Cita verificadas y creadas.");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al crear tablas: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos de DB: " + e.getMessage());
            }
        }
    }
}
