package com.proyecto.tvshop.modelos;

public enum State {
    ACTIVO("Activo"),
    INACTIVO("Inactivo");

    private String estado;

    private State(String estado){
        this.estado = estado;
    }

    public String getEstado(){
        return estado;
    }
}
