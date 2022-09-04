package com.proyecto.tvshop.Servicios;
import com.proyecto.tvshop.Repositorio.MovimientoRepositorio;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class MovimientoServicio {

    @Autowired
    MovimientoRepositorio movimientoRepositorio;


    //consultar todos los movimientos
    public List<MovimientoDinero> consultarMovimientos() {
        List<MovimientoDinero> listaMovimientos = new ArrayList<>();
        movimientoRepositorio.findAll().forEach(movimiento -> listaMovimientos.add(movimiento));
        return listaMovimientos;
    }

    //consultar movimiento por Id
    public MovimientoDinero MovimientoId(Integer id) {
        return movimientoRepositorio.findById(id).get();
    }

    //guardar o actualizar movimiento
    public MovimientoDinero guardarMovimiento(MovimientoDinero movimiento){
        return  movimientoRepositorio.save(movimiento);
    }

    //Eliminar movimiento
    public boolean borrarMovimiento(Integer id) {
        movimientoRepositorio.deleteById(id);
        if (this.movimientoRepositorio.findById(id).isPresent()) {
            return false;
        }
        return true;
    }


}


