/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

/**
 *
 * @author alber
 */
import javax.swing.*;
import java.awt.event.ActionEvent;

public class VistaMenuDoctor extends JFrame {

    private JButton btnRegistrar, btnVerCitas;

    public VistaMenuDoctor() {
        setTitle("Menú Doctor");
        setSize(350, 250);
        setLayout(null);

        btnRegistrar = new JButton("Registrar doctor");
        btnRegistrar.setBounds(80, 40, 180, 35);
        add(btnRegistrar);

        btnVerCitas = new JButton("Ver citas asignadas");
        btnVerCitas.setBounds(80, 100, 180, 35);
        add(btnVerCitas);

        btnRegistrar.addActionListener((ActionEvent e) -> new RegistrarDoctorView());

        btnVerCitas.addActionListener((ActionEvent e) -> {
            String nombre = JOptionPane.showInputDialog("Ingrese su Nombre de doctor:");
            new VistaDoctor(nombre);
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
