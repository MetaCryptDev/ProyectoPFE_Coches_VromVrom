package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "ROL")
public class RolEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_ROL")
	private Integer id_rol;
	@Column(name = "DESCRIPCION")
	private String descripcion;

	public RolEntity() {
		super();
	}

	public RolEntity(Integer id_rol, String descripcion) {
		super();
		this.id_rol = id_rol;
		this.descripcion = descripcion;
	}

	public Integer getId_rol() {
		return id_rol;
	}

	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
