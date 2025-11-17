/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author alber
 */
import Clases.Cita;
import Clases.Doctor;
import java.util.List;

public class DoctorControlador {

    private DoctorDAO doctorDAO = new DoctorDAO();
    private CitaDAO citaDAO = new CitaDAO();

    public boolean registrar(String nombre, String especialidad) {
        Doctor d = new Doctor(0, nombre, especialidad);
        return doctorDAO.registrarDoctor(d);
    }

    public List<Doctor> obtenerDoctores() {
        return doctorDAO.obtenerDoctores();
    }

    public List<Cita> verCitas(String nombre) {
        return citaDAO.obtenerCitasPorDoctor(nombre);
    }

    public boolean cambiarEstado(int idCita, String estado) {
        return citaDAO.actualizarEstado(idCita, estado);
    }
}
