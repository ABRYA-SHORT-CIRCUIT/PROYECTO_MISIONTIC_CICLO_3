package com.proyecto.tvshop.Repositorios;

import com.proyecto.tvshop.modelos.Concept;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovimientoRepositorio extends JpaRepository<MovimientoDinero, Integer> {
    //Consultar todos los movimientos de una empresa
    @Query(value = "SELECT * FROM Movimientos WHERE empresa_id = ?1", nativeQuery = true)
    List<MovimientoDinero> findByEmpresa(Integer id);

    @Modifying
    @Query(value = "UPDATE MovimientoDinero SET monto = ?1 WHERE id = ?2")
    int updateTransValById(Long val, Integer id);

    @Modifying
    @Query(value = "UPDATE MovimientoDinero SET concepto = ?1 WHERE id = ?2")
    int updateTransConcById(Concept concepto, Integer id);
}

