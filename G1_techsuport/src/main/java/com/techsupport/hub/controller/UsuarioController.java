/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsupport.hub.controller;
//-----Librerias----
import com.techsupport.hub.domain.Usuario;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//------importante: Definir que es controllador
@Controller // y se importa el org.springframework.stereotype.Controller; 

public class UsuarioController {
    //---se crea objeto------
    
    
    
    
    //---------ruta por defecto-------------
    @GetMapping("/") 
    public String index(Model model){ //importar springframe.ui.Model
        
        //--OBJETOS--
        Usuario usuario = new Usuario(0, "Derek", "Leiva", "Villalobos","dereklevilla45@gmail.com", "asd123", "administrador", "88884444", "activo");
        Usuario usuario2= new Usuario(1, "Derek1", "Leiva", "Villalobos","dereklevilla45@gmail.com", "asd123", "administrador", "88884444", "activo");
        Usuario usuario3 = new Usuario(2, "Derek2", "Leiva", "Villalobos","dereklevilla45@gmail.com", "asd123", "administrador", "88884444", "activo");
        
        var usuarios=Arrays.asList(usuario,usuario2,usuario3);
        //--------model
        model.addAttribute("usuario", usuarios);
        
        
        return "index";
    }
    
    
}//fin usuarioController

