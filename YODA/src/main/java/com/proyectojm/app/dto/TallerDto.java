package com.proyectojm.app.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TALLER")
public class TallerDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	
	
	private String CIF;
	
	
	private String descripcion;

	public TallerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TallerDto(Integer id, String cIF, String descripcion) {
		super();
		this.id = id;
		CIF = cIF;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}