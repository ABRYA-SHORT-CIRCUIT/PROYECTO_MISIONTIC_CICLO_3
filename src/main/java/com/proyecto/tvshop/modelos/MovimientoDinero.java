package com.proyecto.tvshop.modelos;

import javax.persistence.*;

@Entity
@Table(name = "Movimientos")
public class MovimientoDinero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private long monto;
    private String concepto;
    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    public MovimientoDinero() {
    }

    public MovimientoDinero(int id, long monto, String concepto, Usuario usuario) {
        this.id = id;
        this.monto = monto;
        this.concepto = concepto;
        this.usuario = usuario;
        this.empresa = usuario.getEmpresa();
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

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
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