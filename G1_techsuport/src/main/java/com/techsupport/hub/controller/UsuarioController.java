/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsupport.hub.controller;
//-----Librerias----
import com.techsupport.hub.domain.Usuario;
import com.techsupport.hub.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//------importante: Definir que es controllador
@Controller // y se importa el org.springframework.stereotype.Controller; 

public class UsuarioController {
    //---se crea objeto tipo UsuarioServices------
    @Autowired
    private UsuarioService usuarioService;
    //---------ruta por defecto-------------
    @GetMapping("/")
    
    public String inicio(Model model){ //importar springframe.ui.Model
        var usuarios=usuarioService.getUsuario();
        //--------model
        model.addAttribute("usuario", usuarios);
        return "index";
    }
    
    //---------------ELIMINAR-----------------------------
    @GetMapping("/usuario/eliminar/{idUsuario}")
    public String eliminaUsuario(Usuario usuario){
        usuarioService.deleteUSuario(usuario);
        return "redirect:/";
    }
    
    //----------------REDICRECCION A NUEVO CLIENTE-------------------
    @GetMapping("/usuario/nuevo")
    public String nuevoUsuario(Usuario usuario){
        return "modificaUsuario";
    }
    
    //-----------------GUARDAR NEUVO CLIENTE-------------------
    @PostMapping("/usuario/guardar")
    public String guardar(Usuario usuario){
        usuarioService.saveUSuario(usuario);
        return "redirect:/";
    }
    
    //-----------------REDIRECCION A PAGINA EDITAR CON OBJETO--------------------------------
    @GetMapping("/usuario/editar/{idUsuario}")
    public String editaUsuario(Usuario usuario, Model model){
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario",usuario);
        return "modificaUsuario";
    }
    
    
    
    
    
    
    
    
    
}//fin usuarioController

