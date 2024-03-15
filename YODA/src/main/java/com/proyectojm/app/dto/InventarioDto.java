package com.proyectojm.app.dto;

import java.io.Serializable;

public class InventarioDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer idPieza;
    private Integer cantidad;
    private Double precio;
    private String descripcion;
    private String urlImagen;

    public InventarioDto() {
        super();
    }

    public InventarioDto(Integer idPieza, Integer cantidad, Double precio, String descripcion, String urlImagen) {
        super();
        this.idPieza = idPieza;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Integer getIdPieza() {
        return idPieza;
    }

    public void setIdPieza(Integer idPieza) {
        this.idPieza = idPieza;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
