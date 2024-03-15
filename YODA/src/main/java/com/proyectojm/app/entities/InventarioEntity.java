package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVENTARIO")
public class InventarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_PIEZA")
    private Integer idPieza;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO")
    private Double precio;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "URL_IMAGEN")
    private String urlImagen;

    // Constructor vacío
    public InventarioEntity() {
    }

    // Constructor con todos los campos
    public InventarioEntity(Integer idPieza, Integer cantidad, Double precio, String descripcion, String urlImagen) {
        this.idPieza = idPieza;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    // Getters y setters
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
