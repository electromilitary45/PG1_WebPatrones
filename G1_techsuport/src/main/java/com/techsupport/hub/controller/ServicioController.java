
package com.techsupport.hub.controller;

import com.techsupport.hub.domain.Servicio;
import com.techsupport.hub.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Derek
 */
@Controller
@RequestMapping("/servicio")

public class ServicioController {
    @Autowired
    private ServicioService servicioService;
    
    //----ruta por defecto
    @GetMapping("/listado")
    public String inicio(Model model){ //importar springframe.ui.Model
        var servicio=servicioService.getServicio();
        //--------model
        model.addAttribute("servicio", servicio);
        return "/servicio/listado";
    }
     
    @GetMapping("/eliminar/{idServicio}")
    public String eliminaServicio(Servicio servicio){
        servicioService.deleteServicio(servicio);
        return "redirect:/servicio/listado";
    }
    
    @GetMapping("/nuevo")
    public String nuevoServicio(Servicio servicio){
        return "/servicio/modifica";
    }
    
    @PostMapping("/guardar")
    public String guardar(Servicio servicio){
        servicioService.saveServicio(servicio);
        return "redirect:/servicio/listado";
    }
    
    @GetMapping("/editar/{idServicio}")
    public String editaServicio(Servicio servicio, Model model){
        servicio = servicioService.getServicio(servicio);
        model.addAttribute("servicio",servicio);
        return "/servicio/modifica";
    }
    
    @GetMapping("/listadoC")
    public String listadoC(Model model){ //importar springframe.ui.Model
        var servicio=servicioService.getServicio();
        //--------model
        model.addAttribute("servicio", servicio);
        return "/servicio/listadoC";
    }
    
}
