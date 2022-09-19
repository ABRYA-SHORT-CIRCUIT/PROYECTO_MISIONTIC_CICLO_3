package com.proyecto.tvshop.modelos;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String nit;

    @Column(name = "estado")
    private State entState;

    @Column(name = "creado")
    private LocalDate entCreated;  //Fecha de creación de la empresa

    @Column(name = "modificado")
    private LocalDate entUpdated;   //Fecha de actualización de la empresa

    public Empresa() {
    }

    public Empresa(String nombre, String direccion, String telefono, String nit) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
        setEntState(State.ACTIVO);
        this.entCreated = LocalDate.now();
        this.entUpdated = LocalDate.now();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public State getEntState() {
        return entState;
    }

    public void setEntState(State entState) {
        this.entState = entState;
    }
    public LocalDate getEntCreated() {
        return entCreated;
    }

    public LocalDate getEntUpdated() {
        return entUpdated;
    }

    public void setEntUpdated() {
        this.entUpdated = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", NIT='" + nit + '\'' +
                '}';
    }
}