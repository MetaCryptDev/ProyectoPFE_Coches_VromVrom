package com.proyectojm.app.dto;

import java.io.Serializable;

public class ServicioDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer idServicio;
    private String nombre;
    private Integer manoDeObra;

    public ServicioDto() {
        super();
    }

    public ServicioDto(Integer idServicio, String nombre, Integer manoDeObra) {
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

    public Integer getManoDeObra() {
        return manoDeObra;
    }

    public void setManoDeObra(Integer manoDeObra) {
        this.manoDeObra = manoDeObra;
    }
}
