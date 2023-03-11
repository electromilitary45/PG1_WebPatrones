/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsupport.hub.controller;
//-----Librerias----

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//------importante: Definir que es controllador
@Controller // y se importa el org.springframework.stereotype.Controller; 

public class IndexController {
    
    //---------ruta por defecto-------------
    @GetMapping("/")
    public String inicio(Model model){ //importar springframe.ui.Model
        return "index";
    }

    
    
    
    
    
    
    
    
    
}//fin usuarioController

