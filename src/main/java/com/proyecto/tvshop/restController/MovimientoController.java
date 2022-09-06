package com.proyecto.tvshop.restController;


import com.proyecto.tvshop.Servicios.MovimientoService;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoController {

    @Autowired
    MovimientoService movimientoServicio;

    //consultar todos los movimientos
    @GetMapping("/enterprises/{id}/movements")
    public List<MovimientoDinero> consultarMovimientos(){
        return movimientoServicio.consultarMovimientos();
    }

    //consultar movimiento por id
    @GetMapping("enterprises/{id}/movimientos")
    public MovimientoDinero movimientoId(@PathVariable("id") Integer id){
        return movimientoServicio.consultarMovimientoId(id);
    }

    //guardar movimiento
    @PostMapping("/enterprises/{id}/movements")
    public MovimientoDinero SaveMovements(@RequestBody MovimientoDinero movimiento) {
        return movimientoServicio.guardarMovimiento(movimiento);
    }

    //actualizar movimiento
    @PatchMapping("/enterprises/{id}/movements")
    public MovimientoDinero updateMovementId(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movement){
        MovimientoDinero movi=movimientoServicio.consultarMovimientoId(id);
        movi.setConcepto(movement.getConcepto());
        movi.setMonto(movement.getMonto());
        movi.setUsuario(movement.getUsuario());
        return movimientoServicio.guardarMovimiento(movi);
    }

    //Eliminar movimiento

    @DeleteMapping("/enterprises/{id}/movements")
    public String deleteMovement(@PathVariable("id") Integer id){
        boolean response= movimientoServicio.borrarMovimiento(id);
        if (response == true){
            return "El movimiento fue eliminado correctamente";
        }
        return "El movimiento NO fue eliminado";
    }


}
