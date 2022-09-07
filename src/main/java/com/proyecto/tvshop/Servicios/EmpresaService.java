package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.EmpresaRepositorio;
import com.proyecto.tvshop.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;


    // pide todas las empresas
    public List<Empresa> listarEmpresas(){
        return empresaRepositorio.findAll();
    }

    //consulta una sola empresa
    public Optional<Empresa> consultarEmpresa(Integer id_empresa) {
        return empresaRepositorio.findById(id_empresa);
    }

    //crea una empresa
    public Empresa crearEmpresa(Empresa empresa) {
        return empresaRepositorio.save(empresa);
    }

    //edita una empresa
    public Empresa editarEmpresa(Empresa empresa){
        return empresaRepositorio.save(empresa);
    }

    // elimina una empresa
    public boolean eliminarEmpresa(Integer id) {
        empresaRepositorio.deleteById(id);
        if(this.empresaRepositorio.findById(id).isPresent()){
            return false;
        }
        return true;
    }

}
