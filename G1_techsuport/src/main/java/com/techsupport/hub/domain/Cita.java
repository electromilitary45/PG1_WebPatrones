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
    private Long idCita;
    
    private int idUsuario;
    private String fechaCita;
    private String horaCita;
    private String fechaRechazo;
    private String URLMapa;
    private String status;

    public Cita() {
    }

    public Cita(Long idCita, int idUsuario, String fechaCita, String horaCita, String fechaRechazo, String URLMapa, String status) {
        this.idCita = idCita;
        this.idUsuario = idUsuario;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.fechaRechazo = fechaRechazo;
        this.URLMapa = URLMapa;
        this.status = status;
    }
}

