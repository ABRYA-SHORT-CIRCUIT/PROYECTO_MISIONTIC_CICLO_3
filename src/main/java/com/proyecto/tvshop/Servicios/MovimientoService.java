package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.MovimientoRepositorio;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;


    //consultar todos los movimientos de dinero
    public List<MovimientoDinero> consultarMovimientos(Integer id) {
        return movimientoRepositorio.findByEmpresa(id);
    }

    //Consultar movimiento de dinero por Id
    public MovimientoDinero consultarMovimientoId(Integer id) {
        return movimientoRepositorio.findById(id).get();
    }

    //Guardar nuevo movimiento
    public MovimientoDinero guardarMovimiento(MovimientoDinero movimiento){
        return  movimientoRepositorio.save(movimiento);
    }

    //Actualizar información de movimiento (Monto, Concepto)
    @Transactional
    public int actualizarMovimiento(Integer id, MovimientoDinero movimiento){
        int changes = movimientoRepositorio.updateTransConcById(movimiento.getConcepto(), id);
        changes += movimientoRepositorio.updateTransValById(movimiento.getMonto(), id);
        return changes;
    }

    //Eliminar movimiento
    @Transactional
    public boolean borrarMovimiento(Integer id) {
        movimientoRepositorio.deleteById(id);
        if (this.movimientoRepositorio.findById(id).isPresent()) {
            return false;
        }
        return true;
    }
}
