/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author alber
 */
import java.sql.Date;
import java.sql.Time;

public class Cita {
    private int id;
    private String correo;
    private int idDoctor;
    private Date fecha;
    private Time hora;
    private String estado; // pendiente, confirmada, cancelada

    public Cita() {}

    public Cita(int id, String correo, int idDoctor, Date fecha, Time hora, String estado) {
        this.id = id;
        this.correo = correo;
        this.idDoctor = idDoctor;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public int getIdDoctor() { return idDoctor; }
    public void setIdDoctor(int idDoctor) { this.idDoctor = idDoctor; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public Time getHora() { return hora; }
    public void setHora(Time hora) { this.hora = hora; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}