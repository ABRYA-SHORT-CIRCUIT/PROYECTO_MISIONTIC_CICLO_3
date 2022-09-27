package com.proyecto.tvshop.modelos;

public enum Concept {
    COMPRA("Compra"),       //Egreso por compra de mercancías
    VENTA("Venta"),        //Ingreso por venta de mercancías
    GASTO("Gasto"),        //Egreso por gastos operativos
    DEVOLUCION("Devolucion"),   //Ingreso por devolución de mercancías a proveedor
    REEMBOLSO("Reembolso");     //Egreso por devolución de mercancías de clientes

    private String nombre;

    private Concept(String nombre){
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

}
