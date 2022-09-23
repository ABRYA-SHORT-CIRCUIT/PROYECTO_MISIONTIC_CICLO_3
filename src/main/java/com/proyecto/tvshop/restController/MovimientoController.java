package com.proyecto.tvshop.restController;


import com.proyecto.tvshop.Servicios.EmpresaService;
import com.proyecto.tvshop.Servicios.MovimientoService;
import com.proyecto.tvshop.Servicios.UsuarioService;
import com.proyecto.tvshop.modelos.Empresa;
import com.proyecto.tvshop.modelos.MovimientoDinero;
import com.proyecto.tvshop.modelos.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/movements")
@Controller
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoServicio;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpresaService empresaService;

    //Consultar todos los movimientos registrados
    @GetMapping("/allMovements")
    public String consultarAllMovimientos(@ModelAttribute("mensaje") String mensaje, Model model){

        List<MovimientoDinero> movList = movimientoServicio.consultarAllMovimientos();

        model.addAttribute("movList",movList );
        model.addAttribute("mensaje", mensaje);

        return "movimiento/movimientos";
    }

    //Guardar movimiento nuevo
    @GetMapping("/agregarMovimiento")
    public String nuevoMovimiento(Model model, @ModelAttribute("mensaje") String mensaje) {

        MovimientoDinero mov = new MovimientoDinero();

        model.addAttribute("movi", mov);
        model.addAttribute("mensaje", mensaje);

        List<Usuario> listaUsuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarioList", listaUsuarios);

        List<Empresa> listaEmpresa = empresaService.listarEmpresas();
        model.addAttribute("empresaList", listaEmpresa);

        return "movimiento/crear_movimiento";
    }

    @PostMapping("/guardarNuevoMovimiento")
    public String SaveMovements(MovimientoDinero movimiento, RedirectAttributes redirectAttributes) {
        if (movimientoServicio.guardarMovimiento(movimiento)) {
            redirectAttributes.addFlashAttribute("mensaje", "saveOk");
            return "redirect:/movements/allMovements";
        }
        redirectAttributes.addFlashAttribute("mensaje", "saveError");
        return "redirect:/movements/agregarMovimiento";
    }


    //VER UN SOLO MOVIMIENTO SEGUN SU ID
    @GetMapping("/verMovimiento/{idMovimiento}")
    public String mostrarMovimiento(@PathVariable("idMovimiento") Integer idMovimiento, Model model){

        MovimientoDinero movimientoDinero = movimientoServicio.consultarMovimientoId(idMovimiento);
        model.addAttribute("movimientoDinero", movimientoDinero);

        return "movimiento/ver_movimiento";
    }


    //EDITAR MOVIMIENTO

    @GetMapping("/editarMovimiento/{idMovimiento}")
    public String editarMovimiento(@PathVariable("idMovimiento") Integer idMovimiento, Model model,
                                   @ModelAttribute("mensaje") String mensaje) {

        MovimientoDinero movimiento = movimientoServicio.consultarMovimientoId(idMovimiento);
        model.addAttribute("movimiento", movimiento);
        model.addAttribute("mensaje", mensaje);


        return "movimiento/editar_movimiento";
    }

    @PostMapping("/ActualizarMovimiento")
    public String updateMovimiento(@ModelAttribute("movi") MovimientoDinero movimiento,
                                   RedirectAttributes redirectAttributes) {


        if (movimientoServicio.actualizarMovimiento(movimiento.getId(),movimiento)!=0){
            redirectAttributes.addFlashAttribute("mensaje","updateOK");
            return "redirect:/movements/allMovements";
        }
        redirectAttributes.addFlashAttribute("mensaje", "updateERROR");
        return "redirect:/movements/allMovements";
    }

    //ELIMINAR MOVIMIENTO
    @GetMapping("/EliminarMovimiento/{idMovimiento}")
    public String eliminarMovimiento(@PathVariable ("idMovimiento") Integer id, RedirectAttributes redirectAttributes){

        if (movimientoServicio.borrarMovimiento(id)==true){
            redirectAttributes.addFlashAttribute("mensaje","deleteOK");
            return "redirect:/movements/allMovements";
        }
        redirectAttributes.addFlashAttribute("mensaje", "deleteError");
        return "redirect:/movements/allMovements";
    }

    //CONSULTAR LOS MOVIMIENTOS DE UN SOLO EMPLEADO
    @GetMapping("movimientosUsuario/{idUsuario}")
    public String consultarMovimientosUsuario(@PathVariable("idUsuario") Integer idUsuario, Model model){
        List<MovimientoDinero> movList = movimientoServicio.findByUsuario(idUsuario);

        model.addAttribute("movList",movList );

        return "movimiento/movimientos";
    }

    //Consultar todos los movimientos según la empresa
    @GetMapping("/enterprises/{id}/movements")
    public List<MovimientoDinero> consultarMovimientos(@PathVariable("id") Integer idEmpresa){
        return movimientoServicio.consultarMovimientos(idEmpresa);
    }

    //Consultar un movimiento por id según la empresa
    @GetMapping("enterprises/{idE}/movements/{idM}")
    public MovimientoDinero transaction(@PathVariable("idM") Integer idM){
        return movimientoServicio.consultarMovimientoId(idM);
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
