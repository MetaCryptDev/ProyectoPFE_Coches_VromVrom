package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_USUARIO")
	private Integer id_usuario;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDO1")
	private String apellido1;

	@Column(name = "APELLIDO2")
	private String apellido2;

	@Column(name = "MAIL")
	private String mail;

	@Column(name = "PASSWD")
	private String passwd;

	@Column(name = "ID_ROL")
	private RolEntity rol;

	public UsuarioEntity() {
	}

	public UsuarioEntity(Integer id_usuario, String nombre, String apellido1, String apellido2, String mail,
			String passwd, RolEntity rol) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.mail = mail;
		this.passwd = passwd;
		this.rol = rol;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
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

	public RolEntity getRol() {
		return rol;
	}

	public void setRol(RolEntity rol) {
		this.rol = rol;
	}

}
