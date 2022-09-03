package com.proyecto.tvshop.modelos;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String correo;
    private String rol; //Administrador-operativo

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


    //Construcctor
    public Usuario() {
    }

    //Construcctor


    public Usuario(int id, String nombre, String correo, String rol, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;

        if (rol.equalsIgnoreCase("administrativo") || rol.equalsIgnoreCase("operativo")) {
            this.rol = rol;
        } else {
            throw new RuntimeException("El rol digitado no es permitido");
        }
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
        if (rol.equals("administrativo") || rol.equals("operativo")) {
            this.rol = rol;
        } else {
            throw new RuntimeException("El rol digitado no es permitido");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
}
