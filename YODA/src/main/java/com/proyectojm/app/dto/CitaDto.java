package com.proyectojm.app.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CitaDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idCita;
	private UsuarioDto usuario;
	private VehiculoDto vehiculo;
	private LocalDateTime entrada;
	private LocalDateTime salida;
	private ServicioDto servicio;
	private VehiculoSustitucionDto vehiculoSustitucion;
	private String descripcionAveria;
	private String fecha;
	private String hora;
	private Integer idServicio;

	public CitaDto() {
		super();
	}

	public CitaDto(Integer idCita, UsuarioDto usuario, VehiculoDto vehiculo, LocalDateTime entrada,
			LocalDateTime salida, ServicioDto servicio, VehiculoSustitucionDto vehiculoSustitucion,
			String descripcionAveria, String fecha, String hora, Integer idServicio) {
		this.idCita = idCita;
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.salida = salida;
		this.servicio = servicio;
		this.vehiculoSustitucion = vehiculoSustitucion;
		this.descripcionAveria = descripcionAveria;
		this.fecha = fecha;
		this.hora = hora;
		this.idServicio = idServicio;
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

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	@Override
	public String toString() {
		return "CitaDto [idCita=" + idCita + ", usuario=" + usuario + ", vehiculo=" + vehiculo + ", entrada=" + entrada
				+ ", salida=" + salida + ", servicio=" + servicio + ", vehiculoSustitucion=" + vehiculoSustitucion
				+ ", descripcionAveria=" + descripcionAveria + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

}
