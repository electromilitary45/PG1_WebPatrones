/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsupport.hub.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Derek
 */

@Data //y se importa lombok
@Entity
@Table(name="usuario")

public class Usuario implements Serializable{

    //--------ATRIBUTOS-----------
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombre;
    private String primApellido;
    private String segApellido;
    private String correo;
    private String contrasena;
    private String rol;
    private String numTelefono;
    private String status;
    
    
    //---CONSTRUCTOR VACIO
    public Usuario() {
    }
    //---CONSTRUCTOR LLENO
    public Usuario(long idUsuario, String nombre, String primApellido, String segApellido, String correo, String contrasena, String rol, String numTelefono, String status) {
        this.idUsuario=idUsuario;
        this.nombre = nombre;
        this.primApellido = primApellido;
        this.segApellido = segApellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
        this.numTelefono = numTelefono;
        this.status = status;
    }
    
    
    
    
}//fin class Usuario{}
