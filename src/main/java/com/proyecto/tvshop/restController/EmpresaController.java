package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.EmpresaService;
import com.proyecto.tvshop.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/enterprises")
    public List<Empresa> showAllEnterprises(){
        return empresaService.listarEmpresas();
    }

    @PostMapping("/enterprises")
    public Empresa addEnterprise(@RequestBody Empresa newEnterprise){
        return empresaService.crearEmpresa(newEnterprise);
    }

    @GetMapping("/enterprises/{id}")
    public Optional<Empresa> showEnterprise(@PathVariable("id") Integer idEnterprise){
        return empresaService.consultarEmpresa(idEnterprise);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa updateEnterprise(@RequestBody Empresa editedEnterprise){
        return empresaService.crearEmpresa(editedEnterprise);
    }

    @DeleteMapping("/enterprises/{id}")
    public String deleteEnterprise(@PathVariable("id") Integer idEnterprise){
        if(empresaService.eliminarEmpresa(idEnterprise)) {
            return "La empresa fue eliminada correctamente";
        }
        return "La empresa no fue eliminada";
    }

}
