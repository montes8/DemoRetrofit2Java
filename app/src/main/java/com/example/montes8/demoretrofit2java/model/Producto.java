package com.example.montes8.demoretrofit2java.model;

public class Producto {

    private int id;
    private String nombre="";
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
