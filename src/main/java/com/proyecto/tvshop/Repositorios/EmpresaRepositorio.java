package com.proyecto.tvshop.Repositorios;

import com.proyecto.tvshop.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
}
