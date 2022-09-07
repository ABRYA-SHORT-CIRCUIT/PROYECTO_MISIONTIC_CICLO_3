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
    public List<Empresa> consultarTodasempresas(){

        return empresaService.listarEmpresas();
    }

    @PostMapping("/enterprises")
    public Empresa crearEmpresa(@RequestBody Empresa empresaNueva){
        return empresaService.crearEmpresa(empresaNueva);
    }

    @GetMapping("/enterprises/{id}")
    public Empresa consultarEmpresa(@PathVariable("id") Integer id_empresa){
        return empresaService.consultarEmpresa(id_empresa);
    }

    //aca habia un error, no estaba usando la anotacion @Pathvariable para tomar el id de la empresa a actualizar
    //tampoco se estaban seteando los datos de la empresa editada con los nuevos datos ingresados
    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
        Empresa empresaEditada= empresaService.consultarEmpresa(id);
        empresaEditada.setNombre(empresa.getNombre());
        empresaEditada.setDireccion(empresa.getDireccion());
        empresaEditada.setTelefono(empresa.getTelefono());
        empresaEditada.setNit(empresa.getNit());
        return empresaService.crearEmpresa(empresa);
    }

    //Corregí el mensaje del return
    //no me funciona el DELETE en el postman
    @DeleteMapping("/enterprises/{id}")
    public String eliminarEmpresa(@PathVariable("id") Integer idEmpresa){
        boolean response = empresaService.eliminarEmpresa(idEmpresa);
        if(response) {
            return "Empresa eliminada correctamente";
        }
        else{
            return "La empresa no fue eliminada";
    }
    }

}
