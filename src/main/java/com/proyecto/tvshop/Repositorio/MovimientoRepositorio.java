package com.proyecto.tvshop.Repositorio;

import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepositorio extends JpaRepository<MovimientoDinero, Integer> {


}


