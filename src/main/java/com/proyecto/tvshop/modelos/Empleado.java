package com.proyecto.tvshop.modelos;

import javax.persistence.*;

@Entity
@Table(name="Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String nombre;
    private String correo;
    private String rol; //Administrador-operativo


    //    @ManyToOne
    //    @JoinColumn(name = "empresa_id")
    private String empresa;//
//    private Empresa empresa;



    //Construcctor
    public Empleado() {
    }

    //Construcctor
    public Empleado(String nombre, String correo, String rol, String empresa) {
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }


}
