package com.proyectojm.app.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACTO")
public class ContactoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Integer id;

	
	
	private String nombre;
	
	
	private String apellidos;
	

	
	private String mail;
	

	
	private String consulta;
	
	
	private Integer contestado;

	public ContactoDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContactoDto(Integer id, String nombre, String apellidos, String mail, String consulta,
			Integer contestado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mail = mail;
		this.consulta = consulta;
		this.contestado = contestado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public Integer getContestado() {
		return contestado;
	}

	public void setContestado(Integer contestado) {
		this.contestado = contestado;
	}

}
