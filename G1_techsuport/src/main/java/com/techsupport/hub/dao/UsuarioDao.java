/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.techsupport.hub.dao;

import com.techsupport.hub.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Derek
 */
public interface UsuarioDao extends JpaRepository<Usuario,Long>{
    
    
    
}
