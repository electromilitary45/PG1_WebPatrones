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
import org.springframework.web.bind.annotation.RequestMapping;

//------importante: Definir que es controllador
@Controller // y se importa el org.springframework.stereotype.Controller; 
@RequestMapping("/usuario")
public class UsuarioController {
    //---se crea objeto tipo UsuarioServices------
    @Autowired
    private UsuarioService usuarioService;
    
    //---------ruta por defecto-------------
    @GetMapping("/listado")
    public String inicio(Model model){ //importar springframe.ui.Model
        var usuarios=usuarioService.getUsuario();
        //--------model
        model.addAttribute("usuario", usuarios);
        return "/usuario/listado";
    }
    
    //---------------ELIMINAR-----------------------------
    @GetMapping("/eliminar/{idUsuario}")
    public String eliminaUsuario(Usuario usuario){
        usuarioService.deleteUSuario(usuario);
        return "redirect:/usuario/listado";
    }
    
    //----------------REDICRECCION A NUEVO CLIENTE-------------------
    @GetMapping("/nuevo")
    public String nuevoUsuario(Usuario usuario){
        return "/usuario/modifica";
    }
    
    //-----------------GUARDAR NEUVO CLIENTE-------------------
    @PostMapping("/guardar")
    public String guardar(Usuario usuario){
        usuarioService.saveUSuario(usuario);
        return "redirect:/usuario/listado";
    }
    
    //-----------------REDIRECCION A PAGINA EDITAR CON OBJETO--------------------------------
    @GetMapping("/editar/{idUsuario}")
    public String editaUsuario(Usuario usuario, Model model){
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario",usuario);
        return "/usuario/modifica";
    }
    
    
    
    
    
    
    
    
    
}//fin usuarioController

