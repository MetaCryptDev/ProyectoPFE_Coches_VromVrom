package com.proyectojm.app.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CitaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCita;
    private String idUsuario;
    private String idVehiculo;
    private LocalDateTime entrada;
    private LocalDateTime salida;
    private Integer idServicio;
    private String idVehiculoSustitucion;
    private String descripcionAveria;
    private String fecha;
    private String hora;
    private String nombreUsuario;

    public CitaDto() {
        super();
    }


    public CitaDto(Integer idCita, String idUsuario, String idVehiculo, LocalDateTime entrada, LocalDateTime salida,
			Integer idServicio, String idVehiculoSustitucion, String descripcionAveria, String fecha, String hora,
			String nombreUsuario) {
		this.idCita = idCita;
		this.idUsuario = idUsuario;
		this.idVehiculo = idVehiculo;
		this.entrada = entrada;
		this.salida = salida;
		this.idServicio = idServicio;
		this.idVehiculoSustitucion = idVehiculoSustitucion;
		this.descripcionAveria = descripcionAveria;
		this.fecha = fecha;
		this.hora = hora;
		this.nombreUsuario = nombreUsuario;
	}


	public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getIdVehiculoSustitucion() {
        return idVehiculoSustitucion;
    }

    public void setIdVehiculoSustitucion(String idVehiculoSustitucion) {
        this.idVehiculoSustitucion = idVehiculoSustitucion;
    }

    public String getDescripcionAveria() {
        return descripcionAveria;
    }

    public void setDescripcionAveria(String descripcionAveria) {
        this.descripcionAveria = descripcionAveria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    

    public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	@Override
    public String toString() {
        return "CitaDto [idCita=" + idCita + ", idUsuario=" + idUsuario + ", idVehiculo=" + idVehiculo + ", entrada="
                + entrada + ", salida=" + salida + ", idServicio=" + idServicio + ", idVehiculoSustitucion="
                + idVehiculoSustitucion + ", descripcionAveria=" + descripcionAveria + ", fecha=" + fecha + ", hora="
                + hora + "]";
    }

}
