package com.techsupport.hub.dao;

import com.techsupport.hub.domain.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface CitaDao extends JpaRepository<Cita, Long>{
    
}
