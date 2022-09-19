package com.proyecto.tvshop.Repositorios;

import com.proyecto.tvshop.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
}
