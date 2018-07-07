package com.example.montes8.demoretrofit2java.model;

public class Producto {

    private int id ;
    private String nombre;
    private double precio;
    private int lote;
    private int stock;
    private String descripcion;

    public Producto(int id, String nombre, double precio, int lote, int stock, String descripcion) {
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
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

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", lote=" + lote +
                ", stock=" + stock +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
