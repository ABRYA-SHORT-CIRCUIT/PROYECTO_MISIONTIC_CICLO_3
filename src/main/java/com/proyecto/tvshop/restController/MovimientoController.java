package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.MovimientoServicio;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovimientoController {

    @Autowired
    MovimientoServicio movimientoServicio;

    //consultar movimiento
    @GetMapping("/enterprises/{id}/movements")
    public MovimientoDinero AllMovementsId(@PathVariable("id") Integer id){
        return movimientoServicio.MovimientosId(id);
    }

    //guardar movimiento
    @PostMapping("/enterprises/{id}/movements")
    public MovimientoDinero SaveMovements(@RequestBody MovimientoDinero movimiento) {
        return movimientoServicio.guardarActualizarMovimiento(movimiento);
    }

    //actualizar movimiento
    @PatchMapping("/enterprises/{id}/movements")
    public MovimientoDinero updateMovementsId(@PathVariable("id") Integer id, @RequestBody MovimientoDinero movement){
        MovimientoDinero movi=movimientoServicio.MovimientosId(id);
        movi.setConcepto(movement.getConcepto());
        movi.setMonto(movement.getMonto());
        movi.setUsuario(movement.getUsuario());
        return movimientoServicio.guardarActualizarMovimiento(movi);
    }

    //Eliminar movimiento

    @DeleteMapping("/enterprises/{id}/movements")
    public String deleteMovement(@PathVariable("id") Integer id){
        boolean response= movimientoServicio.BorrarMovimiento(id);
        if (response == true){
            return "El movimiento fue eliminado correctamente";
        }
        return "El movimiento NO fue eliminado";
    }


}



