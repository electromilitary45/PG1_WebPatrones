/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    private Long idUsuario;
    
    private String nombre;
    private String primapellido;
    private String segapellido;
    private String correo;
    private String contrasena;
    private String rol;
    private String numtelefono;
    private String status;
    
    
    //---CONSTRUCTOR VACIO
    public Usuario() {
    }
    //---CONSTRUCTOR LLENO
    public Usuario(Long idUsuario, String nombre, String primapellido, String segapellido, String correo, String contrasena, String rol, String numtelefono, String status) {
        this.idUsuario=idUsuario;
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
