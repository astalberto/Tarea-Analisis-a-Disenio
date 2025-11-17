/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author alber
 */

import Logica.PacienteControlador;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VistaPaciente extends JFrame {

    private JTextField txtNombre, txtEdad, txtCorreo;
    private JButton btnRegistrar;

    private PacienteControlador controller = new PacienteControlador();

    public VistaPaciente() {
        setTitle("Registrar Paciente");
        setSize(300, 250);
        setLayout(null);

        JLabel lbl1 = new JLabel("Nombre:");
        lbl1.setBounds(10, 10, 80, 25);
        add(lbl1);

        txtNombre = new JTextField();
        txtNombre.setBounds(100, 10, 150, 25);
        add(txtNombre);

        JLabel lbl2 = new JLabel("Edad:");
        lbl2.setBounds(10, 50, 80, 25);
        add(lbl2);

        txtEdad = new JTextField();
        txtEdad.setBounds(100, 50, 150, 25);
        add(txtEdad);

        JLabel lbl3 = new JLabel("Correo:");
        lbl3.setBounds(10, 90, 80, 25);
        add(lbl3);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(100, 90, 150, 25);
        add(txtCorreo);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(100, 140, 120, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener((ActionEvent e) -> {
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String correo = txtCorreo.getText();

            if (controller.registrarPaciente(nombre, edad, correo)) {
                JOptionPane.showMessageDialog(this, "Paciente registrado.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar.");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

