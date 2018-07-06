package com.example.montes8.demoretrofit2java.model;

public class Producto {

    private int id;
    private String nombre;
    private Double precio;
    private int lote;
    private int stock;
    private String descripcion;

    public Producto(int id, String nombre, Double precio, int lote, int stock, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.lote = lote;
        this.stock = stock;
        this.descripcion = descripcion;
    }
}
