package com.techsupport.hub.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
@Entity
@Table(name="cita")
public class Cita implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Cita")
    private Long id_Cita;
    
    //private int id_Usuario;
    //private int id_Servicio;
    private String fecha_Cita;
    private String hora_Cita;
    private String fecha_Rechazada;
    private String url_Mapa;
    private String status;
    
    //---RELACION A CREDITO---
    @JoinColumn(name="id_Servicio",referencedColumnName="id_Servicio")
    @OneToOne
    private Servicio servicio;
    
    //---RELACION A CREDITO---
    @JoinColumn(name="id_Usuario",referencedColumnName="id_Usuario")
    @OneToOne
    private Usuario usuario;

    public Cita() {
    }
    
    /*
    public Cita(int id_Usuario, int id_Servicio, String fecha_Cita, String hora_Cita, String fecha_Rechazada, String url_Mapa, String status) {
        this.id_Usuario = id_Usuario;
        this.id_Servicio = id_Servicio;
        this.fecha_Cita = fecha_Cita;
        this.hora_Cita = hora_Cita;
        this.fecha_Rechazada = fecha_Rechazada;
        this.url_Mapa = url_Mapa;
        this.status = status;
    }*/

    public Cita( String fecha_Cita, String hora_Cita, String fecha_Rechazada, String url_Mapa, String status, Servicio servicio) {
        
        this.fecha_Cita = fecha_Cita;
        this.hora_Cita = hora_Cita;
        this.fecha_Rechazada = fecha_Rechazada;
        this.url_Mapa = url_Mapa;
        this.status = status;
        this.servicio = servicio;
        this.usuario= usuario;
    }
    
    


    
    
}