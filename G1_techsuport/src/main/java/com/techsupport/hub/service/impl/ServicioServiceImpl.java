/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techsupport.hub.service.impl;

import com.techsupport.hub.dao.ServicioDao;
import com.techsupport.hub.domain.Servicio;
import com.techsupport.hub.service.ServicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Derek
 */
@Service

public class ServicioServiceImpl implements ServicioService{

    @Autowired
    private ServicioDao servicioDao;
    
    @Override
    public List<Servicio> getServicio() {
        return (List<Servicio>) servicioDao.findAll();
    }

    @Override
    public Servicio getServicio(Servicio servicio) {
        return servicioDao.findById(servicio.getIdServicio()).orElse(null);
    }

    @Override
    public void deleteServicio(Servicio servicio) {
        servicioDao.delete(servicio);
    }

    @Override
    public void saveServicio(Servicio servicio) {
        servicioDao.save(servicio);
    }
    
}
