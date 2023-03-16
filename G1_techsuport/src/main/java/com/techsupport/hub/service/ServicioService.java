
package com.techsupport.hub.service;

import com.techsupport.hub.domain.Servicio;
import java.util.List;

/**
 *
 * @author Derek
 */
public interface ServicioService {
    public List<Servicio> getServicio();
    
    public Servicio getServicio(Servicio servicio);
    
    public void deleteServicio(Servicio servicio);
    
    public void saveServicio(Servicio servicio);
}
