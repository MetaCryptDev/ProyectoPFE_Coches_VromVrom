package com.proyectojm.app.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACTO")
public class ContactoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "secuencia")
	@SequenceGenerator(name = "secuencia",allocationSize = 1,sequenceName = "SEQ_CONTACTO")
	@Id
	@Column(name = "ID_CONTACTO")
	private Integer id;

	
	@Column(name = "NOMBRE")
	private String nombre;
	

	@Column(name = "MAIL")
	private String mail;
	

	@Column(name = "MOTIVO")
	private String motivo;
	
	@Column(name = "MENSAJE")
	private Integer mensaje;

	
	public ContactoEntity(Integer id, String nombre, String mail, String motivo, Integer mensaje) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.mail = mail;
		this.motivo = motivo;
		this.mensaje = mensaje;
	}

	
	public ContactoEntity() {
	
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	public Integer getMensaje() {
		return mensaje;
	}


	public void setMensaje(Integer mensaje) {
		this.mensaje = mensaje;
	}

}
