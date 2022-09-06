package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.UsuarioRepositorio;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioService {


    @Autowired
    private UsuarioRepositorio usuariorepo;

    public Usuario agregar(Usuario user) {
        return usuariorepo.save(user);
    }

    public Usuario crearUsuario(Usuario usuarioNuevo) {
        usuariorepo.add(usuarioNuevo);

        return usuarioNuevo;

    }

    public Usuario editarUsuario(Usuario user) {
        return usuariorepo.save(user);
    }

    public List<Usuario> listar() {
        return usuariorepo.findAll();
    }

    public void eliminarUsuario(Usuario user) {
        usuariorepo.delete(user);
    }
}
