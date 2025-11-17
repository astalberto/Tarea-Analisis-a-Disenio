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
import Clases.Doctor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO extends Conexiones {

    // Registrar doctor
    public boolean registrarDoctor(Doctor d) {
        String sql = "INSERT INTO doctores(nombre, especialidad) VALUES (?,?)";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, d.getNombre());
            ps.setString(2, d.getEspecialidad());
            ps.executeUpdate();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Obtener lista de doctores
    public List<Doctor> obtenerDoctores() {
        List<Doctor> lista = new ArrayList<>();
        String sql = "SELECT * FROM doctores";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Doctor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especialidad")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
