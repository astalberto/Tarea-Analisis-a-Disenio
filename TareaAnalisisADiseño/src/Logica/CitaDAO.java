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
import Clases.Cita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO extends Conexiones {

    public boolean agendarCita(Cita c) {
        String sql = "INSERT INTO citas(correo, IdDoctor, fecha, hora, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, c.getCorreo());
            ps.setInt(2, c.getIdDoctor());
            ps.setDate(3, c.getFecha());
            ps.setTime(4, c.getHora());
            ps.setString(5, c.getEstado());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cita> obtenerCitasPorDoctor(String nombre) {
        List<Cita> citas = new ArrayList<>();
        String sql = """
                     SELECT c.id, c.correo, c.idDoctor, c.fecha, c.hora, c.estado
                             FROM citas c
                             INNER JOIN doctores d ON c.idDoctor = d.id
                             WHERE d.nombre = ?
                     """;

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita c = new Cita(
                        rs.getInt("id"),
                        rs.getString("correo"),
                        rs.getInt("idDoctor"),
                        rs.getDate("fecha"),
                        rs.getTime("hora"),
                        rs.getString("estado")
                );
                citas.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return citas;
    }

    public boolean actualizarEstado(int idCita, String nuevoEstado) {
        String sql = "UPDATE citas SET estado = ? WHERE id = ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nuevoEstado);
            ps.setInt(2, idCita);

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
