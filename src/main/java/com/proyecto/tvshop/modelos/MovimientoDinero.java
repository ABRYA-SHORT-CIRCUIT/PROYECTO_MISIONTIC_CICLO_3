package com.proyecto.tvshop.modelos;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long monto;
    private Concept concepto;

    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;  //Fecha de creación del movimiento

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate upDateAt;   //Fecha de actualización del movimiento

    public MovimientoDinero() {
        this.createdAt = LocalDate.now();
    }

    public MovimientoDinero(long monto, Concept concepto, String descripcion, Usuario usuario ) {
        this.monto = monto;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.empresa = usuario.getEmpresa();
        this.createdAt = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public Concept getConcepto() {
        return concepto;
    }

    public void setConcepto(Concept concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpDateAt() {
        return upDateAt;
    }

    public void setMovUpdated() {
        this.upDateAt = LocalDate.now();
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpDateAt(LocalDate upDateAt) {
        this.upDateAt = upDateAt;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "id=" + id +
                ", monto=" + monto +
                ", concepto='" + concepto + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}