package com.techsupport.hub.controller;

import com.techsupport.hub.domain.Cita;
import com.techsupport.hub.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author sebas
 */
@Controller
@RequestMapping("/cita")
public class CitaController {
    
    @Autowired
    private CitaService citaService;
    
    @GetMapping("/listado")
    public String inicioCita(Model model){ //importar springframe.ui.Model
        var cita=citaService.getCita();
        //--------model
        model.addAttribute("cita", cita);
        return "/cita/listado";
    }
    
    @GetMapping("/eliminar/{id_Cita}")
    public String eliminaCita(Cita cita){
        citaService.deleteCita(cita);
        return "redirect:/cita/listado";
    }
    
    @GetMapping("/nuevo")
    public String nuevaCita(Cita cita){
        return "/cita/modifica";
    }
    
    @PostMapping("/guardar")
    public String guardarCita(Cita cita){
        citaService.saveCita(cita);
        return "redirect:/cita/listado";
    }
    
    @GetMapping("/editar/{id_Cita}")
    public String editaUsuario(Cita cita, Model model){
        cita = citaService.getCita(cita);
        model.addAttribute("cita",cita);
        return "/cita/modifica";
    }
}
