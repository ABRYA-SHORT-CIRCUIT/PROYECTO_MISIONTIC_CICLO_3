package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.MovimientoRepositorio;
import com.proyecto.tvshop.Repositorios.UsuarioRepositorio;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepositorio usuariorepo;

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    //El sistema permite crear un usuario
    public Usuario crearUsuario(Usuario user) {
        user.setUsrCreated(LocalDate.now());
        return usuariorepo.save(user);
    }

    //El sistema permite actualizar un usuario
    public Usuario actualizarUsuario(Usuario user) {
        user.setUsrUpdated(LocalDate.now());
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
    @Transactional
    public void eliminarUsuario(Integer idUsuario) {

        List<MovimientoDinero> movimientosUsuario = movimientoRepositorio.findByUsuario(idUsuario);
        if(movimientosUsuario == null || movimientosUsuario.isEmpty()){
            usuariorepo.deleteById(idUsuario);

        } else{
            movimientoRepositorio.borrarPorUsuario(idUsuario);
            usuariorepo.deleteById(idUsuario);

        }

    }


}
