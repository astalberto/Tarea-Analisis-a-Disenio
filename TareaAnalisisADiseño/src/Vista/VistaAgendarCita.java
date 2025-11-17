/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author alber
 */
import Logica.DoctorDAO;
import Logica.PacienteControlador;
import Clases.Doctor;
import Logica.DoctorControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import java.util.ArrayList;

public class VistaAgendarCita extends JFrame {

    private JComboBox<String> cbDoctor;
    private JTextField txtFecha, txtHora;
    private JButton btnAgendar;

    private PacienteControlador controller = new PacienteControlador();

    // Esta lista sirve para mantener el ID real del doctor
    private List<Doctor> listaDoctores = new ArrayList<>();

    public VistaAgendarCita(String correo) {
        setTitle("Agendar Cita Médica");
        setSize(350, 300);
        setLayout(null);

        JLabel lbl1 = new JLabel("Doctor:");
        lbl1.setBounds(20, 20, 80, 25);
        add(lbl1);

        cbDoctor = new JComboBox<>();
        cbDoctor.setBounds(100, 20, 200, 25);
        add(cbDoctor);

        JLabel lbl2 = new JLabel("Fecha (YYYY-MM-DD):");
        lbl2.setBounds(20, 70, 150, 25);
        add(lbl2);

        txtFecha = new JTextField();
        txtFecha.setBounds(170, 70, 130, 25);
        add(txtFecha);

        JLabel lbl3 = new JLabel("Hora (HH:MM):");
        lbl3.setBounds(20, 120, 120, 25);
        add(lbl3);

        txtHora = new JTextField();
        txtHora.setBounds(170, 120, 130, 25);
        add(txtHora);

        btnAgendar = new JButton("Agendar");
        btnAgendar.setBounds(120, 180, 120, 35);
        add(btnAgendar);

        btnAgendar.addActionListener((ActionEvent e) -> agendar(correo));

        cargarDoctores(); // carga los doctores en el combo

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Carga doctores desde la BD. Aquí deberías tener un DoctorDAO o una lista
     * fija.
     */
    private void cargarDoctores() {
        try {
            DoctorControlador docController = new DoctorControlador();
            listaDoctores = docController.obtenerDoctores();
            for (Doctor d : listaDoctores) {
                cbDoctor.addItem(d.getNombre() + " - " + d.getEspecialidad());
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar doctores.");
            ex.printStackTrace();
        }
    }

    private void agendar(String correo) {

        int indiceDoctor = cbDoctor.getSelectedIndex();
        if (indiceDoctor == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un doctor.");
            return;
        }

        int idDoctor = listaDoctores.get(indiceDoctor).getId();

        try {
            Date fecha = Date.valueOf(txtFecha.getText());
            Time hora = Time.valueOf(txtHora.getText() + ":00");

            boolean ok = controller.agendarCita(correo, idDoctor, fecha, hora);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Cita agendada correctamente.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agendar.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fecha u Hora inválida.");
        }
    }
}
