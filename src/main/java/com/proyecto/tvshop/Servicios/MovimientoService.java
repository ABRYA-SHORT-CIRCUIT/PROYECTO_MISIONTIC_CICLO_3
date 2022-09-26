package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.MovimientoRepositorio;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepositorio movimientoRepositorio;

    //Consultar todos los movimientos creados
    public List<MovimientoDinero> consultarAllMovimientos() {
        return movimientoRepositorio.findAll();
    }


    //consultar todos los movimientos de dinero de una empresa
    public List<MovimientoDinero> consultarMovimientos(Integer idEmpresa) {
        return movimientoRepositorio.findByEmpresa(idEmpresa);
    }

    //Consultar movimiento de dinero por Id
    public MovimientoDinero consultarMovimientoId(Integer id) {
        return movimientoRepositorio.findById(id).get();
    }

    //consultar todos los movimientos de dinero de un usuario
    public List<MovimientoDinero> findByUsuario(Integer idUsuario) {
        return movimientoRepositorio.findByUsuario(idUsuario);
    }


    //Guardar nuevo movimiento
    public Boolean guardarMovimiento(MovimientoDinero movimiento){
        movimiento.setCreatedAt(LocalDate.now());
        MovimientoDinero mov=movimientoRepositorio.save(movimiento);
        if(movimientoRepositorio.findById(mov.getId())!=null){
            return true;
        }
        return false;
    }

    //Actualizar información de movimiento (Monto, Concepto)
    @Transactional
    public int actualizarMovimiento(Integer id, MovimientoDinero movimiento){
        int changes = movimientoRepositorio.updateTransConcById(movimiento.getConcepto(),
                LocalDate.now(),movimiento.getDescripcion(), id);
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
