package com.proyecto.tvshop.Repositorios;

import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}