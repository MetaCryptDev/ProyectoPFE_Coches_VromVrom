package com.proyectojm.app.dto;

import java.io.Serializable;

public class VehiculoSustitucionDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String matricula;
    private String modelo;
    private String marca;
    private Double precioPorDia;
    private String urlImagen;

    public VehiculoSustitucionDto() {
        super();
    }

    public VehiculoSustitucionDto(String matricula, String modelo, String marca, Double precioPorDia, String urlImagen) {
        super();
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.precioPorDia = precioPorDia;
        this.urlImagen = urlImagen;
    }

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
