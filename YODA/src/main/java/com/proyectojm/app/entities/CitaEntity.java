package com.proyectojm.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CITA")
public class CitaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_CITA")
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "FK_MATRICULA", referencedColumnName = "MATRICULA")
    private VehiculoEntity vehiculo;

    @Column(name = "ENTRADA")
    private LocalDateTime  entrada;
    
    @Column(name = "SALIDA")
    private LocalDateTime  salida;

    @ManyToOne
    @JoinColumn(name = "FK_SERVICIO", referencedColumnName = "ID_SERVICIO")
    private ServicioEntity servicio;

    @ManyToOne
    @JoinColumn(name = "FK_VEHICULO_REPARACION", referencedColumnName = "MATRICULA") //TABLA VEHICULO SUST
    private VehiculoSustitucionEntity vehiculoSustitucion;

    @Column(name = "DESCRIPCION_DE_AVERIA")
    private String descripcionAveria;

    // Constructor vacío
    public CitaEntity() {
    }

	

	public CitaEntity(Integer idCita, UsuarioEntity usuario, VehiculoEntity vehiculo, LocalDateTime entrada,
			LocalDateTime salida, ServicioEntity servicio, VehiculoSustitucionEntity vehiculoSustitucion,
			String descripcionAveria) {
		this.idCita = idCita;
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.salida = salida;
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

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
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

	public ServicioEntity getServicio() {
		return servicio;
	}

	public void setServicio(ServicioEntity servicio) {
		this.servicio = servicio;
	}

	public VehiculoSustitucionEntity getVehiculoSustitucion() {
		return vehiculoSustitucion;
	}

	public void setVehiculoSustitucion(VehiculoSustitucionEntity vehiculoSustitucion) {
		this.vehiculoSustitucion = vehiculoSustitucion;
	}

	public String getDescripcionAveria() {
		return descripcionAveria;
	}

	public void setDescripcionAveria(String descripcionAveria) {
		this.descripcionAveria = descripcionAveria;
	}
    
}
