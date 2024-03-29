package com.techsupport.hub.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;


@Data //y se importa lombok
@Entity
@Table(name="usuario")

public class Usuario implements Serializable{

    //--------ATRIBUTOS-----------
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Usuario")
    private Long idUsuario;
    
    private String nombre;
    private String primapellido;
    private String segapellido;
    private String correo;
    private String contrasena;
    private String rol;
    private String numtelefono;
    private boolean status;
    
    
    //---CONSTRUCTOR VACIO
    public Usuario() {
    }
    //---CONSTRUCTOR LLENO
    public Usuario( String nombre, String primapellido, String segapellido, String correo, String contrasena, String rol, String numtelefono, boolean status) {
        
        this.nombre = nombre;
        this.primapellido = primapellido;
        this.segapellido = segapellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.numtelefono = numtelefono;
        this.status = status;
    }

}//fin class Usuario{}
