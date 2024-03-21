package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SERVICIOS")
public class ServicioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_SERVICIO")
    private Integer idServicio;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MANO_DE_OBRA")
    private Integer manoDeObra;

    // Constructor vacío
    public ServicioEntity() {
    }

    // Constructor con todos los campos
    public ServicioEntity(Integer idServicio, String nombre, Integer manoDeObra) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.manoDeObra = manoDeObra;
    }

    // Getters y setters
    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(Integer manoDeObra) {
        this.manoDeObra = manoDeObra;
    }
}