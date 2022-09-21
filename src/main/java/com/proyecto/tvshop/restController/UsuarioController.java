package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.UsuarioService;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/users")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/allUsers")
    public String consultarTodosUsuarios() {
        List<Usuario> listadoUsuarios = usuarioService.listarUsuarios();
        return "usuarios";
    }

    @PostMapping("/users")
    public Usuario crearUsuario(@RequestBody Usuario usuarioNuevo){
        return usuarioService.crearActualizarUsuario(usuarioNuevo);
    }

    @GetMapping("/user/{id}")
    public Usuario consultarUsuario(@PathVariable("id") Integer id_usuario){
        return usuarioService.consultarUsuario(id_usuario);
    }

    @PatchMapping("/user/{id}")
    public Usuario editarUsuario(@RequestBody Usuario usuario){
         return usuarioService.crearActualizarUsuario(usuario);
    }

    @DeleteMapping("/user/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id){
        boolean response = usuarioService.eliminarUsuario(id);
        if(response) {
            return "El usuario fue eliminado correctamente";
        }
        return "El movimiento NO fue eliminado";
    }
}
