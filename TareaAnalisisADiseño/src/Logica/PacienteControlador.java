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
import Clases.Paciente;

import java.sql.Date;
import java.sql.Time;

public class PacienteControlador {

    private PacienteDAO pacienteDAO = new PacienteDAO();
    private CitaDAO citaDAO = new CitaDAO();

    public boolean registrarPaciente(String nombre, int edad, String correo) {
        Paciente p = new Paciente(0, nombre, edad, correo);
        return pacienteDAO.registrarPaciente(p);
    }

    public boolean agendarCita(String correo, int idDoctor, Date fecha, Time hora) {
        Cita c = new Cita(0, correo, idDoctor, fecha, hora, "pendiente");
        return citaDAO.agendarCita(c);
    }
}

