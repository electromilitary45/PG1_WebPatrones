package com.techsupport.hub.controller;
//-----Librerias----

import com.techsupport.hub.dao.CitaDao;
import com.techsupport.hub.domain.Cita;
import com.techsupport.hub.service.CitaService;
import com.techsupport.hub.service.ServicioService;
import com.techsupport.hub.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//------importante: Definir que es controllador
@Controller // y se importa el org.springframework.stereotype.Controller; 

public class IndexController {
    @Autowired
    private CitaService citaService;
    
    @Autowired
    private ServicioService servicioService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private CitaDao citaDao;
    
    //---------ruta por defecto-------------
    @GetMapping("/")
    public String inicio(Model model){ //importar springframe.ui.Model
        var cita=citaService.getCita();
        var servicio=servicioService.getServicio();
        var usuarios=usuarioService.getUsuario();
        

        //--------model
        model.addAttribute("cita", cita);
        model.addAttribute("servicio", servicio);
        model.addAttribute("usuario", usuarios);
        
        return "index";
    }

    
    
    
    
    
    
    
    
    
}//fin usuarioController

