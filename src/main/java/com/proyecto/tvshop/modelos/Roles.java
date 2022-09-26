package com.proyecto.tvshop.modelos;

public enum Roles {
    ADMINISTRATIVO("Administrativo"),
    OPERATIVO ("Operativo");

    private String rol;

    private Roles(String rol){
        this.rol = rol;
    }

    public String getRol(){
        return rol;
    }
}
