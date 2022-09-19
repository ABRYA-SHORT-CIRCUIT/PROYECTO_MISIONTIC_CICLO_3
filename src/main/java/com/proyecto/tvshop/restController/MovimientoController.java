package com.proyecto.tvshop.restController;


import com.proyecto.tvshop.Servicios.MovimientoService;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoServicio;

    //Consultar todos los movimientos según la empresa
    @GetMapping("/enterprises/{id}/movements")
    public List<MovimientoDinero> consultarMovimientos(@PathVariable("id") Integer id){
        return movimientoServicio.consultarMovimientos(id);
    }

    //Consultar un movimiento por id según la empresa
    @GetMapping("enterprises/{idE}/movements/{idM}")
    public MovimientoDinero transaction(@PathVariable("idM") Integer idM){
        return movimientoServicio.consultarMovimientoId(idM);
    }

    //Guardar movimiento nuevo
    @PostMapping("/enterprises/{id}/movements")
    public MovimientoDinero SaveMovements(@RequestBody MovimientoDinero movimiento) {
        return movimientoServicio.guardarMovimiento(movimiento);
    }

    //Actualizar movimiento, solo para monto y concepto de la transacción
    @PatchMapping("/enterprises/{idE}/movements/{idM}")
    public MovimientoDinero updateMovementId(@PathVariable("idM") Integer id, @RequestBody MovimientoDinero editedMov){
        MovimientoDinero actualMov = movimientoServicio.consultarMovimientoId(id);

        if(movimientoServicio.actualizarMovimiento(id, editedMov) == 2) {
            return editedMov;
        } else {
            return actualMov;
        }
    }

    //Eliminar movimiento
    @DeleteMapping("/enterprises/{idE}/movements/{idM}")
    public String deleteMovement(@PathVariable("idM") Integer id) {
        if (movimientoServicio.borrarMovimiento(id)){
            return "El movimiento fue eliminado correctamente";
        }
        return "El movimiento NO fue eliminado";
    }
}
