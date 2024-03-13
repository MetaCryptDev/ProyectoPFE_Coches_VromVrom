package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PIEZA")
public class PiezaEntity implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_PIEZA")
	private Integer id;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "COSTE")
	private Integer coste;

	public PiezaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PiezaEntity(Integer id, String descripcion, Integer coste) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.coste = coste;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCoste() {
		return coste;
	}

	public void setCoste(Integer coste) {
		this.coste = coste;
	}
	
	
}
