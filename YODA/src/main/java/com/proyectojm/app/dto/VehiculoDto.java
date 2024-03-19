package com.proyectojm.app.dto;

import java.io.Serializable;

public class VehiculoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String matricula;
    private String modelo;
    private String marca;
    private String idUsuario;

    public VehiculoDto() {
        super();
    }

    public VehiculoDto(String matricula, String modelo, String marca, String idUsuario) {
        super();
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.idUsuario = idUsuario;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
