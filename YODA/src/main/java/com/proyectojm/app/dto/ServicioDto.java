package com.proyectojm.app.dto;

import java.io.Serializable;

public class ServicioDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer idServicio;
    private String nombre;
    private Double manoDeObra;

    public ServicioDto() {
        super();
    }

    public ServicioDto(Integer idServicio, String nombre, Double manoDeObra) {
        super();
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.manoDeObra = manoDeObra;
    }

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

    public Double getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(Double manoDeObra) {
        this.manoDeObra = manoDeObra;
    }
}
