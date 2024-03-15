package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEHICULO_SUSTITUCION")
public class VehiculoSustitucionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "PRECIO_POR_DIA")
    private Double precioPorDia;

    @Column(name = "URL_IMAGEN")
    private String urlImagen;

    // Constructor vacío
    public VehiculoSustitucionEntity() {
    }

    // Constructor con todos los campos
    public VehiculoSustitucionEntity(String matricula, String modelo, String marca, Double precioPorDia, String urlImagen) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.precioPorDia = precioPorDia;
        this.urlImagen = urlImagen;
    }

    // Getters y setters
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(Double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
