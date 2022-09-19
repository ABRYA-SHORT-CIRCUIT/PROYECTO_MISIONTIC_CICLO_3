package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.UsuarioRepositorio;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepositorio usuariorepo;

    //El sistema permite crear y actualizar un usuario
    public Usuario crearActualizarUsuario(Usuario user) {
        return usuariorepo.save(user);
    }

    //El sistema permite consultar un solo usuario
    public Usuario consultarUsuario(Integer id){
        return usuariorepo.findById(id).get();
    }

    //El sistema permite consultar todos los usuarios
    public List<Usuario> listarUsuarios() {
        return usuariorepo.findAll();
    }

    //El sistema permite eliminar un usuario
    public boolean eliminarUsuario(Integer id) {
         usuariorepo.deleteById(id);
         if(this.usuariorepo.findById(id).isPresent()){
             return false;
         }
        return true;
    }
}
