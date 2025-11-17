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
import Clases.Cita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class VistaDoctor extends JFrame {

    private JTable tablaCitas;
    private JComboBox<String> cbEstado;
    private JButton btnActualizar;

    private DoctorControlador controller = new DoctorControlador();

    public VistaDoctor(String nombre) {
        setTitle("Citas del Doctor");
        setSize(600, 400);
        setLayout(null);

        List<Cita> citas = controller.verCitas(nombre);
        String[][] data = new String[citas.size()][6];

        int i = 0;
        for (Cita c : citas) {
            data[i][0] = String.valueOf(c.getId());
            data[i][1] = String.valueOf(c.getCorreo());
            data[i][2] = String.valueOf(c.getFecha());
            data[i][3] = String.valueOf(c.getHora());
            data[i][4] = c.getEstado();
            i++;
        }

        String[] columnas = {"ID", "correo", "Fecha", "Hora", "Estado"};

        tablaCitas = new JTable(data, columnas);
        JScrollPane scroll = new JScrollPane(tablaCitas);
        scroll.setBounds(10, 10, 560, 250);
        add(scroll);

        cbEstado = new JComboBox<>(new String[]{"pendiente", "confirmada", "cancelada"});
        cbEstado.setBounds(10, 280, 150, 25);
        add(cbEstado);

        btnActualizar = new JButton("Cambiar Estado");
        btnActualizar.setBounds(180, 280, 150, 30);
        add(btnActualizar);

        btnActualizar.addActionListener((ActionEvent e) -> {
            int fila = tablaCitas.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Seleccione una cita.");
                return;
            }

            int idCita = Integer.parseInt(tablaCitas.getValueAt(fila, 0).toString());
            String estado = cbEstado.getSelectedItem().toString();

            if (controller.cambiarEstado(idCita, estado)) {
                JOptionPane.showMessageDialog(this, "Estado actualizado.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar.");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
