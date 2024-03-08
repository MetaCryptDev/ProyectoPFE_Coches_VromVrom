package com.proyectojm.app.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

public class RolDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id_rol;
	private String descripcion;

	public RolDto() {
		super();
	}

	public RolDto(String id_rol, String descripcion) {
		super();
		this.id_rol = id_rol;
		this.descripcion = descripcion;
	}

	public String getId_rol() {
		return id_rol;
	}

	public void setId_rol(String id_rol) {
		this.id_rol = id_rol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
