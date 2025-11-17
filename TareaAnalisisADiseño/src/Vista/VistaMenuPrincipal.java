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

public class VistaMenuPrincipal extends JFrame {

    private JButton btnPaciente, btnDoctor;

    public VistaMenuPrincipal() {
        setTitle("Menú Principal - Clínica San José");
        setSize(400, 300);
        setLayout(null);

        JLabel lbl = new JLabel("Seleccione su rol:");
        lbl.setBounds(120, 20, 200, 30);
        add(lbl);

        btnPaciente = new JButton("Paciente");
        btnPaciente.setBounds(120, 80, 150, 40);
        add(btnPaciente);

        btnDoctor = new JButton("Doctor");
        btnDoctor.setBounds(120, 150, 150, 40);
        add(btnDoctor);

        btnPaciente.addActionListener((ActionEvent e) -> {
            new VistaMenuPaciente();
        });

        btnDoctor.addActionListener((ActionEvent e) -> {
            new VistaMenuDoctor();
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
