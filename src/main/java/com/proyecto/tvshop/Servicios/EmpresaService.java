package com.proyecto.tvshop.Servicios;

import com.proyecto.tvshop.Repositorios.EmpresaRepositorio;
import com.proyecto.tvshop.modelos.Empresa;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmpresaService {

    @Autowired
    EmpresaRepositorio empresaRepositorio;

    public List<Empresa> todasEmpresas = new ArrayList<>();

    // pide todas las empresas
    public List<Empresa> consultarTodasempresas() {
        List<Empresa> todasEmpresas = new ArrayList<>();
        empresaRepositorio.findAll().forEach(empresa -> todasEmpresas.add(empresa));
        return todasEmpresas;
    }

    //consulta una sola empresa
    public Empresa consultarEmpresa(Integer id_empresa) {
        int empresaBuscada = 0;
        for(int i=0; i <todasEmpresas.size(); i++){
            if(todasEmpresas.get(i).getId() == id_empresa){
                empresaBuscada = i;
                break;
            }
            empresaBuscada= -1;
        }
        return todasEmpresas.get(empresaBuscada);
        
    }
    //crea una empresa
    public Empresa crearEmpresa(Integer id, String nombre, String direccion, String telefono, String NIT) {
        Empresa nuevaEmpresa = new Empresa(id, nombre, direccion, telefono, NIT);
        todasEmpresas.add(nuevaEmpresa);
        return nuevaEmpresa;
    }

    public Empresa crearEmpresa(Empresa nuevaEmpresa) {
        todasEmpresas.add(nuevaEmpresa);
        return nuevaEmpresa;
    }


    //edita una empresa
    public Empresa editarEmpresa(Integer id, String nuevoNombre, String nuevaDireccion, String nuevoTelefono, String nuevoNIT) {
        Empresa empresaEditada = consultarEmpresa(id);
        empresaEditada.setNombre(nuevoNombre);
        empresaEditada.setDireccion(nuevaDireccion);
        empresaEditada.setTelefono(nuevoTelefono);
        empresaEditada.setNit(nuevoNIT);
        return empresaEditada;
    }
    public Empresa editarEmpresa(Empresa empresa) {
        Empresa empresaEditada = consultarEmpresa(empresa.getId());
        empresaEditada.setNombre(empresa.getNombre());
        empresaEditada.setDireccion(empresa.getDireccion());
        empresaEditada.setTelefono(empresa.getTelefono());
        empresaEditada.setNit(empresa.getNit());
        return empresaEditada;

    }
    // elimina una empresa
    public String eliminarEmpresa(Integer id) {
        Empresa empresaEliminada = consultarEmpresa(id);
        if (empresaEliminada != null) {
            todasEmpresas.remove(todasEmpresas.indexOf(empresaEliminada));
            return "Empresa con id " + id + "eliminada con exito";
        }
        return "La empresa con id " + id + "no puede ser eliminada, porque no existe";
    }



}
