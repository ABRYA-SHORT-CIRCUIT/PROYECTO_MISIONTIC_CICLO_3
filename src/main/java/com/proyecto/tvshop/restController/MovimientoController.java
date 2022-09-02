package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.modelos.MovimientoDinero;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovimientoController {

    List<MovimientoDinero> todosMovimientos = new ArrayList<>();

    @GetMapping("/enterprises/{id}/movements")
    //Buscamos un movimiento de dinero por su ID
    public MovimientoDinero consultarMovimientoId(@PathVariable ("id") int idMovimiento) {

        for(int i=0; i <todosMovimientos.size(); i++){
            //Del movimiento de la posición i , get el id
            if(todosMovimientos.get(i).getId() == idMovimiento) {
                //Si el id movimiento ingresado es igual al de la posicion i
                return todosMovimientos.get(i);
            }
        }
        return null;
    }

    @PostMapping("/enterprises/{id}/movements")
    public MovimientoDinero crearMovimientoDinero(@PathVariable("id") Integer idMovimiento,
                                                    @RequestBody MovimientoDinero movimientoDinero){
        //Creamos un nuevo movimiento de dinero
        MovimientoDinero nuevoMovimiento = new MovimientoDinero();


        //Seteamos el id con el id que llega por la ruta porque no se crea solo, como con la bd
        nuevoMovimiento.setId(idMovimiento);
        //Le seteamos los valores que llegan en movimientoDinero, debe llegar sin id
        nuevoMovimiento.setMonto(movimientoDinero.getMonto());
        nuevoMovimiento.setConcepto(movimientoDinero.getConcepto());
        nuevoMovimiento.setUsuario(movimientoDinero.getUsuario());
        nuevoMovimiento.setEmpresa(movimientoDinero.getEmpresa());

        return nuevoMovimiento;
    }


    @PatchMapping("/enterprises/{id}/movements")
    public MovimientoDinero actualizarMovimientoDinero(@RequestBody MovimientoDinero movimientoDinero,
                                                       @PathVariable("id") Integer idMovimiento) {

        //Buscamos el movimiento a editar en la lista de movimientos

        MovimientoDinero movimientoEditado = consultarMovimientoId(movimientoDinero.getId());

        //No setamos el id, porque buscamos el movimiento a editar y lo agregamos a la variable
        // movimientoEditado y le cambiamos los demás valores
        movimientoEditado.setConcepto(movimientoDinero.getConcepto());
        movimientoEditado.setMonto(movimientoDinero.getMonto());
        movimientoEditado.setUsuario(movimientoDinero.getUsuario());
        movimientoEditado.setEmpresa(movimientoDinero.getUsuario().getEmpresa());

        return movimientoEditado;
    }

    @DeleteMapping("/enterprises/{id}/movements")
    public String eliminarMovimiento(@PathVariable ("id") int idMovimiento){
        //Buscamos el movimiento a eliminar en la lista de movimientos

        MovimientoDinero movimientoEliminado = consultarMovimientoId(idMovimiento);
        todosMovimientos.remove(movimientoEliminado);
        return "movimiento eliminado";
    }

    //Método para consultar el movimiento por id de empleado
    @GetMapping("/enterprises/{idEmpleado}/movements")
    public List<MovimientoDinero> consultarMovimientosPorEmpleado(@PathVariable ("idEmpleado") int idUsuario) {

        List<MovimientoDinero> movimientosUsuario=new ArrayList<>();

        for(int i=0; i <todosMovimientos.size(); i++){
            //Del movimiento de la posición i , get el usuario y de este dame su id
            if(todosMovimientos.get(i).getUsuario().getId() == idUsuario){

                //Si el idusuario ingresado es igual al de la posicion i, agregalo a la lista movidel usuario
                movimientosUsuario.add(todosMovimientos.get(i));
            }
        }
        return movimientosUsuario;
    }


}
