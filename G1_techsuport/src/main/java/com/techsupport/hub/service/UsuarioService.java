/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.techsupport.hub.service;

import com.techsupport.hub.domain.Usuario;
import java.util.List;

/**
 *
 * @author Derek
 */
public interface UsuarioService {
    
    //-METODO READ DE LA TABLA CLIENTE
    //-y lo coloca en la lista de objetos
    public List<Usuario> getUsuario();
    
    
    //-Obtiene el registro de la tabla usuario
    //-que tiene el idUsuario pasado po el objeto usuario.
    public Usuario getUsuario(Usuario usuario);
    
    //-elimina el registro de la tabla usuario
    //-que tiene el idUsuario pasado po el objeto usuario.
    public void deleteUSuario(Usuario usuario);
    
    //-si el idUsuario pasado no existe o es null se crea uno nuevo en la tabla
    //-que tiene el idUsuario pasado po el objeto usuario.
    //-si el idUsuario, se actualiza la informacion.
    public void saveUSuario(Usuario usuario);
}
