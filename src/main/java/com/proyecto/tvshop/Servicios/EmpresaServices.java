package com.proyecto.tvshop.Servicios;
import com.proyecto.tvshop.modelos.Empresa;
import java.util.ArrayList;
import java.util.List;

public class EmpresaServices {

    public static List<Empresa> todasEmpresas = new ArrayList<>();

    //El sistema permite consultar todas las empresas
    public static List<Empresa> consultarTodasempresas() {
        return todasEmpresas;
    }

    //El sistema permite consultar una sola empresa
    public static Empresa consultarEmpresa(Integer id_empresa) {

//        int empresaBuscada = 0;
//
//        for(int i=0; i <todasEmpresas.size(); i++){
//            if(todasEmpresas.get(i).getId() == id_empresa){
//                empresaBuscada = i;
//                break;
//            }
//            empresaBuscada= -1;
//
//        }
//        return todasEmpresas.get(empresaBuscada);
        for (int i = 0; i < todasEmpresas.size(); i++) {
            if (todasEmpresas.get(i).getId() == id_empresa) {
                return todasEmpresas.get(i);
            }
        }
        return null;
    }


    //El sistema permite crear una empresa
//    public Empresa crearEmpresa(Integer id, String nombre, String direccion, String telefono, String NIT) {
//
//        Empresa nuevaEmpresa = new Empresa(id, nombre, direccion, telefono, NIT);
//        todasEmpresas.add(nuevaEmpresa);
//
//        return nuevaEmpresa;
//    }

    public static Empresa crearEmpresa(Empresa nuevaEmpresa) {
        todasEmpresas.add(nuevaEmpresa);
        return nuevaEmpresa;
    }


    //    //El sistema permite editar una empresa
//    public Empresa editarEmpresa(Integer id, String nuevoNombre, String nuevaDireccion, String nuevoTelefono,
//                                 String nuevoNIT) {
//
//        Empresa empresaEditada = consultarEmpresa(id);
//
//        empresaEditada.setNombre(nuevoNombre);
//        empresaEditada.setDireccion(nuevaDireccion);
//        empresaEditada.setTelefono(nuevoTelefono);
//        empresaEditada.setNIT(nuevoNIT);
//
//        return empresaEditada;
//    }

    public static Empresa editarEmpresa(Empresa empresa) {
    //Busca el usuario en la lista por el id, metelo en usuarioEditado para setearle los valores
        Empresa empresaEditada = consultarEmpresa(empresa.getId());

        empresaEditada.setNombre(empresa.getNombre());
        empresaEditada.setDireccion(empresa.getDireccion());
        empresaEditada.setTelefono(empresa.getTelefono());
        empresaEditada.setNit(empresa.getNit());

        return empresaEditada;

    }

    //El sistema permite eliminar una empresa
    public static String eliminarEmpresa(Integer id) {

        //Buscamos la empresa a eliminar para tener la posicion en la lista
        Empresa empresaEliminada = consultarEmpresa(id);

        //Preguntamos si esta existe porque puede ser null el return del metodo consultar empresa
        if (empresaEliminada != null) {

            //removemos la empresa de la lista, obteniendo en indice de esta dentro del parentesis
            todasEmpresas.remove(todasEmpresas.indexOf(empresaEliminada));
            return "Empresa con id " + id + "eliminada con exito";
        }
        return "La empresa con id " + id + "no puede ser eliminada, porque no existe";
    }
}

