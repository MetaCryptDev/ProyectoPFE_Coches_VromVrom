package com.proyectojm.app.dto;

import java.io.Serializable;
import java.util.Date;

public class CitaDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer idCita;
    private UsuarioDto usuario;
    private VehiculoDto vehiculo;
    private Date entrada;
    private ServicioDto servicio;
    private VehiculoSustitucionDto vehiculoSustitucion;
    private String descripcionAveria;

    public CitaDto() {
        super();
    }

    public CitaDto(Integer idCita, UsuarioDto usuario, VehiculoDto vehiculo, Date entrada, ServicioDto servicio,
            VehiculoSustitucionDto vehiculoSustitucion, String descripcionAveria) {
        super();
        this.idCita = idCita;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.entrada = entrada;
        this.servicio = servicio;
        this.vehiculoSustitucion = vehiculoSustitucion;
        this.descripcionAveria = descripcionAveria;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    public VehiculoDto getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoDto vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public ServicioDto getServicio() {
        return servicio;
    }

    public void setServicio(ServicioDto servicio) {
        this.servicio = servicio;
    }

    public VehiculoSustitucionDto getVehiculoSustitucion() {
        return vehiculoSustitucion;
    }

    public void setVehiculoSustitucion(VehiculoSustitucionDto vehiculoSustitucion) {
        this.vehiculoSustitucion = vehiculoSustitucion;
    }

    public String getDescripcionAveria() {
        return descripcionAveria;
    }

    public void setDescripcionAveria(String descripcionAveria) {
        this.descripcionAveria = descripcionAveria;
    }
}
