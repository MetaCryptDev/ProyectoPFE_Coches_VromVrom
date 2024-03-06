package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TALLER")
public class TallerEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_TALLER")
	private Integer id;
	
	@Column(name = "CIF")
	private String CIF;
	
	@Column(name = "DESCRIPCION_SOCIAL")
	private String descripcion;

	public TallerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TallerEntity(Integer id, String cIF, String descripcion) {
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
