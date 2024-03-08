package com.proyectojm.app.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PIEZA")
public class PiezaDto implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	
	private String descripcion;
	
	
	private Integer coste;

	public PiezaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PiezaDto(Integer id, String descripcion, Integer coste) {
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
