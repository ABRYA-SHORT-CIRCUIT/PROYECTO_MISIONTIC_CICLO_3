package com.proyecto.tvshop.modelos;

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

//    @ManyToOne
//    @JoinColumn(name = "empresa_id")
//    private Empresa empresa;

    private LocalDate movCreated;  //Fecha de creación del movimiento

    private LocalDate movUpdated;   //Fecha de actualización del movimiento
    public MovimientoDinero() {
    }

    public MovimientoDinero(long monto, Concept concepto, String descripcion, Usuario usuario) {
        this.monto = monto;
        this.concepto = concepto;
        this.descripcion = descripcion;
        this.usuario = usuario;
 //       this.empresa = usuario.getEmpresa();
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

//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }

    public LocalDate getMovCreated() {
        return movCreated;
    }

    public LocalDate getMovUpdated() {
        return movUpdated;
    }

    public void setMovUpdated() {
        this.movUpdated = LocalDate.now();
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