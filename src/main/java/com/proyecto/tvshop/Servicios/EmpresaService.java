package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.EmpresaRepositorio;
import com.proyecto.tvshop.modelos.Empresa;
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
    public Empresa crearEmpresa(Empresa empresa) {
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

    public Empresa actualizarEmpresa(Integer idEnterprise, Empresa editedEnterprise) {
        Optional<Empresa> actualEnterprise = empresaRepositorio.findById(idEnterprise);
        if(actualEnterprise.isPresent()) {
            Empresa updEnterprise = actualEnterprise.get();
            updEnterprise.setNombre(editedEnterprise.getNombre());
            updEnterprise.setDireccion(editedEnterprise.getDireccion());
            updEnterprise.setTelefono(editedEnterprise.getTelefono());
            updEnterprise.setNit(editedEnterprise.getNit());
            updEnterprise.setEntState(editedEnterprise.getEntState());
            updEnterprise.setEntUpdated(LocalDate.now());
            return empresaRepositorio.save(updEnterprise);
        }

        return empresaRepositorio.save(editedEnterprise);
    }
}
