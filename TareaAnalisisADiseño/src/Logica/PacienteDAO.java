/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author alber
 */
import BaseDatos.Conexiones;
import Clases.Paciente;
import java.sql.*;

public class PacienteDAO extends Conexiones {

    public boolean registrarPaciente(Paciente p) {
        String sql = "INSERT INTO pacientes(nombre, edad, correo) VALUES (?, ?, ?)";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getEdad());
            ps.setString(3, p.getCorreo());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
