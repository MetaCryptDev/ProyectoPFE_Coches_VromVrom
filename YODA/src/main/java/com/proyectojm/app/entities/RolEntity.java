package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//holi hiiiiiii
@Entity
@Table(name="ROL")
public class RolEntity implements Serializable{

	private static final long serialVersionUID=1L;
	
	@Id
	@Column(name="ID_ROL")
	private String id_rol;
	@Column(name="DESCRIPCION")
	private String descripcion;
	public RolEntity() {
		super();
	}
	public RolEntity(String id_rol, String descripcion) {
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
