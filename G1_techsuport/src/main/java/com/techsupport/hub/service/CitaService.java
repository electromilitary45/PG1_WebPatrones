package com.techsupport.hub.service;

import com.techsupport.hub.domain.Cita;
import java.util.List;

/**
 *
 * @author sebas
 */
public interface CitaService {
    public List<Cita> getCita();
    
    public Cita getCita(Cita cita);
    
    public void deleteCita(Cita cita);
    
    public void saveCita(Cita cita);
}
