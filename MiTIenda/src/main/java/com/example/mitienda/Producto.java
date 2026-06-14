package com.example.mitienda;

public class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private String precio;
    private String stock;
    private String estado;

    public Producto(String codigo, String nombre, String categoria,
                    String precio, String stock, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public String getPrecio() { return precio; }
    public String getStock() { return stock; }
    public String getEstado() { return estado; }

    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setPrecio(String precio) { this.precio = precio; }
    public void setStock(String stock) { this.stock = stock; }
    public void setEstado(String estado) { this.estado = estado; }
}