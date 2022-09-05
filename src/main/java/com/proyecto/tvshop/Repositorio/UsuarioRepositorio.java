package com.proyecto.tvshop.Repositorio;

import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
