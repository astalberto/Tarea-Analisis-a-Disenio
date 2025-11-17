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

public class VistaMenuPaciente extends JFrame {

    private JButton btnRegistrar, btnAgendar;

    public VistaMenuPaciente() {
        setTitle("Menú Paciente");
        setSize(350, 250);
        setLayout(null);

        btnRegistrar = new JButton("Registrar paciente");
        btnRegistrar.setBounds(80, 40, 180, 35);
        add(btnRegistrar);

        btnAgendar = new JButton("Agendar cita");
        btnAgendar.setBounds(80, 100, 180, 35);
        add(btnAgendar);

        btnRegistrar.addActionListener((ActionEvent e) -> new VistaPaciente());

        btnAgendar.addActionListener((ActionEvent e) -> {
            String correo = JOptionPane.showInputDialog("Ingrese correo del paciente:");
            new VistaAgendarCita(correo);
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
