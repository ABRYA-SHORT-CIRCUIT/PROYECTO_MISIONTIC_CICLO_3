package com.proyecto.tvshop.modelos;

import javax.persistence.*;

@Entity
@Table(name="Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String nombre;
    private String correo;
    private String rol; //Administrador-operativo

    //    @ManyToOne
    //    @JoinColumn(name = "empresa_id")

    private Empresa empresa;



    //Construcctor
    public Empleado() {
    }

    //Construcctor
    public Empleado(String nombre, String correo, String rol, Empresa empresa) {
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

    public Empresa getEmpresa() {
        return empresa;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", rol='" + rol + '\'' +
                ", empresa=" + empresa +
                '}';
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;



    }
}
