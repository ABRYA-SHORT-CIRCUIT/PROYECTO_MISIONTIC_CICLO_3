package com.proyecto.tvshop.modelos;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String correo;

    @Enumerated(EnumType.STRING)
    private Roles rol;

    @Enumerated(EnumType.STRING)
    private State usrState;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private LocalDate usrCreated;  //Fecha de creación del usuario

    private LocalDate usrUpdated;   //Fecha de actualización del usuario



    //Construcctor
    public Usuario() {
    }

    //Construcctor
    public Usuario(String nombre, String correo, Roles rol, Empresa empresa) {
        this.nombre = nombre;
        this.correo = correo;
        this.empresa = empresa;
        this.rol = rol;
        setUsrState(State.ACTIVO);
        this.usrCreated = LocalDate.now();
        this.usrUpdated = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public State getUsrState() {
        return usrState;
    }

    public void setUsrState(State usrState) {
        this.usrState = usrState;
    }

    public LocalDate getUsrCreated() {
        return usrCreated;
    }

    public LocalDate getUsrUpdated() {
        return usrUpdated;
    }

    public void setUsrUpdated() {
        this.usrUpdated = LocalDate.now();
    }


}