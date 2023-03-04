package com.techsupport.hub.service.impl;

import com.techsupport.hub.dao.CitaDao;
import com.techsupport.hub.domain.Cita;
import com.techsupport.hub.service.CitaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class CitaServiceImpl implements CitaService{
    
    @Autowired
    private CitaDao citaDao;
    
    @Override
    public List<Cita> getCita() {
        return (List<Cita>) citaDao.findAll();
    }

    @Override
    public Cita getCita(Cita cita) {
        return citaDao.findById(cita.getIdCita()).orElse(null);
    }

    @Override
    public void deleteCita(Cita cita) {
        citaDao.delete(cita);
    }

    @Override
    public void saveCita(Cita cita) {
        citaDao.save(cita);
    }    
}
