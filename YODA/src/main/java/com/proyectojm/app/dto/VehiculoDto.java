package com.proyectojm.app.dto;

import java.io.Serializable;

public class VehiculoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String matricula;
    private String modelo;
    private String marca;
    private UsuarioDto usuario;

    public VehiculoDto() {
        super();
    }

    public VehiculoDto(String matricula, String modelo, String marca, UsuarioDto usuario) {
        super();
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.usuario = usuario;
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

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
