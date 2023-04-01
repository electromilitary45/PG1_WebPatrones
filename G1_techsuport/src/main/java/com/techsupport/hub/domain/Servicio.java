
package com.techsupport.hub.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Derek
 */
@Data
@Entity
@Table(name="servicio")

public class Servicio implements Serializable{
    
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Servicio")
    private Long idServicio;
    
    private String imagen;
    private String nombreServicio;
    private String descripcion;
    private long precio;
    private boolean status;
    
    

    public Servicio(){}

    public Servicio(String imagen, String nombreServicio, String descripcion, long precio, boolean status) {
        this.imagen = imagen;
        this.nombreServicio = nombreServicio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.status = status;
    }
    
    
    
}
