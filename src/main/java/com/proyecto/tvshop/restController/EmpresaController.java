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
    public List<Empresa> showAllEnterprises()
    {
        return empresaService.listarEmpresas();
    }

    @PostMapping("/enterprises")
    public Empresa addEnterprise(@RequestBody Empresa newEnterprise){
        return empresaService.crearEmpresa(newEnterprise);
    }

    @GetMapping("/enterprises/{id}")
    public Empresa showEnterprise(@PathVariable("id") Integer idEnterprise){
        Optional<Empresa> fndEnterprise = empresaService.consultarEmpresa(idEnterprise);
        return fndEnterprise.isEmpty()? new Empresa() : fndEnterprise.get();
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa updateEnterprise(@PathVariable("id") Integer idEnterprise, @RequestBody Empresa editedEnterprise){
        return empresaService.actualizarEmpresa(idEnterprise, editedEnterprise);
    }

    @DeleteMapping("/enterprises/{id}")
    public String deleteEnterprise(@PathVariable("id") Integer idEnterprise){
        if(empresaService.eliminarEmpresa(idEnterprise)) {
            return "La empresa fue eliminada correctamente";
        }
        return "La empresa no fue eliminada";
    }

}
