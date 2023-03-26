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

    private String fecha_Cita;
    private String hora_Cita;
    private String fecha_Rechazada;
    private String url_Mapa;
    private String status;
    
    
    
    ///--RELACION CITA USUARIO
    @JoinColumn(name="id_Usuario",referencedColumnName="id_Usuario")
    @ManyToOne
    private Usuario usuario;
    
    //--RELACION CITA SERVICIO
    @JoinColumn(name="id_Servicio",referencedColumnName="id_Servicio")
    @ManyToOne
    private Servicio servicio;

    public Cita() {
    }

    public Cita(String fecha_Cita, String hora_Cita, String fecha_Rechazada, String url_Mapa, String status, Usuario usuario, Servicio servicio) {
        this.fecha_Cita = fecha_Cita;
        this.hora_Cita = hora_Cita;
        this.fecha_Rechazada = fecha_Rechazada;
        this.url_Mapa = url_Mapa;
        this.status = status;
        this.usuario = usuario;
        this.servicio = servicio;
    }



    
    
    
}