package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.EmpresaService;
import com.proyecto.tvshop.Servicios.UsuarioService;
import com.proyecto.tvshop.modelos.Empresa;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/allUsers")
    public String consultarTodosUsuarios(@ModelAttribute("mensaje") String mensaje, Model model) {
        List<Usuario> listadoUsuarios = usuarioService.listarUsuarios();

        model.addAttribute("listaUsuarios",listadoUsuarios );
        model.addAttribute("mensaje", mensaje);

        return "usuario/usuarios";
    }

    //Ver un usuario por su id
    @GetMapping("/user/{idUsuario}")
    public String consultarUsuario(@PathVariable("idUsuario") Integer id_usuario, Model model){
        Usuario usuario = usuarioService.consultarUsuario(id_usuario);
        model.addAttribute("usuario", usuario);

        return "usuario/ver_usuario";
    }


    //Crear un nuevo usuario
    @GetMapping("users/agregarUsuario")
    public String nuevoUsuario(Model model, @ModelAttribute("mensaje") String mensaje) {

        Usuario user = new Usuario();

        model.addAttribute("user", user);
        model.addAttribute("mensaje", mensaje);


        List<Empresa> listaEmpresa = empresaService.listarEmpresas();
        model.addAttribute("empresaList", listaEmpresa);

        return "usuario/crear_usuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(Usuario usuarioNuevo,RedirectAttributes redirectAttributes){
         usuarioService.crearUsuario(usuarioNuevo);
        redirectAttributes.addFlashAttribute("mensaje", "saveOk");
        return "redirect:/users/allUsers";

    }


    //EDITAR USUARIO

    @GetMapping("/editarUsuario/{idUsuario}")
    public String editarUsuario(@PathVariable("idUsuario") Integer idUsuario, Model model,
                                   @ModelAttribute("mensaje") String mensaje) {

        Usuario usuario = usuarioService.consultarUsuario(idUsuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("mensaje", mensaje);

        List<Empresa> listaEmpresa = empresaService.listarEmpresas();
        model.addAttribute("empresaList", listaEmpresa);


        return "usuario/editar_usuario";
    }

    @PostMapping("/ActualizarUsuario")
    public String actualizarUsuario(Usuario usuario, RedirectAttributes redirectAttributes){
          usuarioService.actualizarUsuario(usuario);

        redirectAttributes.addFlashAttribute("mensaje","updateOK");
         return "redirect:/users/allUsers";
    }


//ELIMINAR USUARIO-CAMBIAR SU STATE
    @GetMapping("/eliminaruser/{idUsuario}")
    public String eliminarUsuario(@PathVariable("idUsuario") Integer idUsuario,
                                  RedirectAttributes redirectAttributes){
        usuarioService.eliminarUsuario(idUsuario);
        redirectAttributes.addFlashAttribute("mensaje","deleteOK");
        return "redirect:/users/allUsers";
    }
}
