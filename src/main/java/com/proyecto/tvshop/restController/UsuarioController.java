package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.UsuarioServices;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

       @Autowired
       UsuarioServices usuarioServices;

    @GetMapping("/users")
    public List<Usuario> consultarTodosUsuarios() {

        return usuarioServices.consultarTodosUsuarios();
    }

    @PostMapping("/users")
    public Usuario crearUsuario(@RequestBody Usuario usuarioNuevo){
        return usuarioServices.crearUsuario(usuarioNuevo);
    }

    @GetMapping("/user/{id}")
    public Usuario consultarUsuario(@PathVariable("id") Integer id_usuario){
        return usuarioServices.consultarUsuario(id_usuario);
    }

    @PatchMapping("/user/{id}")
    public Usuario editarUsuario(@RequestBody Usuario usuario){

         return usuarioServices.editarUsuario(usuario);
    }

    @DeleteMapping("/user/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id){

        return usuarioServices.eliminarUsuario(id);
    }


}
