package com.proyecto.tvshop.modelos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;

//import javax.persistence.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Empresa", uniqueConstraints = {@UniqueConstraint(columnNames = {"nombre"})})
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotNull
    @Column(name = "creado")
    private LocalDate entCreated;  //Fecha de creación de la empresa

    //@NotNull
    @Column(name = "nombre")
    private String nombre;

    //@NotNull
    @Column(name = "NIT")
    private String nit;

    //@NotNull
    @Column(name = "direccion")
    private String direccion;

    //@NotNull
    @Column(name = "telefono")
    private String telefono;

    //@NotNull
    private State entState;

    //@NotNull
    @Column(name = "modificado")
    private LocalDate entUpdated;   //Fecha de actualización de la empresa

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<Usuario> entUsers = new HashSet<>();

    public Empresa() {
        setEntState(State.ACTIVO);
        this.entCreated = LocalDate.now();
        this.entUpdated = LocalDate.now();
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
    public void setEntCreated(LocalDate entCreated) {this.entCreated = entCreated;}

    public LocalDate getEntUpdated() {
        return entUpdated;
    }
    public void setEntUpdated(LocalDate entUpdated) {
        this.entUpdated = entUpdated;
    }

    public Set<Usuario> getEntUsers() {
        return entUsers;
    }

    public void setEntUsers(Set<Usuario> entUsers) {
        this.entUsers = entUsers;
        for (Usuario userX: entUsers) {
            userX.getEmpresa();
        }
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", NIT='" + nit + '\'' +
                ", Estado='" + entState + '\'' +
                ", Creado='" + entCreated + '\'' +
                ", Modificado='" + entUpdated + '\'' +
                '}';
    }
}