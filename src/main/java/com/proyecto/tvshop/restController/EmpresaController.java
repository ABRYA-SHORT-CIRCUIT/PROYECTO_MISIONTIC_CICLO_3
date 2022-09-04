package com.proyecto.tvshop.restController;

import com.proyecto.tvshop.Servicios.EmpresaServices;
import com.proyecto.tvshop.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaController {

      @Autowired
      EmpresaServices empresaServices;

    @GetMapping("/enterprises")
    public List<Empresa> consultarTodasempresas(){
        return EmpresaServices.consultarTodasempresas();
    }

    @PostMapping("/enterprises")
    public Empresa crearEmpresa(@RequestBody Empresa empresaNueva){
        return EmpresaServices.crearEmpresa(empresaNueva);
    }

    @GetMapping("/enterprises/{id}")
    public Empresa consultarEmpresa(@PathVariable("id") Integer id_empresa){
        return EmpresaServices.consultarEmpresa(id_empresa);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@RequestBody Empresa empresa){
        return EmpresaServices.editarEmpresa(empresa);
    }

    @DeleteMapping("/enterprises/{id}")
    public String eliminarEmpresa(@PathVariable("id") Integer idEmpresa){
        return EmpresaServices.eliminarEmpresa(idEmpresa);
    }

}
