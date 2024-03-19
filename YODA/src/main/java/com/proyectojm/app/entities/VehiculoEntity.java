package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "VEHICULO")
public class VehiculoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MATRICULA")
    private String matricula;

    @Column(name = "MODELO")
    private String modelo;

    @Column(name = "MARCA")
    private String marca;
    
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private String idUsuario;

    // Constructor vacío
    public VehiculoEntity() {
    }

    // Constructor con todos los campos
    public VehiculoEntity(String matricula, String modelo, String marca, String idUsuario) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
        this.idUsuario = idUsuario;
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

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}
