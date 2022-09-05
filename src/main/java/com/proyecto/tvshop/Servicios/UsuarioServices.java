package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


    @Service
    public class UsuarioServices {

        public  List<Usuario> todosUsuarios = new ArrayList<>();

        //El sistema permite consultar todos los usuarios
        public  List<Usuario> consultarTodosUsuarios() {
            return todosUsuarios;
        }

        //El sistema permite consultar un solo usuario
        public Usuario consultarUsuario(Integer id_usuario) {

            for (int i = 0; i < todosUsuarios.size(); i++) {
                if (todosUsuarios.get(i).getId() == id_usuario) {
                    return todosUsuarios.get(i);
                }
            }
            return null;
        }

        //El sistema permite crear un usuario
//    public Usuario crearUsuario(int id, String nombre, String correo, String rol, Empresa empresa) {
//
//        Usuario nuevoUsuario = new Usuario(id, nombre, correo, rol, empresa);
//        todosUsuarios.add(nuevoUsuario);
//
//        return nuevoUsuario;
//    }
        public  Usuario crearUsuario(Usuario usuarioNuevo) {
            todosUsuarios.add(usuarioNuevo);

            return usuarioNuevo;

        }


        //El sistema permite editar un usuario
//    public Usuario editarUsuario(Integer id, String nuevoNombre, String nuevoCorreo, String nuevoRol,
//                                 Empresa nuevaEmpresa) {

//      Consulto el usuario en la lista, lo meto en una variable y luego le seteo los datos
//        Usuario usuarioEditado = consultarUsuario(id);
//
//        usuarioEditado.setNombre(nuevoNombre);
//        usuarioEditado.setCorreo(nuevoCorreo);
//        usuarioEditado.setRol(nuevoRol);
//        usuarioEditado.setEmpresa(nuevaEmpresa);
//
//        return usuarioEditado;
//    }

        public  Usuario editarUsuario(Usuario usuario) {
//Busca el usuario en la lista por el id, metelo en usuarioEditado para setearle los valores
            Usuario usuarioEditado = consultarUsuario(usuario.getId());

            if (usuarioEditado != null) {
                usuarioEditado.setNombre(usuario.getNombre());
                usuarioEditado.setCorreo(usuario.getCorreo());
                usuarioEditado.setRol(usuario.getRol());
                usuarioEditado.setEmpresa(usuario.getEmpresa());

                return usuarioEditado;
            }
            return null;
        }

        //El sistema permite eliminar un usuario
        public  String eliminarUsuario(Integer id) {

            //Buscamos la empresa a eliminar para tener la posicion en la lista
            Usuario usuarioEliminado = consultarUsuario(id);

            //Preguntamos si esta existe porque puede ser null el return del metodo consultar empresa
            if (usuarioEliminado != null) {

                //removemos la empresa de la lista, obteniendo en indice de esta dentro del parentesis
                todosUsuarios.remove(todosUsuarios.indexOf(usuarioEliminado));
                return "Empresa con id " + id + "eliminada con exito";
            }
            return "La empresa con id " + id + "no puede ser eliminada, porque no existe";
        }
    }




