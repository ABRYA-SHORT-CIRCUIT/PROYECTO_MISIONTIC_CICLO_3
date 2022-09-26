package com.proyecto.tvshop.Repositorios;


import com.proyecto.tvshop.modelos.Empresa;
import com.proyecto.tvshop.modelos.Roles;
import com.proyecto.tvshop.modelos.State;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}