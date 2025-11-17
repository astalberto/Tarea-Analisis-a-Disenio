/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author alber
 */
import Logica.DoctorControlador;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class RegistrarDoctorView extends JFrame {

    private JTextField txtNombre, txtEspecialidad;
    private JButton btnRegistrar;

    private DoctorControlador controller = new DoctorControlador();

    public RegistrarDoctorView() {
        setTitle("Registrar Doctor");
        setSize(350, 250);
        setLayout(null);

        JLabel lbl1 = new JLabel("Nombre:");
        lbl1.setBounds(20, 30, 100, 25);
        add(lbl1);

        txtNombre = new JTextField();
        txtNombre.setBounds(130, 30, 180, 25);
        add(txtNombre);

        JLabel lbl2 = new JLabel("Especialidad:");
        lbl2.setBounds(20, 80, 100, 25);
        add(lbl2);

        txtEspecialidad = new JTextField();
        txtEspecialidad.setBounds(130, 80, 180, 25);
        add(txtEspecialidad);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(110, 140, 120, 30);
        add(btnRegistrar);

        btnRegistrar.addActionListener((ActionEvent e) -> {
            String nombre = txtNombre.getText();
            String esp = txtEspecialidad.getText();

            if (controller.registrar(nombre, esp)) {
                JOptionPane.showMessageDialog(this, "Doctor registrado.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar.");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
