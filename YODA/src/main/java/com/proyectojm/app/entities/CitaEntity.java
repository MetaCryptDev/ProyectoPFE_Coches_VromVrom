package com.proyectojm.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CITA")
public class CitaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia")
    @SequenceGenerator(name = "secuencia", allocationSize = 1, sequenceName = "SEQ_CITA")
    @Column(name = "ID_CITA")
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "FK_ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private String usuarioId;

    @ManyToOne
    @JoinColumn(name = "FK_MATRICULA", referencedColumnName = "MATRICULA")
    private String vehiculoMatricula;

    @Column(name = "ENTRADA")
    private LocalDateTime entrada;

    @Column(name = "SALIDA")
    private LocalDateTime salida;

    @ManyToOne
    @JoinColumn(name = "FK_SERVICIO", referencedColumnName = "ID_SERVICIO")
    private Integer servicioId;

    @ManyToOne
    @JoinColumn(name = "FK_VEHICULO_REPARACION", referencedColumnName = "MATRICULA") 
    private String vehiculoSustitucionMatricula;

    @Column(name = "DESCRIPCION_DE_AVERIA")
    private String descripcionAveria;

    // Constructor vacío
    public CitaEntity() {
    }

    // Constructor con todos los campos
    public CitaEntity(Integer idCita, String usuarioId, String vehiculoMatricula, LocalDateTime entrada,
                      LocalDateTime salida, Integer servicioId, String vehiculoSustitucionMatricula,
                      String descripcionAveria) {
        this.idCita = idCita;
        this.usuarioId = usuarioId;
        this.vehiculoMatricula = vehiculoMatricula;
        this.entrada = entrada;
        this.salida = salida;
        this.servicioId = servicioId;
        this.vehiculoSustitucionMatricula = vehiculoSustitucionMatricula;
        this.descripcionAveria = descripcionAveria;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getVehiculoMatricula() {
        return vehiculoMatricula;
    }

    public void setVehiculoMatricula(String vehiculoMatricula) {
        this.vehiculoMatricula = vehiculoMatricula;
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

    public Integer getServicioId() {
        return servicioId;
    }

    public void setServicioId(Integer servicioId) {
        this.servicioId = servicioId;
    }

    public String getVehiculoSustitucionMatricula() {
        return vehiculoSustitucionMatricula;
    }

    public void setVehiculoSustitucionMatricula(String vehiculoSustitucionMatricula) {
        this.vehiculoSustitucionMatricula = vehiculoSustitucionMatricula;
    }

    public String getDescripcionAveria() {
        return descripcionAveria;
    }

    public void setDescripcionAveria(String descripcionAveria) {
        this.descripcionAveria = descripcionAveria;
    }
}
