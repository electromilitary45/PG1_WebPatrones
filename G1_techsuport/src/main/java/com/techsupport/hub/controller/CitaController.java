package com.techsupport.hub.controller;

import com.techsupport.hub.domain.Cita;
import com.techsupport.hub.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sebas
 */
@Controller
public class CitaController {
    
    @Autowired
    private CitaService citaService;
    
    @GetMapping("/cita")
    public String inicioCita(Model model){ //importar springframe.ui.Model
        var citas=citaService.getCita();
        //--------model
        model.addAttribute("cita", citas);
        return "indexCita";
    }
    
    @GetMapping("/cita/eliminar/{idCita}")
    public String eliminaCita(Cita cita){
        citaService.deleteCita(cita);
        return "redirect:/cita";
    }
    
    @GetMapping("/cita/nuevo")
    public String nuevaCita(Cita cita){
        return "modificaCita";
    }
    
    @PostMapping("/cita/guardar")
    public String guardarCita(Cita cita){
        citaService.saveCita(cita);
        return "redirect:/cita";
    }
    
    @GetMapping("/cita/editar/{idCita}")
    public String editaUsuario(Cita cita, Model model){
        cita = citaService.getCita(cita);
        model.addAttribute("cita",cita);
        return "modificaCita";
    }
}
