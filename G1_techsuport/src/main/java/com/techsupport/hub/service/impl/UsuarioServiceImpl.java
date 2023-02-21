
package com.techsupport.hub.service.impl;

import com.techsupport.hub.dao.UsuarioDao;
import com.techsupport.hub.domain.Usuario;
import com.techsupport.hub.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//Se agrega la siguiente @Anotacion
@Service

public class UsuarioServiceImpl implements UsuarioService{
    
    //Unica copia de un objeto
    @Autowired
    private UsuarioDao usuarioDao;
    
    
    //--Metodo Read de todos los Usuarios BD--
    @Override
    public List<Usuario> getUsuario() {
        return (List<Usuario>) usuarioDao.findAll();
    }
    
    //--metodo para encontrar el usuario
    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    //--metodo para borrar
    @Override
    public void deleteUSuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }

    //--metodo guardar
    @Override
    public void saveUSuario(Usuario usuario) {
        usuarioDao.save(usuario);
    }
    
    
    
}
