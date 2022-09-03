package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

//    @Autowired
//    UsuarioServices usuarioServices;

    @GetMapping("/users")
    public List<Usuario> consultarTodosUsuarios() {

        return null;
    }

    @PostMapping("/users")
    public Usuario crearUsuario(@RequestBody Usuario usuarioNuevo){
        return null;
    }

    @GetMapping("/user/{id}")
    public Usuario consultarUsuario(@PathVariable("id") Integer id_usuario){
        return null;
    }

    @PatchMapping("/user/{id}")
    public Usuario editarUsuario(@RequestBody Usuario usuario){

         return null;
    }

    @DeleteMapping("/user/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id){

        return null;
    }
}
