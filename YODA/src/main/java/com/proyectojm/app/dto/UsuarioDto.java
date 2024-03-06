package com.proyectojm.app.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

public class UsuarioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id_usuario;

	private String nombre;

	private String apellido1;

	private String apellido2;

	private String mail;

	private String passwd;

	private RolDto rol;

	public UsuarioDto() {
	}

	public UsuarioDto(String id_usuario, String nombre, String apellido1, String apellido2, String mail, String passwd,
			RolDto rol) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.mail = mail;
		this.passwd = passwd;
		this.rol = rol;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public RolDto getRol() {
		return rol;
	}

	public void setRol(RolDto rol) {
		this.rol = rol;
	}

}
