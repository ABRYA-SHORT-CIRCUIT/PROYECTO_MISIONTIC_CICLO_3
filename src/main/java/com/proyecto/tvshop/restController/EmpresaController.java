package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.EmpresaService;
import com.proyecto.tvshop.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/enterprises")
    public List<Empresa> consultarTodasempresas(){

        return empresaService.listarEmpresas();
    }

    @PostMapping("/enterprises")
    public Empresa crearEmpresa(@RequestBody Empresa empresaNueva){
        return empresaService.crearEmpresa(empresaNueva);
    }

    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> consultarEmpresa(@PathVariable("id") Integer id_empresa){
        return empresaService.consultarEmpresa(id_empresa);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@RequestBody Empresa empresa){
        return empresaService.crearEmpresa(empresa);
    }

    @DeleteMapping("/enterprises/{id}")
    public String eliminarEmpresa(@PathVariable("id") Integer idEmpresa){
        boolean response = empresaService.eliminarEmpresa(idEmpresa);
        if(response) {
            return "El usuario fue eliminado correctamente";
        }
        return "El movimiento NO fue eliminado";
    }

}
