package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.EmpresaRepositorio;
import com.proyecto.tvshop.modelos.Empresa;
import com.proyecto.tvshop.modelos.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;


    //Consulta todas las empresas
    public List<Empresa> listarEmpresas(){
        return empresaRepositorio.findAll();
    }

    //Consulta una sola empresa
    public Optional<Empresa> consultarEmpresa(Integer id_empresa) {
        return empresaRepositorio.findById(id_empresa);
    }

    //Crea o actualiza una empresa
    public boolean crearEmpresa(Empresa empresa) {
        empresa.setEntState(State.ACTIVO);
        return (empresaRepositorio.save(empresa).getId() != 0);
    }

    // elimina una empresa
    public boolean eliminarEmpresa(Integer id) {
        empresaRepositorio.deleteById(id);
        if(this.empresaRepositorio.findById(id).isPresent()){
            return false;
        }
        return true;
    }

    public boolean actualizarEmpresa(Integer idEnterprise, Empresa editedEnterprise) {
        Optional<Empresa> actualEnterprise = empresaRepositorio.findById(idEnterprise);
        if (actualEnterprise.isPresent()) {
            editedEnterprise.setId(idEnterprise);
            editedEnterprise.setEntCreated(actualEnterprise.get().getEntCreated());
            editedEnterprise.setEntState(State.ACTIVO);
            editedEnterprise.setEntUpdated(LocalDate.now());
            return (empresaRepositorio.save(editedEnterprise).getId() != 0);
        }

        return false;
    }
}
